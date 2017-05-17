import java.awt.*;
import java.util.List;

/**
 * Created by gleb on 17.05.17.
 */
public class Main {

    public static void main(String[] args) {
        TestTask testTask = new TestTask(1000000);
        System.out.println("Rectangles is created!");
        List<Point> points = testTask.generatePoints(1000000, 1000);
        System.out.println("Pints is created!");
        testTask.verificationPoints(points);
    }

}
