package com.cloud.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
//        routes.route("pay",r -> r.path("pay").uri("http://127.0.0.1:8001")).build();
        //https://tieba.baidu.com/index.html
        //https://tieba.baidu.com/index.html
        routes.route("tieba",r -> r.path("/").uri("https://tieba.baidu.com")).build();
        return routes.build();
    }
}
