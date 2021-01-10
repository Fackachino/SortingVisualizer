package sample;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Algorithms {
    public static int[] arrGenerate(int N) {
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = 20 + (int) (Math.random() * 300);

        }
        return arr;
    }

    public static void swapBars(ArrayList<Rectangle> aList, int i, int j) {
        double t = aList.get(i).getHeight();
        aList.get(i).setHeight(aList.get(j).getHeight());
        aList.get(i).setY(735 - aList.get(j).getHeight());
        aList.get(j).setHeight(t);
        aList.get(j).setY(735 - aList.get(j).getHeight());
    }

}




















