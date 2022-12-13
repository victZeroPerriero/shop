package com.vglyzin.checkproduct.config;

import com.vglyzin.checkproduct.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {
//    private final WebClient webClient;
//    @Autowired
//    public WebClientConfig(WebClient.Builder webClient) {
//        this.webClient = webClient.baseUrl("http://localhost:8081/api/v1/").build();
//    }
    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().baseUrl("http://localhost:8081/api/v1/").build();
    }

}
