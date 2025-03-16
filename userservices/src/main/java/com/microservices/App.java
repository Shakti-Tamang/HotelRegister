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


//The @SpringBootApplication annotation is a combination of three annotations:
//
//@Configuration – Marks the class as a Spring configuration class.
//@EnableAutoConfigurati on – Enables Spring Boot’s auto-configuration mechanism.
//@ComponentScan – Scans the package where the application is located and registers components (like @Service, @Repository, @Controller).
//
//No, the @Bean annotation requires the class to be marked with @Configuration (or at least @Component) for Spring to recognize and register the bean.
//
//        Why?
//        The @Bean annotation is used inside a class that defines Spring beans programmatically.
//        Without @Configuration, Spring won't scan and register the beans.
//        Example (Works correctly with @Configuration):

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
