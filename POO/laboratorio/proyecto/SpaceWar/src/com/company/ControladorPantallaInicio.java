package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPantallaInicio implements Initializable {

    @FXML
    private void botonPC_action(ActiveEvent event){
        PantInicio.set_pane(1);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void botonPC2(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(0));
        PantInicio.root.getChildren().add(PantInicio.grid.get(1));
    }

    public void botonPR(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(0));
        PantInicio.root.getChildren().add(PantInicio.grid.get(2));
    }

    public void botonInstrucciones(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(0));
        PantInicio.root.getChildren().add(PantInicio.grid.get(3));
    }

    public void botonPC3(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(0));
        PantInicio.root.getChildren().add(PantInicio.grid.get(4));
    }

    public void botonPC4(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(0));
        PantInicio.root.getChildren().add(PantInicio.grid.get(4));
    }
}
