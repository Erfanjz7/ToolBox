package com.company.Controller;
import com.company.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;

import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerController {

    private String boi;

    private int timeRemaining;

    private int min = 0;

    private int minRemaining = 0;

    private int sec = 0;

    private int secRemaining = 0;

    private int hour = 0;

    private Stage Timer;

    private Timeline timeline;

    @FXML
    private Label HourLBL;

    @FXML
    private TextField HourTXTField;

    @FXML
    private Label MinsLBL;

    @FXML
    private TextField MinsTXTField;

    @FXML
    private Label SecLBL;

    @FXML
    private TextField SecTXTField;

    @FXML
    private Label SettimeLBL;

    @FXML
    private Button TimerbackBTN;

    @FXML
    private Button TimerstartBTN;

    @FXML
    private Label ErrorTimerLBL;

    //passkari stage ha
    public void initFunction3(Stage Timer){
        this.Timer = Timer;
    }

    // daryafte zaman baraye shorroe timer ba estafade az regex va check kardan dorost boodane zamane vorrodi
    @FXML
    private void TimerstartBTNHandler(ActionEvent event) {
        String str = HourTXTField.getText();
        boolean check = Pattern.matches("[0-9]{1,3}" , str);
        String str2 = MinsTXTField.getText();
        boolean check2 = Pattern.matches("[0-9]{1,3}" , str2);
        String str3 = SecTXTField.getText();
        boolean check3 = Pattern.matches("[0-9]{1,3}" , str);


        if(check && check2 && check3){
            if(Integer.parseInt(SecTXTField.getText()) >= 60)
            {
                secRemaining = Integer.parseInt(SecTXTField.getText()) / 60;
                sec = Integer.parseInt(SecTXTField.getText()) - (60 * secRemaining);
                min = Integer.parseInt(MinsTXTField.getText());
                min += secRemaining;
                hour = Integer.parseInt(HourTXTField.getText());
            }
            else if(Integer.parseInt(MinsTXTField.getText()) >= 60)
            {
                sec = Integer.parseInt(SecTXTField.getText());
                minRemaining = Integer.parseInt(MinsTXTField.getText()) / 60;
                min = Integer.parseInt(MinsTXTField.getText()) - (60 * minRemaining);
                hour = Integer.parseInt(HourTXTField.getText());
                hour += minRemaining;
            }
            else if(Integer.parseInt(SecTXTField.getText()) >= 60 && Integer.parseInt(MinsTXTField.getText()) >= 60){
                secRemaining = Integer.parseInt(SecTXTField.getText()) / 60;
                sec = Integer.parseInt(SecTXTField.getText()) - (60 * secRemaining);
                min += secRemaining;

                minRemaining = Integer.parseInt(MinsTXTField.getText()) / 60;
                min = Integer.parseInt(MinsTXTField.getText()) - (60 * minRemaining);
                hour = Integer.parseInt(HourTXTField.getText());
                hour += minRemaining;
            }
            else
            {
                sec = Integer.parseInt(SecTXTField.getText());
                min = Integer.parseInt(MinsTXTField.getText());
                hour = Integer.parseInt(HourTXTField.getText());
            }

            //ErrorTimerLBL.setText(String.valueOf(hour) + " " + String.valueOf(min) + " " + String.valueOf(sec));

            HourLBL.setText(String.valueOf(hour));
            MinsLBL.setText(String.valueOf(min));
            SecLBL.setText(String.valueOf(sec));
            timeline = new Timeline(new KeyFrame(Duration.seconds(1) , e -> {

                if(hour <= 0 && min <= 0 && sec <= 0)
                {
                    HourLBL.setText("Time");
                    MinsLBL.setText("has");
                    SecLBL.setText("Finished!");
                    timeline.stop();
                }

                else if(sec <= 0 && min == 0)
                {
                    hour--;
                    min = 59;
                    sec = 59;
                    HourLBL.setText(String.valueOf(hour));
                    MinsLBL.setText(String.valueOf(min));
                    SecLBL.setText(String.valueOf(sec));
                }

                else if(sec == 0)
                {
                    min--;
                    sec = 59;
                    HourLBL.setText(String.valueOf(hour));
                    MinsLBL.setText(String.valueOf(min));
                    SecLBL.setText(String.valueOf(sec));
                }

                else
                {
                    sec--;
                    HourLBL.setText(String.valueOf(hour));
                    MinsLBL.setText(String.valueOf(min));
                    SecLBL.setText(String.valueOf(sec));
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();

            }


        else
        {
            ErrorTimerLBL.setText("Invalid Input Format");
        }

        }

        // reyrun to main menu
    @FXML
    private void BacktimerHandler(ActionEvent event){
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
        controller.initFunction(Timer);

        Timer.setScene(new Scene(loader.getRoot()));
    }

    }




