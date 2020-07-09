package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPCredits implements Initializable {
    public void IrInicio(ActionEvent actionEvent) {
        PantInicio.root.getChildren().remove(PantInicio.grid.get(4));
        PantInicio.root.getChildren().add(PantInicio.grid.get(0));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
