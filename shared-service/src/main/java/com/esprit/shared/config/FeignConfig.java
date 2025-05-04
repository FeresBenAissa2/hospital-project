package com.esprit.shared.config;

import org.springframework.context.annotation.Bean;
//import com.esprit.shared.exception.FeignErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
//        return new FeignErrorDecoder();
        return null;
    }
}
