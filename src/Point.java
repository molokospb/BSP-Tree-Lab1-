import java.awt.print.Printable;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 15.03.12
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class Point<E> {
    public int[] xy = new int[2];
    private static Random generator = new Random();
    String attribute;

    public Point() {
        xy[0] = generator.nextInt(600)+20;
        xy[1] = generator.nextInt(600)+20;
    }

    public Point(Point old) {
        xy[0] = old.getX();
        xy[1] = old.getY();
    }

    public Point(int x, int y) {
        xy[0] = x;
        xy[1] = y;
    }

    public Point(int x, int y, String attribute) {
        xy[0] = x;
        xy[1] = y;
        this.attribute = attribute;
    }

    public void show() {
        System.out.print("(" + xy[0] + "," + xy[1] + ")");
    }

    public int getX() {
        return xy[0];
    }

    public void setXY(int x, int y) {
        xy[0] = x;
        xy[1] = y;
    }

    public int getY() {
        return xy[1];
    }

    public String getAttribure() {
        return attribute;
    }

    public void setAttribute(String attribute){
        this.attribute = attribute;
    }


}
