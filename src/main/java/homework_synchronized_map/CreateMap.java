package homework_synchronized_map;

public class CreateMap implements Runnable {
    SynchronizedMapExample synchronizedMapExample;

    public CreateMap(SynchronizedMapExample synchronizedMapExample) {
        this.synchronizedMapExample = synchronizedMapExample;
    }

    @Override
    public void run() {
        synchronizedMapExample.createHashMap();
    }
}