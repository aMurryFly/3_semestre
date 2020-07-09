package com.company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPantallaJuego implements Initializable {
    SpaceMain space = new SpaceMain();

    //public HBox Hboxin = new HBox(60,space.create().get(0),space.create().get(1));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    /*
    public void Create(KeyEvent keyEvent) {
        Hboxin.setAlignment(Pos.CENTER);
        PantInicio.root.getChildren().add(Hboxin);
    }

    public void nnnnn(ActionEvent actionEvent) {
        Hboxin.setAlignment(Pos.CENTER);
        PantInicio.grid.get(4).getChildren().add(Hboxin);
    }*/
}