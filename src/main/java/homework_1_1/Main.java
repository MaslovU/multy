package homework_1_1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainThread = new ThreadGroup("main group");
        final Thread thread1 = new MaslovsThread(mainThread, "MaslovsThread");
        final Thread thread2 = new MaslovsThread(mainThread, "MaslovsThread");
        final Thread thread3 = new MaslovsThread(mainThread, "MaslovsThread");
        final Thread thread4 = new MaslovsThread(mainThread, "MaslovsThread");

        thread1.setName("Ivan");
        thread2.setName("Jhon");
        thread3.setName("Sacha");
        thread4.setName("Tanya");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(10000);
        mainThread.interrupt();
    }
}
