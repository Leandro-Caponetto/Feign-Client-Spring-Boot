package com.feign.client.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
