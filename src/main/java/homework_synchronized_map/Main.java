package homework_synchronized_map;

public class Main {
    public static void main(String[] args) {
        SynchronizedMapExample synchronizedMapExample = new SynchronizedMapExample();
        CreateMap createMap = new CreateMap(synchronizedMapExample);
        ReadMap read = new ReadMap(synchronizedMapExample);
        ChangeMap change = new ChangeMap(synchronizedMapExample);

        final long startTime = System.nanoTime();

        Thread thread1 = new Thread(createMap);
        thread1.start();
        Thread thread2 = new Thread(read);
        thread2.start();

        Thread thread3 = new Thread(change);
        thread3.start();
        Thread thread4 = new Thread(change);
        thread4.start();
        Thread thread5 = new Thread(change);
        thread5.start();
        Thread thread6 = new Thread(change);
        thread6.start();
        Thread thread7 = new Thread(change);
        thread7.start();
        Thread thread8 = new Thread(change);
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