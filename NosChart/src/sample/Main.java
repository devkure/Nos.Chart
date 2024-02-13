package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("NosChartGUI.fxml"));

        primaryStage.setTitle("NosChart");
        primaryStage.setScene(new Scene(root, 800, 640));


        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
