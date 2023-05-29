package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NotePadMainPageController {

    private  Stage NotePadMainPage;


    @FXML
    private Button NotepadmainpagebackBTN;

    @FXML
    private Button NotepadmainpagedeletefileBTN;

    @FXML
    private Button NotepadmainpageeditfileBTN;

    @FXML
    private Button NotepadmainpageloadfileBTN;

    @FXML
    private Button notepadmainpagenewfileBTN;

    //passkari stage ha
    public void initFunction7(Stage NotePadMainPage){
        this.NotePadMainPage = NotePadMainPage;
    }

    //bargozari newfile page
    @FXML
    private void NotePadNewFileHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadNewFilePage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadNewFilePage controller = loader.getController();
        controller.initFunction8(NotePadMainPage);

        NotePadMainPage.setScene(new Scene(loader.getRoot()));
    }

    // bargozari loadfile page
    @FXML
    private void NotePadLoadFileHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadLoadFile.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadLoadFileController controller = loader.getController();
        controller.initFunction9(NotePadMainPage);

        NotePadMainPage.setScene(new Scene(loader.getRoot()));
    }

    @FXML
    private void NotePadMainPageDeleteFileHandler(ActionEvent e){

    }

    //return to main menu
    @FXML
    private void NotePadMainPageBackHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(NotePadMainPage);

        NotePadMainPage.setScene(new Scene(loader.getRoot()));
    }

    // bar gozari deletefile page
    @FXML
    private void NotePadMainPageDeleteFilehandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadDeleteFilePage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadDeleteFilePageController controller = loader.getController();
        controller.initFunction10(NotePadMainPage);

        NotePadMainPage.setScene(new Scene(loader.getRoot()));
    }

    //bargozari editfile page
    @FXML
    private void NotePadMainPageEditFileHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadEditFile.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadEditFilePageControleer controller = loader.getController();
        controller.initFunction11(NotePadMainPage);

        NotePadMainPage.setScene(new Scene(loader.getRoot()));
    }


}
