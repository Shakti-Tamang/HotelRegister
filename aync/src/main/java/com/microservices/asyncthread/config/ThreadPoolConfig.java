package com.microservices.asyncthread.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    private final Logger logger;

    public  ThreadPoolConfig(){
        this.logger= LoggerFactory.getLogger(ThreadPoolConfig.class);
    }
    //thread pool
//  ThreadPool is collections   of thread  which are available to perform certain task
    //once task is compleated ,thread get back to thread pool and new task to be assigned
    //means threads can be reused

//    in thread pool there are multiple threads to perform a task

    //different task are in que the task in front will get first that at rared end
    //so when the first task comes when the thread becomes free that thread will puck the task
//    after compleating the task the thraed will be free and ready to pick another task

    //minimun pool-size:minumum number of thread which should be pre-created
//
//

//    maximun-poolsize:its maximum number of thread can be creating in thread-pool

//    Queue-size:total number of task that can be accomodated in queue

    //    it takes the consideration like memory size cpu
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20);
        threadPoolTaskExecutor.setMaxPoolSize(40);
        threadPoolTaskExecutor.setQueueCapacity(70);
        threadPoolTaskExecutor.setThreadNamePrefix("MyAsyncThread-");
        threadPoolTaskExecutor.setRejectedExecutionHandler((r, executor1) -> logger.warn("Task rejected, thread pool is full and queue is also full"));
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
}
