//package com.nextstep.microservice.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//
////@Configuration: This annotation is used to mark a class as a source of bean definitions. It
////        tells Spring that the class contains methods annotated with @Bean that will create
////        and configure beans for the application context.
////
////@Bean: This annotation is used to define a method that creates and returns a bean to be
////        managed by the Spring container. When the @Bean method is called, Spring will
////        automatically register the returned object as a Spring bean in the application
////        context.
////
////        In short, @Configuration marks the class for bean definitions, and @Bean tells
////        Spring to treat the returned object from the method as a bean to be added to the
////        context.
//@Configuration
//public class GatewayCorsConfig {
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:3000");  // Add your frontend origin here
//        config.addAllowedOrigin("http://localhost:8001");  // Add the backend URL if needed   config.addAllowedOrigin("http://localhost:8087");  // Microservice 2
//        config.addAllowedOrigin("http://localhost:8092");  // Microservice 3
//        config.addAllowedOrigin("http://localhost:8093");
//        config.addAllowedOrigin("http://localhost:8069");// Microservice 4
//        config.addAllowedMethod("*");
//        config.addAllowedHeader("*");
//        config.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);  // Apply to all endpoints
//
//        CorsFilter corsFilter = new CorsFilter(source);
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(corsFilter);
//        bean.setOrder(0);  // Set filter order to be the first filter
//        return bean;
//    }
//}
