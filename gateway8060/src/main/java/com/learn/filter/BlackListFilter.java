package com.learn.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class BlackListFilter implements GlobalFilter, Ordered {
    //模拟黑名单，实际可以存入redis或mysql
    private static List<String> blackList = new ArrayList<>();

    static {
        //blackList.add("0:0:0:0:0:0:0:1");//模拟本地地址
    }

    /**
     * 过滤器的核心方法
     *
     * @param exchange 封装了request和response对象的上下文
     * @param chain    网关过滤器链（包含全局和单路由过滤器）
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取客户端ip，判断是否在黑名单中，在的话拒绝，不在就放行
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String clientIp = request.getRemoteAddress().getHostString();
        if (blackList.contains(clientIp)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            System.out.println("在黑名单中，拒绝访问，clientIP="+clientIp);
            DataBuffer wrap = response.bufferFactory().wrap("Request be refused".getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }

    /**
     * 返回值表示当前过滤器的优先级（顺序），数值越小优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
