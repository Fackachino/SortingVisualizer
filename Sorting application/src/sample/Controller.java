package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;



public class Controller {
    public Label numbersLabel;
    @FXML
    private Pane shapesPane;

    @FXML
    private Slider sliderElements;

    @FXML
    private Button btnSort;

    public static int counter = 0;
    private int[] arr;
    private final ArrayList<Rectangle> bars = new ArrayList<>();

    private void barsGeneration() {
        shapesPane.getChildren().clear();
        bars.clear();
        int N = (int) sliderElements.getValue();
        arr = Algorithms.arrGenerate(N);

        // values for an interpolation
        // number of elements:  4   8  16 32 50 60 70 80 90 104
        // Y :                  130 65 46 26 17 14 12 10 9  8
        // new fucntion y=426.0170343953 * x^(−0.8420340530)

        int barWidth = (int) (426.0170343953 * (Math.pow(N, -0.8420340530)));
        int startX = 480 - (barWidth + 1) * N / 2;

        for (int i = 0; i < arr.length; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Color.web("#4cc9f0"));
            rectangle.setX(startX + (barWidth + 1) * i);
            rectangle.setY(735 - (2*arr[i] -20));
            rectangle.setWidth(barWidth);
            rectangle.setHeight(2*arr[i] -20);
            bars.add(rectangle);
            shapesPane.getChildren().addAll(rectangle);

        }
    }

    @FXML
    void initialize() {
        barsGeneration();

        sliderElements.valueProperty().addListener((observableValue, number, t1) ->{
            barsGeneration();
            numbersLabel.setText("Number of elements: " + arr.length);
        });

        btnSort.setOnAction(event -> {
            BubbleThread thread = new BubbleThread(arr, bars);
            thread.start();
        });
        
    }
}

class BubbleThread extends Thread{
    int[] a;
    ArrayList<Rectangle> aList;

    BubbleThread(int[] a, ArrayList<Rectangle> aList){
        this.a = a;
        this.aList = aList;
        System.out.println(aList.size());

    }

    public void run(){
        int NN = a.length;
        for (int i = 0; i < NN; i++) {
            for (int j = 1; j < NN - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    Algorithms.swapBars(aList, j - 1, j);
                    try{
                        Thread.sleep(30);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
