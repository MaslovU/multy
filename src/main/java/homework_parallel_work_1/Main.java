package homework_parallel_work_1;

public class Main {
    public static void main(String[] args) {
        Call call = new Call();
        Atc atc = new Atc(call);
        atc.setName("ATC");
        atc.start();

        Specialist specialist1 = new Specialist(call);
        specialist1.setName("Spec1");
        specialist1.start();

        Specialist specialist2 = new Specialist(call);
        specialist2.setName("Spec2");
        specialist2.start();

        Specialist specialist3 = new Specialist(call);
        specialist3.setName("Spec3");
        specialist3.start();
    }
}
