package homework_1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ThreadGroup mainThread = new ThreadGroup("main group");
        final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> tasks = new ArrayList<>();
        List<Callable<String>> listStringsCallable = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Callable<String> myCallable = new MyCallable();
            listStringsCallable.add(myCallable);
            Future<String> task = service.submit(myCallable);
            tasks.add(task);
            Thread.sleep(1500);
        }

        for (Future<String> el : tasks) {
            try {
                System.out.println(el.get());
                Thread.sleep(100);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Amount of messages is: " + MyCallable.getCount());
        System.out.println("Random tasks is: " + service.invokeAny(listStringsCallable));

        service.shutdown();
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
