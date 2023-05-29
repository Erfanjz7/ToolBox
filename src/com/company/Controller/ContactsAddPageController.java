package com.company.Controller;

import com.company.Model.Contacts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class ContactsAddPageController {

    private Stage ContactsAddPageController;

    @FXML
    private Label ContactsaddpageadressLBL;

    @FXML
    private Button ContactsaddpagebackBTN;

    @FXML
    private Label ContactsaddpagelastnameLBL;

    @FXML
    private TextField ContactsaddpagelastnameTXTField;

    @FXML
    private TextField ContactsaddpagenadressTXTField;

    @FXML
    private Label ContactsaddpagenameLBL;

    @FXML
    private TextField ContactsaddpagenameTXTField;

    @FXML
    private Label ContactsaddpagephonenumberLBL;

    @FXML
    private TextField ContactsaddpagephonenumberTXTField;

    @FXML
    private Button ContactsaddpagesaveBTN;

    //passkari stage ha

    public void initFunction13(Stage ContactsAddPageController){
        this.ContactsAddPageController = ContactsAddPageController;
    }


    @FXML
    private void ContactsAddPageBackhandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\ContactsPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactsPageController controller = loader.getController();
        controller.initFunction12(ContactsAddPageController);

        ContactsAddPageController.setScene(new Scene(loader.getRoot()));
    }

    // dar in tabe yek contact jadid az class contact misazim va pass az sakht an ra be arraylist contact ha pass midahim
    // yek regex ham baraye shomare telephone va shoro shodane an ba 09 darim
    @FXML
    private void ContactsAddPageSaveHandler(ActionEvent event) {
        boolean check = Pattern.matches("[0-9]{11,11}", ContactsaddpagephonenumberTXTField.getText());
        boolean check2 = ContactsaddpagephonenumberTXTField.getText().charAt(0) == '0' & ContactsaddpagephonenumberTXTField.getText().charAt(1) == '9';
        if (check && check2) {
            String Name = ContactsaddpagenameTXTField.getText();
            String Lastname = ContactsaddpagelastnameTXTField.getText();
            String Adress = ContactsaddpagenadressTXTField.getText();
            String Phonenumber = ContactsaddpagephonenumberTXTField.getText();
            Contacts contact = new Contacts(Name, Lastname, Adress, Phonenumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("..\\View\\ContactsPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ContactsPageController controller = loader.getController();
            controller.initFunction14(ContactsAddPageController, contact);

            ContactsAddPageController.setScene(new Scene(loader.getRoot()));

        }
        else
        {
            ContactsaddpagephonenumberTXTField.setText("Invalid Phone Number format ");
        }
    }

}
