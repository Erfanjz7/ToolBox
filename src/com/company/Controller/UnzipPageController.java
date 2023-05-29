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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipPageController {

    private Stage UnzipPageController;

    @FXML
    private TextField Unzipageziplocation;

    @FXML
    private Button UnzippagebackBTN;

    @FXML
    private TextField Unzippagedestonation;

    @FXML
    private Button UnzippagesaveBTN;

    @FXML
    private Label UnzippageerrorLBL;

    //passkari stage
    public void initFunction20(Stage UnzipPageController ){
        this.UnzipPageController = UnzipPageController;
    }

    // yek class baraye unzip karadne yek zip
    private static void unzipFolder(Path source, Path target) throws IOException {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source.toFile()))) {

            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {

                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }
                Path newPath = zipSlipProtect(zipEntry, target);

                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {

                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                }

                zipEntry = zis.getNextEntry();

            }
            zis.closeEntry();

        }
    }

    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }
        return normalizePath;
    }

    // return to prevois page
    @FXML
    private void UnZipStageBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\Zip&UnzipPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            UnzippageerrorLBL.setText("Invalid Path or Input Format");
        }


        ZipAndUnzipPageController zipAndUnzipPageController = loader.getController();
        zipAndUnzipPageController.initFunction18(UnzipPageController);

        UnzipPageController.setScene(new Scene(loader.getRoot()));
    }

    // locattion zip va maghsade morde nazar baraye unzip shodan ra migirad va amaliat ra anjam midahad
    @FXML
    private void UnzipPageSaveHandler(ActionEvent event){
        Path source = Paths.get(Unzipageziplocation.getText());
        Path target = Paths.get(Unzippagedestonation.getText());

        try {
            unzipFolder(source, target);
            System.out.println("Done");

        } catch (IOException e) {
            UnzippageerrorLBL.setText("Invalid Path or Input Format");
        }
    }

}
