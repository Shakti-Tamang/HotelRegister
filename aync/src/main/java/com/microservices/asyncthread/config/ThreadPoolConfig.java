package com.microservices.asyncthread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    //thread pool of thread  which are available to perform certain task
    //once task is compleated ,thread get back to thread pool and new task to be assigned
    //means threads can be reused
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {

        return new ThreadPoolTaskExecutor();
    }
}
