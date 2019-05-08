import java.lang.Thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Chor chor = new Chor("ABC");

        for (Thread t : chor.getThreads()) System.out.println(t.getName());
        for (Thread t : chor.getThreads()){
            t.start();
        };
        Thread.sleep(10000);

        for (Thread t : chor.getThreads()){
            t.stop();
        };
        System.out.println("\nProgram skonczyl dzialanie");
    }

}

