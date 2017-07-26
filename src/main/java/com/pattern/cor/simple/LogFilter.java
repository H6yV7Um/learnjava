package com.pattern.cor.simple;

/**
 * Created by dongchunxu on 2017/7/18.
 */
public class LogFilter implements Filter {

    public void doFilter(FilterChain filterChain) {
        System.out.println("---------------LogFilter---------------pre");
        filterChain.doFilter(filterChain);
        System.out.println("---------------LogFilter---------------after");
    }

}
