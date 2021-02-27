package homework_1_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.logging.SimpleFormatter;

public class MyCallable implements Callable<String> {
    Date date = new Date();
    DateFormat simpleFormatter = new SimpleDateFormat("yyyy dd MM: hh mm ss");

    @Override
    public String call() throws Exception {
        Date date = new Date();
        return "Success! " + simpleFormatter.format(date);
    }
}
