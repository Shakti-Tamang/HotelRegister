package com.microservices.asyncthread.services;

import org.bouncycastle.crypto.prng.ThreadedSeedGenerator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Async
    @Override
    public void asyncMethodTest() {
        System.out.println("Aync method service"+"\t"+Thread.currentThread().getName());

    }

    @Async
    public CompletableFuture<String> thraedHeat(){
        return CompletableFuture.supplyAsync(()->{
            return  "jhds";
        });
    }
}
