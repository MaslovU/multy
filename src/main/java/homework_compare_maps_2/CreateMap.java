package homework_compare_maps_2;

public class CreateMap implements Runnable{
    private final ConcurrentHashMapExample concurrentHashMapExample;

    public CreateMap(ConcurrentHashMapExample concurrentHashMapExample) {
        this.concurrentHashMapExample = concurrentHashMapExample;
    }

    @Override
    public void run() {
        concurrentHashMapExample.createConcurrentHashMap();
    }
}
