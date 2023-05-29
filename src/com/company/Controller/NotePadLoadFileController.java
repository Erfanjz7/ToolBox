package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NotePadLoadFileController {

    private Stage NotePadLoadFile;

    @FXML
    private Button NotepadloadfilebackBTN;

    @FXML
    private TextField NotepadloadfiledriectoryinsertionTXTField;

    @FXML
    private Button NotepadloadfileloadBTN;

    @FXML
    private Label NotepadloadfileoadedfileLBL;

    @FXML
    private Label NotepadloadfileerrorLBL;

    // passkari stage
    public void initFunction9(Stage NotePadLoadFile) {
        this.NotePadLoadFile = NotePadLoadFile;
    }

    // mohtavyate file ra be gerftane loacation an bar gozari mikonad
    @FXML
    private void NotePadLoadFileLoadHandler(ActionEvent event){
        try {
            FileInputStream fis = new FileInputStream(NotepadloadfiledriectoryinsertionTXTField.getText());
            Scanner sc = new Scanner(fis);

            String filecontent = "";
            while (sc.hasNextLine()){
                filecontent = filecontent.concat(sc.nextLine() + "\n");
            }
            NotepadloadfileoadedfileLBL.setText(filecontent);

            sc.close();
            fis.close();
        }catch (FileNotFoundException e){
            NotepadloadfileerrorLBL.setText("Invalid File Name Or Directory");
        }catch (Exception e){
            NotepadloadfileerrorLBL.setText("Invalid File Name Or Directory");
        }
    }

    //return to maiin menu
    @FXML
    private void NotePadLoadFileBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadMainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadMainPageController controller = loader.getController();
        controller.initFunction7(NotePadLoadFile);

        NotePadLoadFile.setScene(new Scene(loader.getRoot()));
    }

}
