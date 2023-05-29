package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ZipAndUnzipPageController {

    private Stage ZipAndUnzipPageController;

    @FXML
    private Button ZipandunzippagebackBTN;

    @FXML
    private Button ZipandunzippageunzipBTN;

    @FXML
    private Button ZipandunzippagezipBTN;

    //passkari stage
    public void initFunction18(Stage ZipAndUnzipPageController){
        this.ZipAndUnzipPageController = ZipAndUnzipPageController;
    }


    //return to main menu
    @FXML
    private void ZipANdUnzipBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        MainPageController mainPageController = loader.getController();
        mainPageController.initFunction(ZipAndUnzipPageController);

        ZipAndUnzipPageController.setScene(new Scene(loader.getRoot()));
    }

    // bargozari safhe zip
    @FXML
    private void ZipZipHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\ZipPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ZipPageController zipPageController = loader.getController();
        zipPageController.initFunction19(ZipAndUnzipPageController);

        ZipAndUnzipPageController.setScene(new Scene(loader.getRoot()));
    }

    //bargozari safhe unzip
    @FXML
    private void ZipUnZipHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\UnzipPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UnzipPageController unzipPageController = loader.getController();
        unzipPageController.initFunction20(ZipAndUnzipPageController);

        ZipAndUnzipPageController.setScene(new Scene(loader.getRoot()));
    }
}
