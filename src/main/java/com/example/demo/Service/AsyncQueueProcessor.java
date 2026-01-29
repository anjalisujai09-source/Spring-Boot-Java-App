package com.example.demo.Service;

import com.example.demo.model.RequestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AsyncQueueProcessor {

    private final RequestService service;
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedDelay = 10000)
    @Async
    public void processQueue() {
        RequestEntity entity = service.getQueue().poll();
        if (entity != null) {
            restTemplate.postForObject(
                    "https://example.com/api",
                    entity.getPayload(),
                    String.class
            );
            entity.setStatus("PROCESSED");
        }
    }
}

