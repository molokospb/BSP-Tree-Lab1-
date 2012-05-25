import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 23.04.12
 * Time: 3:43
 * To change this template use File | Settings | File Templates.
 */
class aShape extends JFrame {
    public int count = 0;
    final ArrayList<Point> arrayJ = new ArrayList<Point>();
    final Point start = new Point(0,0);
    int R;


    public aShape(Point[] array,int Rold) {
        setTitle("Map");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        PaintPanel panel = new PaintPanel(array,start);

        for (int i = 0; i < array.length; i++) {
            arrayJ.add(i,array[i]);
        }
        add(panel);

        R = Rold;

        final MouseListener mouse = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                count = 1 - count ;
                if (count == 1){
                Point point = new Point(e.getX(), e.getY());
                Point[] newArray = new Point[arrayJ.size()];
                for (int i = 0; i < arrayJ.size(); i++) {
                    newArray[i] = new Point(arrayJ.get(i));
                }
                newArray = Tree.makeArea(newArray, point, R);
                PaintPanel panel = new PaintPanel(newArray,point);
                add(panel);
                validate();
                }
                else {
                Point[] newArray = new Point[arrayJ.size()];
                for (int i = 0; i < arrayJ.size(); i++) {
                    newArray[i] = new Point(arrayJ.get(i));
                }
                PaintPanel panel = new PaintPanel(newArray,start);
                add(panel);
                validate();
                }
                }
        };
        panel.addMouseListener(mouse);
    }

    public static final int DEFAULT_WIDTH = 650;
    public static final int DEFAULT_HEIGHT = 650;
}
