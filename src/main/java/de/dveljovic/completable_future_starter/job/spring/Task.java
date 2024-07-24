package de.dveljovic.completable_future_starter.job.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Task {

    @Async("customPool")
    public CompletableFuture<String> task() {
        System.out.println("Thread " + Thread.currentThread() + " running task!");
        try {
            //Thread.sleep(2000);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread() + " finished running task!");
        return CompletableFuture.completedFuture("Danilo");
    }
}
