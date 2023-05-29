package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipPageController {

    private Stage ZipPageController;

    @FXML
    private Button ZippagebackBTN;

    @FXML
    private TextField ZippagelocationTXTFiled;

    @FXML
    private Button ZippagesaveBTN;

    @FXML
    private Label ZippageerrorLBL;

    @FXML
    private TextField ZippagezipnameTXTField;

    // passkari stage
    public void initFunction19(Stage ZipPageController){
        this.ZipPageController = ZipPageController;
    }

    //return to previus page
    @FXML
    private void ZipStageBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\Zip&UnzipPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ZipAndUnzipPageController zipAndUnzipPageController = loader.getController();
        zipAndUnzipPageController.initFunction18(ZipPageController);

        ZipPageController.setScene(new Scene(loader.getRoot()));
    }

    // daryafte location file va name enthkhabi baraye zip shodn va anjame amaliat
    @FXML
    private void ZipPageSaveHandler(ActionEvent event){
        try{
            String sourceFile = ZippagelocationTXTFiled.getText();
            FileOutputStream fos = new FileOutputStream(ZippagezipnameTXTField.getText());
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();}catch (FileNotFoundException e){
            ZippageerrorLBL.setText("File Not Found Or Invalid Input Format");
        }catch (IOException e){
            ZippageerrorLBL.setText("File Not Found Or Invalid Input Format");
        }
    }

}
