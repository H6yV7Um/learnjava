package com.concurrent.call;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Future类的方法
 * isDone() 查看任务是否完成
 * get(超时时间的)
 * get()取结果会阻塞的
 *
 * 任务一经提交，就开始执行了
 *
 * Created by dongchunxu on 2017/6/28.
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 1000; i++) {
            Future<String> future = service.submit(new TaskWithResult(i));
            System.out.println("提交了任务");
            results.add(future);
        }

        System.out.println("所有任务都提交了，main线程");

        //这里判断结果,这里的isDone判断毫无意义，因为任务的执行时间太短。到这里1000个任务一经全部执行完了
        for(Future<String> future : results) {
            try {
                if (future.isDone()) {
                    System.out.println(future.get());
                } else {
                    System.out.println("任务还未完成...");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }
    }

}


class TaskWithResult implements Callable<String>{
    private int id;
    TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        System.out.println("开始执行任务");
        //Thread.sleep(100);
        return "result of TaskResult " + id;
    }
}
