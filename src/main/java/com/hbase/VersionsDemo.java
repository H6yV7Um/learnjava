package com.hbase;

import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;
import java.util.NavigableMap;

/**
 * Version
 * Created by dongchunxu on 2017/7/26.
 */
public class VersionsDemo extends HBaseBase{

    public static void main(String[] args) throws IOException {

        Connection connection = client.connect();
        Table table = client.getTable(connection, "myLittleHBaseTable");

        Get get = new Get(Bytes.toBytes("myLittleRow"));
        get.setMaxVersions(3);
        Result result =
                table.get(get);
        byte[] value = result.getValue(Bytes.toBytes("myLittleFamily"), Bytes.toBytes("someQualifier"));
        String valueStr = Bytes.toString(value);
        System.out.println("value:" + valueStr);

        NavigableMap<byte[], byte[]> myLittleFamily = result.getFamilyMap(Bytes.toBytes("myLittleFamily"));
        Iterator<byte[]> iterator = myLittleFamily.navigableKeySet().iterator();
        while (iterator.hasNext()) {
            byte[] next = iterator.next();

            byte[] values = myLittleFamily.get(next);
            System.out.println(Bytes.toString(values));
        }

        connection.close();

    }
}
