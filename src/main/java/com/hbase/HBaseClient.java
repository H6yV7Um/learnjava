package com.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * Created by dongchunxu on 2017/7/26.
 */
public class HBaseClient {

    public Connection connect() throws IOException {
        //读取classpath下的hbase-site.xml和hbase-default.xml
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.property.clientPort", "2181");
        config.set("hbase.zookeeper.quorum", "47.52.66.199");
        //config.set("hbase.master", "47.52.66.199:37599");

        return ConnectionFactory.createConnection(config);
    }

    public void close(Connection connection) throws IOException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Table getTable(Connection connection, String tableName) throws IOException {
        return connection.getTable(TableName.valueOf(tableName));
    }



}
