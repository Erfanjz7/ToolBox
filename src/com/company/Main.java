package com.company;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.company.Controller.MainPageController;

import java.io.File;
import java.io.IOException;

public class Main extends Application{



    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("\\View\\MainPage.fxml"));
        try{
            loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(primaryStage);

        primaryStage.setScene(new Scene(loader.getRoot()));
        primaryStage.setTitle("ToolBox");
        primaryStage.show();


    }
    public static void main(String[] args) { launch(args);
    }
}
