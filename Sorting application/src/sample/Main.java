package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception{
        primaryStage = stage;
        Image image = new Image("/resources/myIcon.jpg");
        stage.getIcons().add(image);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Sorting visualization");
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
