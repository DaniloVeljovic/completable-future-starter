package de.dveljovic.completable_future_starter.job;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "customFixedPool")
    public ExecutorService customPool() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean(name = "customVirtualPool")
    public ExecutorService customVirtualPool() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    @Bean
    public Semaphore semaphore() {
        return new Semaphore(10);
    }
}
