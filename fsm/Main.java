import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public final static int INTERVAL = 20; // ms
    private static Robot robot;

    public void task() {
        robot.robotPeriodic();
    }

    public void startTimer() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> task(), 0, INTERVAL, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        robot = new Robot();

        Main timer = new Main();
        timer.startTimer();
    }
}
