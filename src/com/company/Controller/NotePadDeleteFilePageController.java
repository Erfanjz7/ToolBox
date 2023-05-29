package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NotePadDeleteFilePageController {

    private Stage NotePadDeleteFilePage;

    @FXML
    private Button NotepaddeletefilebackBTN;

    @FXML
    private Button NotepaddeletefiledeleteBTN;

    @FXML
    private TextArea NotepadloadfiledirectoryinsertionTXTField;

    @FXML
    private Label NotepadloadfileerrorLBL;

    //passkari stage
    public void initFunction10(Stage NotePadDeleteFilePage){
        this.NotePadDeleteFilePage = NotePadDeleteFilePage;
    }

    // daryaft location morede nazar baraye pak sazi file
    @FXML
    private void NotePadMianPageDeleteHandler(ActionEvent event){
        try {
            File file = new File(NotepadloadfiledirectoryinsertionTXTField.getText());
            file.delete();
        }catch (Exception e){
            NotepadloadfileerrorLBL.setText("Error : " + e.getMessage());
        }

    }

    // return to main menu
    @FXML
    private void NotePadMainPageBackHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadMainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadMainPageController controller = loader.getController();
        controller.initFunction7(NotePadDeleteFilePage);

        NotePadDeleteFilePage.setScene(new Scene(loader.getRoot()));
    }

}
