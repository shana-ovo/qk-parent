package com.qk.filter;

import com.qk.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.Token;

import java.io.IOException;

/**
 * 过滤器
 */
@Slf4j
/*
指定要拦截的请求：
    /xxx：要拦截的具体请求
    /xxx/*：拦截xxx下的所有请求
    /*：拦截所有请求
 */
@WebFilter("/*")
public class TokenFilter implements Filter {
    /**
     * 初始化方法，在服务器启动时调用，用来做初始化工作（比如环境准备）
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * 过滤方法，每次请求时调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //将servletRequest、servletResponse强制转换为子类对象，功能增强
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.放行登录请求
        String uri = request.getRequestURI();
        log.info("uri:{}",uri);
        if (uri.startsWith("/login")) {
            log.info("本次请求为登录请求，放行");
            filterChain.doFilter(request,response);
            return;
        }

        //2.获取请求头token
        String token = request.getHeader("token");
        log.info("token:{}",token);

        //3.判断是否有token
        if (token == null || token.isEmpty()){
            log.info("本次请求中没有携带token，401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //4.解析token是否合法
        try {
            Claims claims = JwtUtils.parseToken(token);
            log.info("claims:{}",claims);
        } catch (Exception e) {
            log.error("解析token出错，401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        log.info("token正确，继续执行");
        filterChain.doFilter(request,response);
    }

    /**
     * 销毁方法，关闭服务器时，自动执行
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
