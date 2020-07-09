package practice_5;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.Scene;




public class Practice_5 extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    //Sobreescribir
    public void start(Stage escenario){
        
        Group grupo = new Group();
        Scene escena = new Scene(grupo,600,300);
        
        escenario.setTitle("Hola Mundo JavaFx");
        escenario.setScene(escena);
        
        Button boton = new Button("Click here");
        boton.setDefaultButton(true);
        boton.setPrefSize(100, 50);
        boton.setLayoutX(105);
        boton.setLayoutY(110);
        
        boton.setOnAction( new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
                boton.setText("Suena");
                //Para buscar el archivo de sonido
                Media media = new Media(this.getClass().getResource("Perrito.wav").toString());
                MediaPlayer mp = new MediaPlayer(media);
                mp.play();
                
            } 
        } );
        
        grupo.getChildren().add(boton); 
        
        escenario.show();

        
        
        
        
        
        
        
    }
    
    
    
}
