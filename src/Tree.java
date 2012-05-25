import com.sun.java_cup.internal.runtime.Symbol;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 20.04.12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class Tree {
    public static ArrayList<Point> PointsList = new ArrayList();
    public static int count = 0;
    public static int num = 0;

    public static void makeTree(Point[] array) {
        Point start = new Point(0,0);
        Node node = new Node(start);
        recursiveTree(node, array, 0);
        printInOrder(node);
    }

    public static void recursiveTree(Node node, Point[] arrayTree, int st) {
        Point start = new Point(0,0);
        int index = ((arrayTree.length) / 2);
        Sort.quickSort(arrayTree, st);
        Point value = arrayTree[index];


        if (st == 0) {
            node.setValue(value);
        }
        if (st == 1) {
            node.setValue(value);
        }

        Point[] left = new Point[index];
        Point[] right = new Point[arrayTree.length - index];

        for (int i = 0; i < index; i++) {
            left[i] = new Point(arrayTree[i]);
        }
        for (int i = index; i < arrayTree.length; i++) {
            right[i - index] = new Point(arrayTree[i]);
        }

        if (arrayTree.length == 2) {
            node.left = new Node(left[0]);
            node.right = new Node(right[0]);
        } else {
            if (arrayTree.length == 3) {
                node.left = new Node(left[0]);
                node.right = new Node(start);
                recursiveTree(node.right, right, (st + 1) % 2);
            } else {

                if (left.length > 1) {
                    node.left = new Node(start);
                    recursiveTree(node.left, left, (st + 1) % 2);
                } else {
                }

                if (right.length > 1) {
                    node.right = new Node(start);
                    recursiveTree(node.right, right, (st + 1) % 2);
                } else {
                }
            }
        }
    }


    public static void printInOrder(Node node) {
        if (node != null) {
            if (node.left == null || node.right == null){System.out.print("  Vers:"); node.value.show(); System.out.println("");}
            else{System.out.print("  Traversed:"); node.value.show(); System.out.println("");}
            printInOrder(node.left);

            printInOrder(node.right);
        }
    }

    public static void finishMake(Node node, int[] borde) {

        if (node != null) {
                if (node.left == null && node.right == null){
                 Point help = new Point();
                 if ((node.value.getX() > borde[0]) && (node.value.getX() < borde[1]) && (node.value.getY() > borde[2]) && (node.value.getY() < borde[3])){
                  PointsList.add(node.value);
                 }
                }
                else {
                    finishMake(node.left, borde);
                    finishMake(node.right, borde);
                }
        }
    }

    public  static void startMake(Node node, int[] borde, int step){
        count = 0;
        treeSize(node);
         if (Math.ceil(Math.log(count)/Math.log(2)) > 4){
             switch (step) {
                 case 0: {
                     if (borde[0] >= node.value.getX()){ startMake(node.right,borde,1);}
                     else{ startMake(node.right,borde,1); startMake(node.left,borde,1);}
                 }break;
                 case 1: {
                     if (borde[2] >= node.value.getY()){ startMake(node.right,borde,2);}
                     else{ startMake(node.left,borde,2); startMake(node.right,borde,2);}
                 }break;
                 case 2: {
                      if (borde[1] >= node.value.getX()){ startMake(node.right,borde,3); startMake(node.left,borde,3);}
                     else{ startMake(node.left,borde,3); }
                 }break;
                 case 3: {
                     if (borde[3] >= node.value.getY()){ startMake(node.right,borde,0); startMake(node.left,borde,0);}
                     else{ startMake(node.left,borde,0);}
                 }break;
                 default: ;
             }
        }
        else{
        finishMake(node, borde);
        }

    }

    public  static void treeSize(Node node){
        if (node != null) {
            if (node.left == null && node.right == null){count++;}
            else{
            treeSize(node.left);
            treeSize(node.right);
            }
        }
    }

    public static Point[] makeArea(Point[] array, Point centr, int R){
        Point start = new Point(0,0);
        Node node = new Node(start);
        recursiveTree(node, array, 0);

        int[] borde = new int[4];
        borde[0] = centr.getX() - R;
        if (borde[0] < 0) {borde[0] = 0;}
        borde[1] = centr.getX() + R;
        if (borde[1] > 620) {borde[1] = 620;}
        borde[2] = centr.getY() - R;
        if (borde[2] < 0) {borde[2] = 0;}
        borde[3] = centr.getY() + R;
        if (borde[3] > 620) {borde[3] = 620;}

        PointsList.clear();
        startMake(node,borde,0);

        //System.out.print(PointsList.size());

        Point[] newArray = new Point[PointsList.size()];
                for (int i = 0; i < PointsList.size(); i++) {
                    newArray[i] = new Point(PointsList.get(i));
                }

        return  newArray;
    }
}

