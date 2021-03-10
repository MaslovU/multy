package homework_parallel_work_1;

public class Specialist extends Thread {
    private Call call;
    private final int CYCLE_WAITING_CALLS = 100;
    private final int HANDLING_CALL_TIME = 3000;
    private final int COUNTER_WORKING;

    public Specialist(Call call) {
        this.call = call;
        COUNTER_WORKING = Atc.WORK_TIME_ATC * Atc.CAPABILITY_ATC_IN_SECOND;
    }

    @Override
    public void run() {
        if (Call.linkedBlockingQueue.isEmpty()) {
            try {
                Thread.sleep(CYCLE_WAITING_CALLS);
            } catch (InterruptedException e) {
                System.out.println("Calls queue isEmpty, please wait 0.5 sec");
            }
        }
        while (true) {
            try {
                if (!(call.getCallForHandling() < COUNTER_WORKING)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(HANDLING_CALL_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
