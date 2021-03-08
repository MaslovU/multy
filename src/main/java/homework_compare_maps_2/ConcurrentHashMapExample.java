package homework_compare_maps_2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    private static final Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
    protected Random random = new Random();
    protected volatile static int sizeMyArray = 3000;

    public void readConcurrentHashMap() throws InterruptedException {
        for (Integer key : concurrentHashMap.keySet()) {
            System.out.println("Key is: " + key + " value is: " + concurrentHashMap.get(key));
        }
    }

    public void createConcurrentHashMap() {
        for (int i = 0; i < sizeMyArray; i++) {
            concurrentHashMap.put(i, "element" + i);
        }
    }

    public void changeConcurrentHashMap(int newKey) throws InterruptedException {
        concurrentHashMap.put(newKey, "sting" + random.nextInt(1000));
    }
}
