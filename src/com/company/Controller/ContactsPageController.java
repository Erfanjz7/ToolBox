package com.company.Controller;

import com.company.Model.Contacts;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsPageController {

    // shomarande tedade dafati ke safhe add ra baz kardim
    private static int addCounter = -1;

    // tedade contact ha tebghe tedade khabde shode az file
    private static int counter = -1;

    private Stage ContactsPageController;

    private Contacts contacts;

    private static ArrayList<Contacts> CONTACTS = new ArrayList<Contacts>();
    //private static ArrayList<Contacts> contactsData = new ArrayList<Contacts>();

    @FXML
    private TableView<Contacts> ContactsTableView;

    @FXML
    private Button ContactsaddBTN;

    @FXML
    private Button ContactsbackBTN;

    @FXML
    private Button ContactsdeleteBTN;

    @FXML
    private Button ContactseditBTN;

    @FXML
    private Label ContactspageerrorLBL;

    @FXML
    private TableColumn<Contacts, String> ContactspageadressCOL;

    @FXML
    private TableColumn<Contacts, String> ContactspagelastnameCOL;

    @FXML
    private TableColumn<Contacts, String> ContactspagenameCOL;

    @FXML
    private TableColumn<Contacts, String> ContactspagephonenumberCOL;

//passkari stage ha
    public void initFunction17(Stage ContactsPageController){
        this.ContactsPageController = ContactsPageController;
    }

    //dar in tabe ebteda khai boodan ta naboodane file ra check mikonim va dar soorate khai naboodan moshkhasate contact harar yek be yek az an mikhanim va sepas be namayesh migozarim
    public void initFunction12(Stage ContactsPageController){
        counter = -1;
        this.ContactsPageController = ContactsPageController;
        boolean fileemptycheck = false;
        try {
            File fileboi = new File("C:\\Users\\MSI\\Desktop\\Contacts.txt");
            if (fileboi.length() == 0) {
                fileemptycheck = false;
            } else {
                fileemptycheck = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(fileemptycheck) {
            try {
                File file = new File("C:\\Users\\MSI\\Desktop\\Contacts.txt");
                Scanner sc = new Scanner(file);
                String filecontent = "";
                ArrayList<String> StringContent = new ArrayList<String>();
                while (sc.hasNextLine()) {
                    filecontent = sc.nextLine();
                    Scanner s = new Scanner(filecontent);
                    String stringcontent = "";
                    Contacts contactsDAta = new Contacts();
                    while (s.hasNext()) {
                        StringContent.add(s.next());
                    }
                    contactsDAta.setName(StringContent.get(0));
                    contactsDAta.setLastName(StringContent.get(1));
                    contactsDAta.setAdress(StringContent.get(2));
                    contactsDAta.setPhonenumber(StringContent.get(3));
                    CONTACTS.add(contactsDAta);
                    counter++;
                    addCounter++;
                    StringContent.clear();
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            ContactspagenameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Name"));
            ContactspagelastnameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("LastName"));
            ContactspageadressCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Adress"));
            ContactspagephonenumberCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Phonenumber"));
            for (int i = 0; i <= counter; i++) {
                ContactsTableView.getItems().add(CONTACTS.get(i));
            }
        }
    }

    // in tabe pass az ezafe kardan contact ha ejra mishavad va dar har martabe contct harar be arraylist ezafe mikonad  va an hara be namayesh dar mi avarad va an hara dar file zakhire mikonad
    public void initFunction14(Stage ContactsPageController , Contacts contacts) {
        this.ContactsPageController = ContactsPageController;
        this.contacts = contacts;
        ContactspagenameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Name"));
        ContactspagelastnameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("LastName"));
        ContactspageadressCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Adress"));
        ContactspagephonenumberCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Phonenumber"));
        CONTACTS.add(contacts);
        for (int i = 0 ; i <=addCounter ; i++){
            ContactsTableView.getItems().add(CONTACTS.get(i));
        }

        String contactDataINFile = "";
        for (int i = 0 ; i <=addCounter ; i++) {
            contactDataINFile = contactDataINFile.concat(CONTACTS.get(i).getName() + " " + CONTACTS.get(i).getLastName() + " " + CONTACTS.get(i).getAdress() + " " + CONTACTS.get(i).getPhonenumber() + "\n");
        }
            try {
                FileWriter fileWriter = new FileWriter("C:\\Users\\MSI\\Desktop\\Contacts.txt");
                fileWriter.write(contactDataINFile);
                fileWriter.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }



    }

    // in tabe pass az edit arraylist edit shode ra be ejra dar avarde va dar file zakhir mikonad
    public void initFunction16(Stage ContactsPageController , ArrayList<Contacts> arrayList){
        this.ContactsPageController = ContactsPageController;
        CONTACTS = arrayList;
        ContactspagenameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Name"));
        ContactspagelastnameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("LastName"));
        ContactspageadressCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Adress"));
        ContactspagephonenumberCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Phonenumber"));
        for (int i = 0 ; i < (counter + 1) ; i++){
            ContactsTableView.getItems().add(CONTACTS.get(i));
        }
        String contactDataINFile = "";
        for (int i = 0 ; i <=addCounter ; i++) {
            contactDataINFile = contactDataINFile.concat(CONTACTS.get(i).getName() + " " + CONTACTS.get(i).getLastName() + " " + CONTACTS.get(i).getAdress() + " " + CONTACTS.get(i).getPhonenumber() + "\n");
        }
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\MSI\\Desktop\\Contacts.txt");
            fileWriter.write(contactDataINFile);
            fileWriter.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //bargozari safhe addcontact
    @FXML
    private void ContactsPageAddhandler(ActionEvent event){
        addCounter = addCounter + 1;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\ContactsAddPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContactsAddPageController controller = loader.getController();
        controller.initFunction13(ContactsPageController);

        ContactsPageController.setScene(new Scene(loader.getRoot()));
    }

    // return to main menu
    @FXML
    private void ContactsPageBackhandler(ActionEvent event){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

         MainPageController controller = loader.getController();
        controller.initFunction(ContactsPageController);

        ContactsPageController.setScene(new Scene(loader.getRoot()));
    }

    //pak kardane etelaate contact ha
    @FXML
    private void CotactsPageDeleteHandler(ActionEvent event){
        int counter = -1;
        boolean fileempetycheck = false;
        try {
        File boi3 = new File("C:\\Users\\MSI\\Desktop\\Contacts.txt");
        if(boi3.length() == 0)
        {
            fileempetycheck = false;
        }
        else
        {
            fileempetycheck = true;
        }}catch (Exception e){
            e.printStackTrace();
        }
        if(fileempetycheck) {
            CONTACTS.clear();
            addCounter = -1;

            ContactspagenameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Name"));
            ContactspagelastnameCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("LastName"));
            ContactspageadressCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Adress"));
            ContactspagephonenumberCOL.setCellValueFactory(new PropertyValueFactory<Contacts , String>("Phonenumber"));
            Contacts nigga = new Contacts("", "", "", "");
                ContactsTableView.getItems().add(nigga);
            try {
                FileWriter boi2 = new FileWriter("C:\\Users\\MSI\\Desktop\\Contacts.txt");
                boi2.write("");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //bargozari safhe edit
    @FXML
    private void ContactsPageEdithandler(ActionEvent event){
        if(CONTACTS.size() != 0) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("..\\View\\ContactsPageEditPage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ContactsEditPageController controller = loader.getController();
            controller.initFunction15(ContactsPageController, CONTACTS);

            ContactsPageController.setScene(new Scene(loader.getRoot()));
        }
        else{
            ContactspageerrorLBL.setText("List Is Empety");
        }

    }


}
