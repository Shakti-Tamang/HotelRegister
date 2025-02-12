package com.microservices;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAdminServer
//enabling AOP
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableCaching
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.microservices.feignclient")
@OpenAPIDefinition(info = @Info(title = "My API for User Auth ", version = "v1",description = "API for authenticating or registering user"))

//fast read write opertaion
//Redis (Remote Dictionary Server) is an open-source, in-memory data store used as a database,
//        cache, and message broker. It stores data in RAM, making it extremely fast compared to
//        disk-based databases like PostgreSQL. Redis supports various data structures,
//        including strings, lists, sets, hashes, and sorted sets. It provides persistence by
//        saving data to disk periodically or in real-time. Redis also supports replication,
//        ensuring data availability across multiple servers. Additionally, it offers Pub/Sub
//        messaging, enabling real-time communication between applications. 🚀

        //in postgres and all it stores data in disk but redis stores in in momory that is ram


//Redis follows master slave architectutre
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
