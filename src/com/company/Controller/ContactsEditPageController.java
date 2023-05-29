package com.company.Controller;

import com.company.Model.Contacts;
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
import java.util.regex.Pattern;

public class ContactsEditPageController {

    private Stage ContactsEditPageController;

    private static ArrayList<Contacts> contactsForEdit = new ArrayList<Contacts>();

    @FXML
    private TextField ContactseditadressTXTField;

    @FXML
    private Button ContactseditbackBTN;

    @FXML
    private Label ContactsediterrorLBL;

    @FXML
    private TextField ContactseditlastnameTXTField;

    @FXML
    private Button ContactseditloadBTN;

    @FXML
    private TextField ContactseditnameTXTField;

    @FXML
    private TextField ContactseditphonenumberTXTField;

    @FXML
    private Button ContactseditsaveBTN;

    @FXML
    private TextField ContactsselectedcontactTXTField;

    //passkari page va array listi k dar an contact ha ra zakhir karde im ra be in page pass midahim ke pass az emale taghirat dobare be page asli baz gardand
    public void initFunction15(Stage ContactsEditPageController , ArrayList<Contacts> arrayList){
        this.ContactsEditPageController = ContactsEditPageController;
        contactsForEdit = arrayList;
    }

    // return to main menu
    @FXML
    private void ContactsEditPageBackhandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\ContactsPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactsPageController controller = loader.getController();
        controller.initFunction12(ContactsEditPageController);

        ContactsEditPageController.setScene(new Scene(loader.getRoot()));
    }

    // dar inja az karbar mikham ke contacti ke mikhahad virayesh konad ra entekhab konad , ba koake regex , sepas etelaate contact ra be namayesh dar mi avarim
    @FXML
    private void ContactsEditPageLoadHandler(ActionEvent event){
        boolean check = Pattern.matches("[0-9]{1,9}" , ContactsselectedcontactTXTField.getText());
        if(check){
            try {
        int selectedContact = (Integer.parseInt(ContactsselectedcontactTXTField.getText()) - 1);
        ContactseditnameTXTField.setText(contactsForEdit.get(selectedContact).getName());
        ContactseditlastnameTXTField.setText(contactsForEdit.get(selectedContact).getLastName());
        ContactseditadressTXTField.setText(contactsForEdit.get(selectedContact).getAdress());
        ContactseditphonenumberTXTField.setText(contactsForEdit.get(selectedContact).getPhonenumber());}catch (IndexOutOfBoundsException e){
                ContactsediterrorLBL.setText("Selected Number Doesn't Exist");
            }}
        else
        {
            ContactsediterrorLBL.setText("Invalid Input Format");
        }
    }

    // dar in tabe etelatae edit shode ra save mikonim va arraylist virayesh shode ra be safhe asli jahate namyesh pass midahim
    @FXML
    private void ContactsEditPageSaveHandler(ActionEvent event) {
        int selectedContact = (Integer.parseInt(ContactsselectedcontactTXTField.getText()) - 1);
        boolean check = Pattern.matches("[0-9]{11,11}", ContactseditphonenumberTXTField.getText());
        boolean check2 = ContactseditphonenumberTXTField.getText().charAt(0) == '0' & ContactseditphonenumberTXTField.getText().charAt(1) == '9';
        if (check && check2) {
            contactsForEdit.get(selectedContact).setName(ContactseditnameTXTField.getText());
            contactsForEdit.get(selectedContact).setLastName(ContactseditlastnameTXTField.getText());
            contactsForEdit.get(selectedContact).setAdress(ContactseditadressTXTField.getText());
            contactsForEdit.get(selectedContact).setPhonenumber(ContactseditphonenumberTXTField.getText());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("..\\View\\ContactsPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ContactsPageController controller = loader.getController();
            controller.initFunction16(ContactsEditPageController, contactsForEdit);

            ContactsEditPageController.setScene(new Scene(loader.getRoot()));
        }

        else
        {
            ContactsediterrorLBL.setText("Invalid Phone Number format ");
        }
    }
}
