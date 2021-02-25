package homework_1_1;

public class MaslovsThread extends Thread{


    public MaslovsThread(ThreadGroup mainThread, String maslovsThread) {
        super(mainThread, maslovsThread);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println(getName() + " Hi, all!");
            }
        } catch (InterruptedException err) {
            System.out.println("Complete all threads.");
        } finally {
            System.out.printf("%s completed\n", getName());
        }
    }
}
