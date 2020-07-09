package com.company;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.security.spec.ECField;
import java.util.Hashtable;
import java.util.List;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class PantInicio extends Application {
    static AnchorPane root;
    static List<AnchorPane> grid = new ArrayList<AnchorPane>();
    private MediaPlayer media;

    static Integer score=0;
    public static Integer tamaño=10;
    static Integer time=100;

    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<Integer> puntajes = new ArrayList<>();

    private static int idx_cur = 0;
    @Override
    public void start(Stage primaryStage){

        try {
            root = (AnchorPane)FXMLLoader.load(getClass().getResource("Rooting.fxml"));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("PantallaInicio.fxml")));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("PantallaPC.fxml")));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("PantallaPR.fxml")));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("PantallaInstrucciones.fxml")));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Sin título.fxml")));
            grid.add((AnchorPane)FXMLLoader.load(getClass().getResource("Video.fxml")));
            final URL resource = getClass().getResource("one.mp3");
            final Media media = new Media(resource.toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);

            Image [] imageArray = new Image[4];
            for (int i = 5; i < 9; i++)
                imageArray[i-5] = new Image("AssetsSpaceWar/Nave" + i + ".png");


            Image mb = new Image("AssetsSpaceWar/fondo.png");
            Canvas canvas = new Canvas(2000,2000);
            root.getChildren().add(canvas);
            GraphicsContext graphic = canvas.getGraphicsContext2D();
            new AnimationTimer(){
                double tiempo;
                int index;
                int x = 0;
                int y = 0;

                @Override
                public void handle(long now) {
                    tiempo = now / 10000000;
                    index = (int) tiempo % imageArray.length;
                    graphic.drawImage(mb, 0, 0);

                    graphic.drawImage(imageArray[0],x,-y);
                    graphic.drawImage(imageArray[2],30,-y);

                    graphic.drawImage(imageArray[1],400,-y);
                    graphic.drawImage(imageArray[3],x,100);
                    graphic.drawImage(imageArray[3],x,500);
                    x = x + 5;
                    y = y + 2;
                    x = x > 1000 ? -200 : x;
                    y = y > 1000 ? -562 : y;

                }
            }.start();
            root.getChildren().add(grid.get(0));
            mediaPlayer.play();
            Scene scene = new Scene(root,1000,562);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void init_app(){
        for(int i=0;i<grid.size();i++){

        }
    }
    public static AnchorPane get_Pane(int idx){
        return grid.get(idx);
    }

    public static void set_pane(int idx){
        root.getChildren().remove(grid.get(idx_cur));
        root.getChildren().add(grid.get(idx));
        idx_cur = idx;
    }

    public static void main(String[] arg) {
        launch(arg);

    }
    public static void setTimer(int a){
        time=a;
    }
}
