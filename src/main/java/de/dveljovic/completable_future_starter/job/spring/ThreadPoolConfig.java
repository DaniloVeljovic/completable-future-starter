package de.dveljovic.completable_future_starter.job.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "customPool")
    public ExecutorService customPool() {
        return Executors.newFixedThreadPool(10);
        //return Executors.newVirtualThreadPerTaskExecutor();
    }
}
