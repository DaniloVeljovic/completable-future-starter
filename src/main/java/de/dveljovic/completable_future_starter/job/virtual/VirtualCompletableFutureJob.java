package de.dveljovic.completable_future_starter.job.virtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Component
public class VirtualCompletableFutureJob {

    @Autowired
    private VirtualTask virtualTask;

    //@EventListener(ApplicationReadyEvent.class)
    public void runJob() {
        long startTime = System.currentTimeMillis();
        //try with 40
        List<CompletableFuture<String>> list = IntStream.range(1, 100).mapToObj(i -> virtualTask.task()).toList();

        CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)).join();

        System.out.println("Job ended after " + (System.currentTimeMillis() - startTime));
    }
}
