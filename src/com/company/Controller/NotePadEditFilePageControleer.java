package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotePadEditFilePageControleer {

    private Stage NotePadEditFilePage;

    @FXML
    private Button NotepadeditfilebackBTN;

    @FXML
    private TextField NotepadeditfileeditfieldTXTField;

    @FXML
    private Label NotepadeditfileerrorLBL;

    @FXML
    private Button NotepadeditfilesaveBTN;

    @FXML
    private Button NotepadeditfileloadBTN;

    @FXML
    private TextField NotepadeditfiledirectoryinsertionTXTField;

    //passkari stage
    public void initFunction11(Stage NotePadEditFilePage){
        this.NotePadEditFilePage = NotePadEditFilePage;
    }

    // return to main menu
    @FXML
    private void NotePadEditFilePageBackHandler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\NotePadMainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NotePadMainPageController controller = loader.getController();
        controller.initFunction7(NotePadEditFilePage);

        NotePadEditFilePage.setScene(new Scene(loader.getRoot()));
    }

    // ba gereftan loacation file mohtavyat an ra load mikonad
    @FXML
    private void NotePadEditFileLoadHandler(ActionEvent event){
        try {
            FileInputStream fis = new FileInputStream(NotepadeditfiledirectoryinsertionTXTField.getText());
            Scanner sc = new Scanner(fis);

            String filecontent = "";
            while (sc.hasNextLine()){
                filecontent = filecontent.concat(sc.nextLine() + "\n");
            }
            NotepadeditfileeditfieldTXTField.setText(filecontent);

            sc.close();
            fis.close();
        }catch (FileNotFoundException e){
            NotepadeditfileerrorLBL.setText("Invalid File Name Or Directory");
        }catch (Exception e){
            NotepadeditfileerrorLBL.setText("Invalid File Name Or Directory");
        }

    }

    // mohtavyat jadid ra dar file save mikonad
    @FXML
    private void NotePadEditFileSaveHandler(ActionEvent event){
        try {
            FileWriter file = new FileWriter(NotepadeditfiledirectoryinsertionTXTField.getText());
            file.write(NotepadeditfileeditfieldTXTField.getText());
            file.close();
        } catch (FileNotFoundException e){
            NotepadeditfileerrorLBL.setText("Invalid File Name Or Directory");
        }catch (IOException e) {
            NotepadeditfileerrorLBL.setText("Invalid File Name Or Directory");
        }catch (Exception e){
            NotepadeditfileerrorLBL.setText("Invalid File Name Or Directory");
        }
    }
}
