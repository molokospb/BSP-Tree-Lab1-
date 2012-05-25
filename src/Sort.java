import java.util.Random;

public abstract class Sort {

    public static void printArray(Point[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            array[i].show();
            System.out.print(", ");
        }
        array[array.length - 1].show();
        System.out.println();
    }

    public static void quickSort(Point[] array, int i) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        if (i == 0) {
            doSortX(array, startIndex, endIndex);
        } else {
            doSortY(array, startIndex, endIndex);
        }
    }

    private static void doSortX(Point[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i].getX() <= array[cur].getX())) {
                i++;
            }
            while (j > cur && (array[cur].getX() <= array[j].getX())) {
                j--;
            }
            if (i < j) {
                Point temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortX(array, start, cur);
        doSortX(array, cur + 1, end);
    }

    private static void doSortY(Point[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i].getY() <= array[cur].getY())) {
                i++;
            }
            while (j > cur && (array[cur].getY() <= array[j].getY())) {
                j--;
            }
            if (i < j) {
                Point temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSortY(array, start, cur);
        doSortY(array, cur + 1, end);
    }
}