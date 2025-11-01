package com.khazan.appointment.system.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    private final KeycloakProperties keycloakProperties;

    @Bean("keycloakRestClient")
    public RestClient keycloakRestClient() {
        return RestClient.builder()
                .baseUrl(keycloakProperties.getUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .messageConverters(List.of(new FormHttpMessageConverter(), new MappingJackson2HttpMessageConverter()))
                .build();
    }
}
