package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NotePadNewFilePage {

    private Stage NotePadNewFilePage;

    @FXML
    private TextArea NotepadNewfilepagetextTXTArea;

    @FXML
    private Button NotepadnewfilepagebackBTN;

    @FXML
    private TextField NotepadnewfilepagedriectoryTXTFiled;

    @FXML
    private Button NotepadnewfilepagesaveBTN;

    @FXML
    private Label NotepadnewfileerrorLBL;

    //passkari page ha
    public void initFunction8(Stage NotePadNewFilePage){
        this.NotePadNewFilePage = NotePadNewFilePage;
    }

    // yek file matni jadid misazad
    @FXML
    private void NotePadNewFileSaveHndler(ActionEvent event){

                try {
                    FileWriter file = new FileWriter(NotepadnewfilepagedriectoryTXTFiled.getText());
                    file.write(NotepadNewfilepagetextTXTArea.getText());
                    file.close();
                } catch (FileNotFoundException e){
                    NotepadnewfileerrorLBL.setText("Invalid File Name Or Directory");
                }catch (IOException e) {
                    NotepadnewfileerrorLBL.setText("Invalid File Name Or Directory");
                }catch (Exception e){
                    NotepadnewfileerrorLBL.setText("Invalid File Name Or Directory");
                }
        }


    // return to previous menu
    @FXML
    private void NotePadNewFileBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadMainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadMainPageController controller = loader.getController();
        controller.initFunction7(NotePadNewFilePage);

        NotePadNewFilePage.setScene(new Scene(loader.getRoot()));
    }

}
