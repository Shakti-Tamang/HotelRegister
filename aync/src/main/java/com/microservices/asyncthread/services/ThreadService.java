package com.microservices.asyncthread.services;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface ThreadService {
    public void asyncMethodTest();


    public CompletableFuture<String> thraedHeat();

}
