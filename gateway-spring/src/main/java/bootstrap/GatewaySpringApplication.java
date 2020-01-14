package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewaySpringApplication {

    public static String httpUri = "http://httpbin.org/get";

    public static void main(String[] args) {
        SpringApplication.run(GatewaySpringApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/gateway-bean")
                        .filters(f -> f.addRequestHeader("Hello", "Gateway"))
                        .uri(httpUri))
                .build();
    }

    //这里不能稳定出现fallback，为什么？
    @Bean
    public RouteLocator gatewayRoutesWithHystrix(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/gateway-bean-hystrix")
                        .filters(f -> f.addRequestHeader("Hello", "Gateway-Hystrix"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("gateway-fallback")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("gateway-hystrix-fallback");
    }

}
