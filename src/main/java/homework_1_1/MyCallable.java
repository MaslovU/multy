package homework_1_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.logging.SimpleFormatter;

public class MyCallable implements Callable<String> {
    DateFormat simpleFormatter = new SimpleDateFormat("yyyy dd MM: hh mm ss");
    private static int count = 0;
    Random random = new Random();
    Date date = new Date();

    @Override
    public String call() throws Exception {
        count++;
        Thread.sleep(random.nextInt(1000) * 100 );
        return "Success! " + simpleFormatter.format(date);
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return simpleFormatter.format(date);
    }
}
