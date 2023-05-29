package com.company.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.io.IOException;

public class StopWatchController {

    private Stage Stopwatch;

    private Timeline timeline;

    @FXML
    private Button BackstopwatchBTN;

    @FXML
    private Label HourstopwatchLBL;

    @FXML
    private Label MinstopwatchLBL;

    @FXML
    private Button RestartstopwatchBTN;

    @FXML
    private Label SecstopwatchLBL;

    @FXML
    private Button StartstopwatchBTN;

    @FXML
    private Button StopstopwatchBTN;

    //passkari stage ha
    public void initFunction4(Stage Stopwatch){
        this.Stopwatch = Stopwatch;
    }
    private int sec = -1;
    private int min = 0;
    private int hour = 0;

    // shmaresh ra shoroo mikonad
    @FXML
    private void StopwatchStartHandler(ActionEvent event){
         timeline = new Timeline(new KeyFrame(Duration.seconds(1) , e ->{
            if(sec == 60)
            {
                min += 1;
                sec = 0;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

            else if(sec == 60 && min == 60)
            {
                hour += 1;
                min = 0;
                min ++;
                sec = 0;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

            else
            {
                sec++;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    // shomaresh ra motevaghef mikonad
    @FXML
    private void StopWatchStopHandler(ActionEvent event){
        timeline.stop();
        HourstopwatchLBL.setText(String.valueOf(hour));
        MinstopwatchLBL.setText(String.valueOf(min));
        SecstopwatchLBL.setText(String.valueOf(sec));
    }

    // shomaresh ra reset mikonad
    @FXML
    private void StopWatchRestartHandler(ActionEvent event){
        timeline.stop();
        sec = -1;
        min = 0;
        hour = 0;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1) , e ->{
            if(sec == 60)
            {
                min += 1;
                sec = 0;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

            else if(sec == 60 && min == 60)
            {
                hour += 1;
                min = 0;
                min ++;
                sec = 0;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

            else
            {
                sec++;
                HourstopwatchLBL.setText(String.valueOf(hour));
                MinstopwatchLBL.setText(String.valueOf(min));
                SecstopwatchLBL.setText(String.valueOf(sec));
            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    //return to main menu
    @FXML
    private void StopWatchBackHandler(ActionEvent event){
        try {
            timeline.stop();
        }catch (NullPointerException e){}
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(Stopwatch);

        Stopwatch.setScene(new Scene(loader.getRoot()));
    }
}
