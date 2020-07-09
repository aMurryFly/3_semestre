/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebote;

//import java.time.Duration;
//import java.util.Objects;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pon_c
 */
public class Rebote extends Application {
    
    Poligono figura = new cuadrado(40.0,40.0,"azul");
    boolean change_1=false;
    boolean change_2=false;
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        
        /*
        Polygon figura = new Polygon();
        figura.getPoints().addAll(new Double[]{ 0.0,0.0, 40.0,0.0, 40.0,40.0, 0.0,40.0});
        */
        
        
        root.getChildren().add(figura);
        
        Scene scene = new Scene(root, 400, 550, ColorFx.StringToColor("transparente"));
        
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //EVENT HANDLER
        
        EventHandler<MouseEvent> manejadorRaton = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Platform.exit();
            }        
        };
        
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, manejadorRaton);
        
        EventHandler<ActionEvent> manejadorAccion = new EventHandler<ActionEvent>(){
            double dx = 3;
            double dy = 8;
            
            @Override
            public void handle(ActionEvent event) {
                Bounds limite = root.getBoundsInLocal();
                
                figura.setLayoutX(figura.getLayoutX()+ dx);
                figura.setLayoutY(figura.getLayoutY()+ dy);

                if(figura.getLayoutX()>= (limite.getMaxX() - figura.getMaxL()) || figura.getLayoutX()<= (limite.getMinX())){
                    dx=-dx;
                    root.getChildren().remove(figura);
                    figura= cambiarForma(figura);   
                    root.getChildren().add(figura);

                }
                
                if(figura.getLayoutY()>= (limite.getMaxY() - figura.getMaxL()) || figura.getLayoutY()<= (limite.getMinY())){
                    dy=-dy;
                    root.getChildren().remove(figura);
                    figura= cambiarFormaAlter(figura);
                    root.getChildren().add(figura);    
                }
            }
        };
        
        KeyFrame fotograma = new KeyFrame( Duration.millis(20), manejadorAccion );
        Timeline linea = new Timeline(fotograma);
        linea.setCycleCount(Timeline.INDEFINITE);
        linea.play();
        
    }
    /*
    public static Poligono cambiarForma(Poligono figura){
        if(figura instanceof cuadrado){
            Triangulo triangulo = new Triangulo( ((cuadrado)figura).getBase(), ((cuadrado)figura).getAltura(), figura.getColorRelleno() );
            triangulo.setLayoutX(figura.getLayoutX());
            triangulo.setLayoutY(figura.getLayoutY());
            return triangulo;     
        }
        else{
            cuadrado cuadrado = new cuadrado( ((Triangulo)figura).getBase(), ((Triangulo)figura).getAltura(), figura.getColorRelleno() );
            cuadrado.setLayoutX(figura.getLayoutX());
            cuadrado.setLayoutY(figura.getLayoutY());
            return cuadrado; 
        }m 
    
    }*/
    public  Poligono cambiarForma(Poligono figura){
        if(figura instanceof cuadrado){
            Rectangulo rectangulo = new Rectangulo( ((cuadrado)figura).getBase()/2, ((cuadrado)figura).getAltura(), "rojo" );
            rectangulo.setLayoutX(figura.getLayoutX());
            rectangulo.setLayoutY(figura.getLayoutY());
            change_1=true;
            return rectangulo;     
        }
        else if(figura instanceof Rectangulo) {
            cuadrado cuadrado = new cuadrado( ((Rectangulo)figura).getBase()*2, ((Rectangulo)figura).getAltura(), "verde");
            cuadrado.setLayoutX(figura.getLayoutX());
            cuadrado.setLayoutY(figura.getLayoutY());
            return cuadrado; 
        
        }
        else 
            return null;
    }
    
    public  Poligono cambiarFormaAlter(Poligono figura){
        if(figura instanceof cuadrado){
            Rectangulo rectangulo = new Rectangulo( ((cuadrado)figura).getBase(), ((cuadrado)figura).getAltura()/2, "azul" );
            rectangulo.setLayoutX(figura.getLayoutX());
            rectangulo.setLayoutY(figura.getLayoutY());
            change_2=true;
            return rectangulo;     
        }
        else if(figura instanceof Rectangulo) {
            cuadrado cuadrado = new cuadrado( ((Rectangulo)figura).getBase(), ((Rectangulo)figura).getAltura()*2, "verde" );
            cuadrado.setLayoutX(figura.getLayoutX());
            cuadrado.setLayoutY(figura.getLayoutY());
            return cuadrado; 
        }
        return null;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
