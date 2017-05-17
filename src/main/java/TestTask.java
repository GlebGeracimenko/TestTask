import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gleb on 17.05.17.
 */
public class TestTask {

    public static List<Rectangle> rectangleList;

    public TestTask(int size) {
        rectangleList = new ArrayList<>(size);
        int x = 0;
        int y = 0;
        int value = 100;
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
        Iterator<Point> iterator;
        Collections.sort(points, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);
        int count = 0;
        for (Rectangle rectangle : rectangleList) {
            iterator = points.iterator();
            while (iterator.hasNext()) {
                Point point = iterator.next();

                if (rectangle.x > point.x || (rectangle.x + rectangle.width) < point.x &&
                        rectangle.y > point.y || (rectangle.y + rectangle.height) < point.y) {
                    break;
                }
                if (rectangle.contains(point)) {
                    iterator.remove();
                }
            }
            System.out.println(points.size() + " rectangle size = " + ++count);
        }
        System.out.println("End! Points size = " + points.size());
    }

    public List<Point> generatePoints(int size, int value) {
        List<Point> points = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            points.add(new Point(random(value), random(value)));
        }
        return points;
    }

    private int random(int value) {
        return (int)(Math.random() * value);
    }
}
