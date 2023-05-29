package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class MainPageController {

    private Stage MainPage;
    @FXML
    private Button CalculatorBTN;

    @FXML
    private Button StopWatchBTN;

    @FXML
    private Button TimerBTN;

    @FXML
    private Button AutoPowerOffBTN;

    @FXML
    private Button DateconverterBTN;

    @FXML
    private Button NotePadBTN;

    @FXML
    private Button ExitBTN;

    @FXML
    private Button ContactsBTN;

    @FXML
    private Button zipandunzipBTN;


    //passkari satge ha
    public void initFunction(Stage MainPage){
        this.MainPage = MainPage;
    }
    @FXML
    private void CalculatorHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\Calculator2.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        CalculatorController calculatorController = loader.getController();
        calculatorController.initFunction2(MainPage);
    }

    //bargozari timer
    @FXML
    private void TimerHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\Timer.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
         TimerController timerController = loader.getController();
        timerController.initFunction3(MainPage);
    }

    //bargozari stopwatch
    @FXML
    private void StopWatchHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\StopWatch.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        StopWatchController stopWatchController = loader.getController();
        stopWatchController.initFunction4(MainPage);
    }

    //bargozari autopoeroff
    @FXML
    private void AutoPowerOffHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\AutoPowerOff.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        AutoPowerOffController autoPowerOffController = loader.getController();
        autoPowerOffController.initFunction5(MainPage);
    }

    //bargozari tabdil tarikh
    @FXML
    private void DateConverterHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\DateConverter.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        DateConverterController dateConverterController = loader.getController();
        dateConverterController.initFunction6(MainPage);
    }

    //bargozari notepad
    @FXML
    private void NotePadHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadMainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        NotePadMainPageController notePadMainPageController = loader.getController();
        notePadMainPageController.initFunction7(MainPage);
    }

    //bargozari contact ha
    @FXML
    private void ContactsHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\ContactsPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        ContactsPageController contactsPageController = loader.getController();
        contactsPageController.initFunction12(MainPage);
    }

    //bargozari zip va unzip
    @FXML
    private void ZipAndUnzipHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\Zip&UnzipPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        ZipAndUnzipPageController zipAndUnzipPageController = loader.getController();
        zipAndUnzipPageController.initFunction18(MainPage);
    }

    //bargozari mediaplayer
    @FXML
    private void MediaPlayerHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MediaPlayer.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMainPage().setScene(new Scene(loader.getRoot()));
        getMainPage().setResizable(false);
        MediaPlayerController mediaPlayerController = loader.getController();
        mediaPlayerController.initFunction20(MainPage);
    }

    //khorroj az baranme
    @FXML
    private void ExitHandler(ActionEvent event){
        getMainPage().close();
    }


    public Stage getMainPage() {
        return MainPage;
    }
}
