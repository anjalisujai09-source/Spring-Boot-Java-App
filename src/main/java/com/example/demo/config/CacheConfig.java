package com.example.demo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CaffeineCacheManager cacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager("requests");
        manager.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(60, TimeUnit.SECONDS)
                        .maximumSize(1000)
        );
        return manager;
    }
}
