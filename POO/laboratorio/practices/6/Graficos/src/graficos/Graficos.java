package graficos;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//EXTRAS
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author MURRY_FLY
 */
public class Graficos extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();//Es un contener como un grupo
        root.getChildren().add(btn);
        //
        
        Canvas lienzo = new Canvas(800,500);//Los argumentos son el tamaño del lienzo
        root.getChildren().add(lienzo);//Agregar al root (grupo)
        //Parte grafica
        GraphicsContext grafico = lienzo.getGraphicsContext2D();
        Image mb = new Image("graficos/fondo/fondo.jpg");
        
        Image[] imageArray = new Image[4];
        for(int i = 0;  i < imageArray.length; i++ ){
            imageArray[i] = new Image("secuencia/"+ i +".png");
        }
        
        new AnimationTimer(){
            double tiempo;
            int index;
            int x=0;
            
            //Un evento o manejador que reciba el timer
            @Override
            public void handle(long now) {//now es el reloj
                //System.out.println(now);
                tiempo = now / 100000000;
                index = (int)(tiempo % (imageArray.length));
                grafico.drawImage(mb, 0, 0);
                
                grafico.drawImage(imageArray[index], x, 215);
                x=x+5;
                x= x>800?-200:x;//Es un if en una linea
            }
            
        }.start();
        
        
        //
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
