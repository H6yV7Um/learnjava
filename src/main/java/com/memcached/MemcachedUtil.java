package com.memcached;

import net.spy.memcached.MemcachedClient;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by dongchunxu on 2017/6/24.
 */
public class MemcachedUtil {
    private static MemcachedUtil INSTANCE;

    private MemcachedClient client;

    public static MemcachedUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (MemcachedUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MemcachedUtil();
                    try {
                        INSTANCE.init();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return INSTANCE;
    }

    private void init() throws Exception {
        InputStream in = MemcachedUtil.class.getClassLoader().getResourceAsStream("memcached.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            String[] servers = properties.getProperty("cache.server")
                    .replace(" ", "")
                    .split(",");

            List<InetSocketAddress> addrs = new ArrayList<InetSocketAddress>();
            for (int i = 0; i < servers.length; i++) {
                addrs.add(
                        new InetSocketAddress(
                                servers[i].split(":")[0],
                                Integer.parseInt(servers[i].split(":")[1])
                        )
                );
            }

            client = new MemcachedClient(addrs);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }


    public Object get(String key) {
        return client.get(key);
    }

}
