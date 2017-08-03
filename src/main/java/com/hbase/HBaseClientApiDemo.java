package com.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 *  这里会发生阻塞
 *  原因有二：
 *      1. 阿里云的服务器有个安全组，需要将2181添加到白名单
 *      2. 要将运行服务器的HBase的主机名加到本地的host
 *      如:47.52.66.199 iZj6c1lcj1nbkmh2orsc93Z
 *
 * Created by dongchunxu on 2017/7/25.
 *
 */
public class HBaseClientApiDemo extends HBaseBase{
    private static final String TABLE_NAME = "myLittleHBaseTable";

    public static void main(String[] args) throws IOException {
        Connection connection = client.connect();
        try {
            Table table = connection.getTable(TableName.valueOf(TABLE_NAME));

            try {
                Put p = new Put(Bytes.toBytes("myLittleRow"));
                p.addColumn(Bytes.toBytes("myLittleFamily"), Bytes.toBytes("someQualifier"),
                        System.currentTimeMillis(), Bytes.toBytes("Some val3e32"));

                table.put(p);

                Get get = new Get(Bytes.toBytes("myLittleRow"));
                get.addFamily(Bytes.toBytes("myLittleFamily"));
                Result r = table.get(get);
                byte[] value = r.getValue(Bytes.toBytes("myLittleFamily"), Bytes.toBytes("someQualifier"));
                String valueStr = Bytes.toString(value);
                System.out.println("GET: " + valueStr);


                //有时候，你并不知道你想要的行是什么?
                Scan scan = new Scan();
                scan.addColumn(Bytes.toBytes("myLittleFamily"), Bytes.toBytes("someQualifier"));
                ResultScanner scanner = table.getScanner(scan);
                try {
//                    for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {
//                        System.out.println("Found Row: " + rr);
//                    }

                    //其实ResultScanner 实现了迭代器模式
                    for (Result rr : scanner) {
                        System.out.println("Found Row: " + rr);
                    }
                } finally {
                    scanner.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (table != null) table.close();
            }
        } finally {
            client.close(connection);
        }

    }


    public static void delete(Table table, String row) {
        // 删除并没有真正的删除，只是创建了称作墓碑的标记
        // 在Major Compaction操作中被清理
        Delete delete = new Delete(Bytes.toBytes(row));
        try {
            table.delete(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.1

    }

}
