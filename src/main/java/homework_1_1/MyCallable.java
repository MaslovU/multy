package homework_1_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.logging.SimpleFormatter;

public class MyCallable implements Callable<String> {
    DateFormat simpleFormatter = new SimpleDateFormat("yyyy dd MM: hh mm ss");
    private static int count = 0;

    @Override
    public String call() throws Exception {
        Date date = new Date();
        count++;
        return "Success! " + simpleFormatter.format(date);
    }

    public static int getCount() {
        return count;
    }
}
