package com.pattern.cor.simple;

/**
 * Created by dongchunxu on 2017/7/18.
 */
public class AccessFilter implements Filter {

    public void doFilter(FilterChain filterChain) {
        System.out.println("---------------AccessFilter---------------pre");
        filterChain.doFilter(filterChain);
        System.out.println("---------------AccessFilter---------------after");
    }

}
