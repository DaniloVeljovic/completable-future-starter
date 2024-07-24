package de.dveljovic.completable_future_starter.job;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Component
public class SimpleCompletableFutureJob {

    //@EventListener(ApplicationReadyEvent.class)
    public void runJob() {

        var startTime = System.currentTimeMillis();

        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {

            List<CompletableFuture<String>> list = IntStream.range(1, 11).mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                try {
                    return task();
                } catch (InterruptedException e) {
                    return null;
                }
            }, executorService)).toList();

            CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)).join();
            System.out.println("Job ended after " + (System.currentTimeMillis() - startTime));
        }

    }

    String task() throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName() + " running task!");
        Thread.sleep(2000);
        return ("Danilo");
    }
}
