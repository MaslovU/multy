package homework_synchronized_map;

import java.util.*;

public class SynchronizedMapExample {
    private static final Map<Integer, String> map = new HashMap<>();
    private static final Map<Integer, String> sHashMap = Collections.synchronizedMap(map);
    Random random = new Random();
    protected volatile static int sizeMySArray = 3000;

    public void readHashMap() throws InterruptedException {
            for (Integer key : sHashMap.keySet()) {
                System.out.println("Key is: " + key + " value is: " + sHashMap.get(key));
            }
    }

    public void createHashMap() {
            for (int i = 0; i < sizeMySArray; i++) {
                map.put(i, "element" + i);
            }
        }


    public void changeHashMap() {
        synchronized (sHashMap) {
            int newKey = SynchronizedMapExample.sizeMySArray++;
            if (!sHashMap.containsKey(newKey)) {
                sHashMap.put(newKey, "sting" + random.nextInt(1000));
            }
        }
    }
}
