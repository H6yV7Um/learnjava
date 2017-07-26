package com.pattern.cor.simple;

/**
 *
 * Created by dongchunxu on 2017/7/18.
 */
public class Processor {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new LogFilter());
        filterChain.addFilter(new AccessFilter());

        filterChain.doFilter(filterChain);
    }

}
