package com.pattern.cor.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里面保存了所有的filter
 *
 * Created by dongchunxu on 2017/7/18.
 */
public class FilterChain implements Filter {
    //private Object target;
    private List<Filter> filterList = new ArrayList<Filter>();
    //当前调用的索引
    private int index = 0;

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    public void doFilter(FilterChain filterChain) {
        if (index == filterList.size()) {
            //如果是最后一个拦截器了。这时候执行目标方法
            //test
            System.out.println("do some target method.");
            return;
        }

        Filter filter = filterList.get(index++);
        filter.doFilter(filterChain);
    }
}
