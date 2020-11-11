package com.example.unit.test.github.threadTest.runnableAndCallable;

import java.util.concurrent.*;

public class RunnableAndCallable {

    /**
     * Runnable    public abstract void run();
     * Callable    V call() throws Exception;
     * 抽象的计算任务
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        runnableTest();
//        callableTest();
//        testFuture();
        testExecutorCompletionService();
    }

    private static void runnableTest(){
        Runnable task = new Runnable(){
            @Override
            public void run() {
                //TODO
                System.out.println("runnable...");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private static void callableTest(){
        Callable callable = new Callable<Object>(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
       FutureTask<Object> futureTask = new FutureTask<Object>(callable);
       futureTask.run();
    }

    private static void testFuture(){
        ExecutorService exec = Executors.newFixedThreadPool(100);

        Callable callable = new Callable<Object>(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };

        Future future = exec.submit(callable);

        if (future.isDone()){
            try {
                Object object = future.get();
                System.out.println("多线程执行 返回的结果: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    private static void testExecutorCompletionService() throws InterruptedException, ExecutionException {
        Executor exec = Executors.newFixedThreadPool(10);
//        ExecutorService exec = Executors.newFixedThreadPool(3);
        ExecutorCompletionService service = new ExecutorCompletionService(exec);

        for (int i = 0 ; i < 5 ; i++){
            int seqNo = i;
            service.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    return "HelloWorld-" + seqNo + "_" + Thread.currentThread().getName();
                }
            });
        }

        for (int j = 0 ; j < 5 ; j++){
            Future future = service.take();
            System.out.println(future.get());
        }
    }

}
