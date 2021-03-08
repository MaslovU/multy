package homework_parallel_work_1;

public class Atc extends Thread {
    private Call call;
    protected static final int WORK_TIME_ATC = 2;
    protected static final int CAPABILITY_ATC_IN_SECOND = 10;
    private static final int PERIOD_GENERATE_CALLS_MILLI_SEC = 1000;

    public Atc(Call call) {
        this.call = call;
    }

    @Override
    public void run() {
        for (int i = 0; i < WORK_TIME_ATC; i++) {
            try {
                Thread.sleep(PERIOD_GENERATE_CALLS_MILLI_SEC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < CAPABILITY_ATC_IN_SECOND; j++) {
                try {
                    call.generateCall();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
