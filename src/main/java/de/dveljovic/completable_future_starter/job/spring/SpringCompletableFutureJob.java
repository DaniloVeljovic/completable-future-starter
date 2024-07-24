package de.dveljovic.completable_future_starter.job.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Component
public class SpringCompletableFutureJob {

    @Autowired
    private Task task;

    @EventListener(ApplicationReadyEvent.class)
    public void runJob() {
        long startTime = System.currentTimeMillis();
        List<CompletableFuture<String>> list = IntStream.range(1, 40).mapToObj(i -> task.task()).toList();

        CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)).join();

        System.out.println("Job ended after " + (System.currentTimeMillis() - startTime));
    }
}
