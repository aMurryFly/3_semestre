/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import javafx.scene.Parent;

public class Ship extends Parent {
    public int type;
    public boolean vertical = true;

    private int health;

    public Ship(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        health = type;

        /*VBox vbox = new VBox();
        for (int i = 0; i < type; i++) {
            Rectangle square = new Rectangle(30, 30);
            square.setFill(null);
            square.setStroke(Color.BLACK);
            vbox.getChildren().add(square);
        }
        getChildren().add(vbox);*/
    }

    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
    }
}