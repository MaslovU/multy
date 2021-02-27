package homework_1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        ThreadGroup mainThread = new ThreadGroup("main group");
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<String>> tasks = new ArrayList<>();
        Callable<String> myCallable = new MyCallable();

        for (int i = 0; i < 100; i++) {
            final Future<String> task = threadPool.submit(myCallable);
            tasks.add(task);
            Thread.sleep(1500);
        }

        for (Future<String> el: tasks) {
            try {
                System.out.println(el.get());
                Thread.sleep(1000);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }
        threadPool.shutdown();
//        final Thread thread1 = new MaslovsThread(mainThread, "MaslovsThread");
//        final Thread thread2 = new MaslovsThread(mainThread, "MaslovsThread");
//        final Thread thread3 = new MaslovsThread(mainThread, "MaslovsThread");
//        final Thread thread4 = new MaslovsThread(mainThread, "MaslovsThread");
//
//        thread1.setName("Ivan");
//        thread2.setName("Jhon");
//        thread3.setName("Sacha");
//        thread4.setName("Tanya");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

//        System.out.println("Name is: " + mainThread.getName());
//        mainThread.list();
//
//        Thread.sleep(10000);
//        mainThread.interrupt();
    }
}
