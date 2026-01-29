package com.example.demo.Service;

import com.example.demo.dto.SubmitRequestDto;
import com.example.demo.model.RequestEntity;
import com.example.demo.repository.RequestRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repo;
    @Getter
    private final BlockingQueue<RequestEntity> queue = new LinkedBlockingQueue<>();

    public Long submit(SubmitRequestDto dto) {
        RequestEntity entity = new RequestEntity();
        entity.setPayload(dto.getPayload());
        entity.setStatus("QUEUED");

        repo.save(entity);
        queue.offer(entity);

        return entity.getId();
    }

    @Cacheable(value = "requests", key = "#id")
    public RequestEntity getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

}

