
package main;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

public class InterfaceAboutCredit {


public VBox getInterfaceCredits(){
    
    VBox vB_Credits = new VBox();
    TextArea tA_Credits = new TextArea();
    tA_Credits.setEditable(false);
    tA_Credits.setText("Miguel Sánchez Montes" + "\n" + "Carnet B97267" + "\n" + "Programacion II");
    
    vB_Credits.getChildren().addAll(tA_Credits);
return vB_Credits; 
}
}
