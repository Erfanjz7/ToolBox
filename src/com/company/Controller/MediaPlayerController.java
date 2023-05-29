package com.company.Controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaPlayerController implements Initializable {

    private Stage MediaPlayerController;

    @FXML
    private Button MediapalyerbackwardBTN;

    @FXML
    private Slider MediapalyerdurationSlider;

    @FXML
    private Button MediapalyerexitTN;

    @FXML
    private Button MediapalyerfastbackwardBTN;

    @FXML
    private Button MediapalyerfastforwardTN;

    @FXML
    private Button MediapalyerforwardBTN;

    @FXML
    private Button MediapalyeropenfileBTN;

    @FXML
    private Button MediapalyerpauseBTN;

    @FXML
    private Button MediapalyerplayBTN;

    @FXML
    private Button MediapalyerstopBTN;

    @FXML
    private Slider MediapalyervolumeSlider;

    @FXML
    private Button MediaplayerbackBTN;

    @FXML
    private MediaView mediaView;


    private String filepath;

    private MediaPlayer mediaPlayer;

    //passkari stage va agar do bar roye safhe click shod safhe full screen mishavad
    public void initFunction20(Stage MediaPlayerController){
        this.MediaPlayerController = MediaPlayerController;
        MediaPlayerController.getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    MediaPlayerController.setFullScreen(true);
                }
            }
        });
    }

    //return to main menu
    @FXML
    private void MediaPlayerBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MediaPlayerController.setScene(new Scene(loader.getRoot()));
        MainPageController mainPageController = loader.getController();
        mainPageController.initFunction(MediaPlayerController);
    }

    // yabe baraye entejhab file faghat be formate mp4 va sepas pakhshe an va tnazim slider volume va duration video
    @FXML
    private void MediaPlayerOpenFileHandler(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp4)" ,"*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        try {
            filepath = file.toURI().toString();
            if (filepath != null) {
                Media media = new Media(filepath);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);

                DoubleProperty width = mediaView.fitWidthProperty();
                DoubleProperty height = mediaView.fitHeightProperty();

                width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

                MediapalyervolumeSlider.setValue(mediaPlayer.getVolume() * 100);
                MediapalyervolumeSlider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        mediaPlayer.setVolume(MediapalyervolumeSlider.getValue() / 100);
                    }
                });

                mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                        MediapalyerdurationSlider.setValue(newValue.toSeconds());
                    }
                });

                MediapalyerdurationSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mediaPlayer.seek(Duration.seconds(MediapalyerdurationSlider.getValue()));
                    }
                });

                mediaPlayer.play();
            }
        }catch (NullPointerException e){

        }

    }

    // pause
    @FXML
    private void MediaPlayerPauseHandler(ActionEvent event){
        mediaPlayer.pause();
    }

    // paly va reset kardane sorate paksh
    @FXML
    private void MediaPlayerPlayHandler(ActionEvent event){
        mediaPlayer.setRate(1);
        mediaPlayer.play();
    }

    // stop
    @FXML
    private void MediaPlayerStopHandler(ActionEvent event){
        mediaPlayer.stop();
    }

    // 2 barabar karadane sorate pakhsh
    @FXML
    private void MediaPlayerFastForwardHandler(ActionEvent event){
        mediaPlayer.setRate(2);
    }

    //1.5 barabr kardane sorate pakhsh
    @FXML
    private void MediaPlayerForwardHandler(ActionEvent event){
        mediaPlayer.setRate(1.5);
    }

    //0.75 barabar kardane sorate paksh
    @FXML
    private void MediaPlayerBackwardHandler(ActionEvent event){
        mediaPlayer.setRate(0.75);
    }

    //nesf kardane sorate pakhsh
    @FXML
    private void MediaPlayerFastBackwardHandler(ActionEvent event){
        mediaPlayer.setRate(0.5);
    }

    // khorroj az baraneme
    @FXML
    private void MediaPlayerExitHandler(ActionEvent event){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
