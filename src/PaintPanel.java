

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



class PaintPanel extends JPanel {
    private Point[] points;
    private Point point;

    public PaintPanel(Point[] points, Point point) {
        this.points = points;
        this.point = point;

    }

    @Override
    public void paintComponent(Graphics g) {
        int min = 3;
        int size = 0;
        double koeff=1;

      //  if (point.getX()!= 0 && point.getY() != 0) {koeff = points.length;}   //надо придумать для перерисовки

        g.clearRect(0,0,this.getWidth(),this.getHeight());

        int X,Y;

        if(points.length != 0){size = (int) (min + 2*Math.ceil(min*min*min/(points.length)));}
        for (Point p : points) {
            X = (int) Math.ceil(p.getX()/koeff);
            Y = (int) Math.ceil(p.getY()/koeff);
            if(point.getX()!= 0 && point.getY() != 0){System.out.println("X:"+X+", Y:"+Y);}
            g.fillRect(X, Y, size, size);
            //g.drawString("("+ p.getX()+","+p.getY()+")",X-20, Y-5);
            g.drawString(p.getAttribure(),X-20, Y-5);
        }
    }
}
