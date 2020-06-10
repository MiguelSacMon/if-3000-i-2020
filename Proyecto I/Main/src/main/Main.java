
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

   @Override
   public void start(Stage primaryStage) {

    //Instancia de clase
    intefaceMenu iM = new intefaceMenu();
 
    Scene scene = new Scene(iM.getVBox(),850, 650);
  

   primaryStage.setTitle("Proyecto I Programación II");
   primaryStage.setScene(scene);
   primaryStage.show();
   }

   public static void main (String[] args) { 
      
       launch(args);
   }
    
}