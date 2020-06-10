
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


public class InterfaceMaintenance {
    
    public void cleanText(){
           File fileCountries = new File("catalogo.txt");
            Alert a_Confirmar = new Alert(Alert.AlertType.CONFIRMATION);
            a_Confirmar.setTitle("Confirmacion de borrado");
            a_Confirmar.setHeaderText(null);
            a_Confirmar.initStyle(StageStyle.UTILITY);
            a_Confirmar.setContentText("Todos los datos seran borrados \n ¿Esta seguro que desea continuar?");
        Optional<ButtonType>result = a_Confirmar.showAndWait();
        if(result.get()==ButtonType.OK){
          
            fileCountries.delete();
        try{
            FileOutputStream fos = new FileOutputStream(fileCountries, true);
            PrintStream ps = new  PrintStream(fos);
        }//End Try
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }

            
    }
    }
}
