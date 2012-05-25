import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 15.03.12
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    static public int N = 30;
    static public int R = 50;
    static public Point[] array = new Point[N];

    public static void main(String[] Args) {
//    for (int i = 0; i < N; i++) {
//            array[i] = new Point();
//        }
        array[1] = new Point(50,231,"Shop 1");          array[11] = new Point(345,331,"Shop 11");       array[21] = new Point(546,531,"Shop 21");
        array[2] = new Point(493,361,"Shop 2");          array[12] = new Point(573,12,"Shop 12");       array[22] = new Point(501,231,"Shop 22");
        array[3] = new Point(500,451,"Shop 3");          array[13] = new Point(299,369,"Shop 13");       array[23] = new Point(599,101,"Shop 23");
        array[4] = new Point(239,239,"Shop 4");          array[14] = new Point(434,345,"Shop 14");       array[24] = new Point(15,21,"Shop 24");
        array[5] = new Point(586,123,"Shop 5");          array[15] = new Point(123,567,"Shop 15");       array[25] = new Point(75,599,"Shop 25");
        array[6] = new Point(234,435,"Shop 6");          array[16] = new Point(456,234,"Shop 16");       array[26] = new Point(523,456,"Shop 26");
        array[7] = new Point(435,35,"Shop 7");          array[17] = new Point(234,100,"Shop 17");       array[27] = new Point(354,600,"Shop 27");
        array[8] = new Point(456,256,"Shop 8");          array[18] = new Point(134,324,"Shop 18");       array[28] = new Point(123,123,"Shop 28");
        array[9] = new Point(587,76,"Shop 9");          array[19] = new Point(456,213,"Shop 19");       array[29] = new Point(234,167,"Shop 29");
        array[10] = new Point(56,324,"Shop 10");          array[20] = new Point(435,254,"Shop 20");       array[0] = new Point(234,567,"Shop 30");

    aShape frame = new aShape(array, R);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
}