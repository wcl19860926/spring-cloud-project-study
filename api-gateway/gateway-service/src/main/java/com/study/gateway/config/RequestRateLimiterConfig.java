package com.study.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 自定义限流标志的key，多个维度可以从这里入手
 * exchange对象中获取服务ID、请求信息，用户信息等
 */
@Component
public class RequestRateLimiterConfig {

    /**
     * ip地址限流
     *
     * @return 限流key
     */
    @Primary
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    /**
     * 请求路径限流
     *
     * @return 限流key
     */
    @Bean(value = "apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    /**
     * username限流
     *
     * @return 限流key
     */
    @Bean(value = "userKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }
}
