import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by gleb on 17.05.17.
 */
public class TestTask {

    public static List<Rectangle> rectangleList;

    public TestTask(int size) {
        rectangleList = new ArrayList<>(size);
        int x = 0;
        int y = 0;
        int value = 1000;
        int width = random(value) +10;
        int height = random(value) +10;
        for (int i = 0; i < size; i++) {
            Rectangle rectangle = new Rectangle(x, y, width, height);
            rectangleList.add(rectangle);
            if (i % 2 == 0) {
                x += width + random(value) +1;
            } else {
                y += height + random(value) +1;
            }
        }
    }

    public void verificationPoints(List<Point> points) {
        Collections.sort(points, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);
        System.out.println("Pints sorted!");
        int countPoint = 0;
        int countRect = 0;
        Map<Rectangle, List<Point>> result = new HashMap<>();
        while (countRect < rectangleList.size() && countPoint < points.size()) {
            Rectangle rectangle = rectangleList.get(countRect);
            Point point = points.get(countPoint);
            if (rectangle.x > point.x || (rectangle.x + rectangle.width) < point.x &&
                    rectangle.y > point.y || (rectangle.y + rectangle.height) < point.y) {
                countRect++;
            } else {
                List<Point> pointList = result.get(rectangle);
                if (pointList == null) {
                    pointList = new ArrayList<>();
                    result.put(rectangle, pointList);
                }
                pointList.add(point);
                countPoint++;
            }
        }
        for (Rectangle rectangle : result.keySet()) {
            List<Point> points1 = result.get(rectangle);
            if (points1.size() < 10) {
                System.out.println(rectangle + " => " + points1);
            } else {
                System.out.println(rectangle + " => " + points1.get(0) + "  --  " + points1.get(points1.size() -1));
            }
            System.out.println();
        }
    }


    public List<Point> generatePoints(int size, int value) {
        List<Point> points = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            points.add(new Point(random(value), random(value)));
        }
        return points;
    }

    private int random(int value) {
        return (int) (Math.random() * value);
    }
}
