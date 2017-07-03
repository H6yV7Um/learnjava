package com.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一旦底层资源被关闭，任务将解除阻塞。
 * 然而，inputstream.read 阻塞却没有进入到异常部分。当你在外面调用了in.close();
 * 因为read方法直接返回了一个-1
 *
 * nio类提供了更加人性化的io中断。被阻塞的io通道会自动的响应中断
 * @see NIOInterruption
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        ServerSocket socket = new ServerSocket(8080);
        InputStream is = new Socket("localhost", 8080).getInputStream();

        exec.execute(new IOBlocked(is));
        exec.execute(new IOBlocked(System.in));

        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("shutdown all threads");
        exec.shutdownNow();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socket.getClass().getName());
        socket.close();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getName());
        System.in.close();
        TimeUnit.SECONDS.sleep(1);
    }
}
