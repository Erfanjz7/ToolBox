package com.company.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;

import java.io.IOException;

public class AutoPowerOffController {

    private Stage AutoPowerOff;

    @FXML
    private Button AutopoweroffdoneBTN;

    @FXML
    private TextField TimeinsertionTXTField;

    @FXML
    private Button AutopoweroffbackBTN;

    @FXML
    private Label boiLBL;


    public void initFunction5(Stage AutoPowerOff){
        this.AutoPowerOff = AutoPowerOff;
    }// stage ra pas midahim

    @FXML
    private void AutoPowerOffHandler(ActionEvent event) {
        int sec = Integer.parseInt(TimeinsertionTXTField.getText());
        Runtime runtime = Runtime.getRuntime();
        Runtime r = Runtime.getRuntime();
       try
        {
            r.exec("shutdown -s -t " + sec);  // be ezaye time dade shode sabr mikonim va bad shut down
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    // return to main menu

    @FXML
    private void AutoPowerOffBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(AutoPowerOff);

        AutoPowerOff.setScene(new Scene(loader.getRoot()));
    }

}
