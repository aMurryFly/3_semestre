package com.company;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPantallaPR implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tamaño.setItems(((FXCollections.observableArrayList(
                "8", "9","10")
        )));
        timer.setItems(((FXCollections.observableArrayList(
                "60", "120","180")
        )));

    }
    public static Reloj reloj;
    @FXML
    TextField nombre;
    @FXML
    ChoiceBox tamaño;
    @FXML
    ChoiceBox timer;
    public void IniciarJuego(ActionEvent actionEvent) {
        try {




            PantInicio.setTimer(Integer.parseInt(timer.getValue().toString()));
            PantInicio.nombres.add(nombre.getText());
            PantInicio.time = Integer.parseInt(timer.getValue().toString());
            SpaceMain.text4.setText(timer.getValue().toString());
            PantInicio.tamaño = Integer.parseInt(tamaño.getValue().toString());
            System.out.println(PantInicio.nombres.get(0));
            System.out.printf(PantInicio.time.toString());
            PantInicio.root.getChildren().remove(PantInicio.grid.get(2));
            SpaceMain game = new SpaceMain();
            PantInicio.root.getChildren().add(game.createContent());
            reloj = new Reloj(PantInicio.time);
            reloj.start();
        }catch(java.lang.NullPointerException em){
            Alert alert2 = new Alert(Alert.AlertType.WARNING, "Por favor, rellena todos los campos");
            alert2.showAndWait();
        }
    }

    public void BontonAtras(ActionEvent actionEvent) {
            PantInicio.root.getChildren().remove(PantInicio.grid.get(2));
            PantInicio.root.getChildren().add(PantInicio.grid.get(0));
    }
}
