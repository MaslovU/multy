package homework_compare_maps_2;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMapExample concurrentHashMapExample = new ConcurrentHashMapExample();
        CreateMap createMap = new CreateMap(concurrentHashMapExample);
        ThreadRead read = new ThreadRead(concurrentHashMapExample);
        ThreadPut put = new ThreadPut(concurrentHashMapExample);

        final long startTime = System.nanoTime();

        Thread thread1 = new Thread(createMap);
        thread1.start();
        Thread thread2 = new Thread(put);
        thread2.start();
        Thread thread3 = new Thread(read);
        thread3.start();

        Thread thread4 = new Thread(put);
        thread4.start();
        Thread thread5 = new Thread(put);
        thread5.start();
        Thread thread6 = new Thread(put);
        thread6.start();
        Thread thread7 = new Thread(put);
        thread7.start();
        Thread thread8 = new Thread(put);
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time / 1000000 + " sec");
    }
}
