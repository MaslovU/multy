package homework_atomic_2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Report {
    private LongAdder longAdder = new LongAdder();
    private Random random = new Random();
    private int[] myInt;

    public void addSumArray(int size) {
        myInt = new int[size];
        for (int i = 0; i < myInt.length; i++) {
            myInt[i] = random.nextInt(100);
        }
        int res = Arrays.stream(myInt).sum();
        longAdder.add(res);
    }

    public long getAllRes() {
        return longAdder.sum();
    }
}
