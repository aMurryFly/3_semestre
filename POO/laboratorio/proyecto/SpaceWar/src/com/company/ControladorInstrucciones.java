package com.company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class ControladorInstrucciones implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void IrInicio(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(3));
        PantInicio.root.getChildren().add(PantInicio.grid.get(0));
    }
}
