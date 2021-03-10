package homework_parallel_work_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Call {
    private volatile static AtomicInteger counterWorking = new AtomicInteger(0);
    protected static int counter = 0;
    protected static BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingDeque<>();
    private final int LAG_CREATE_DATE = 10;

    public void generateCall() throws InterruptedException {
        Date date = new Date();
        Thread.sleep(LAG_CREATE_DATE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy dd MM: hh mm ss SSSS");
        counter++;
        String call = "Call-" + counter + " starts " + dateFormat.format(date);
        linkedBlockingQueue.put(call);
        System.out.println(call);
    }

    public int getCallForHandling() throws InterruptedException {
        String msg = linkedBlockingQueue.take();
        System.out.println(Thread.currentThread().getName() + " is working with " + msg);
        return counterWorking.incrementAndGet();
    }
}
