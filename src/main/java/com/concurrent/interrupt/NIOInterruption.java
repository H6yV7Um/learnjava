package com.concurrent.interrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by dongchunxu on 2017/7/2.
 */
public class NIOInterruption implements Runnable{
    private final SocketChannel sc;

    public NIOInterruption(SocketChannel sc) {
        this.sc = sc;
    }


    public void run() {
        try {
            System.out.println("waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Exiting NIOBlocked.run() " + this);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(address);
        SocketChannel sc2 = SocketChannel.open(address);

        Future<?> future = exec.submit(new NIOInterruption(sc1));
        exec.execute(new NIOInterruption(sc2));
        exec.shutdown();

        TimeUnit.SECONDS
                .sleep(1);

        future.cancel(true);

        TimeUnit.SECONDS
                .sleep(1);

        sc2.close();
    }
}
