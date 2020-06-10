package main;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Optional;

public class interfaceCC {
    public GridPane catalogCreator() {

        GridPane gP_interface = new GridPane();
        gP_interface.setVgap(20);
        gP_interface.setHgap(20);

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Sistema de creacion de catalogos");
        dialog.setHeaderText("Sistema de creacion de catalogos");
        dialog.setContentText("Ingrese el nombre del catalogo:");
        Optional<String> result = dialog.showAndWait();


        if (result.isPresent()) {
            try {
                String ruta =result.get();

                File file = new File(ruta+".txt");
                File file2 = new File ("Catalogo.txt");
                // Si el archivo no existe es creado
                if (file.exists()) {
                    Alert a_Confirmar = new Alert(Alert.AlertType.CONFIRMATION);
                    a_Confirmar.setTitle("Confirmacion de borrado");
                    a_Confirmar.setHeaderText(null);
                    a_Confirmar.initStyle(StageStyle.UTILITY);
                    a_Confirmar.setContentText("Este catalogo ya existe, ¿desea sobreescribirlo?");
                    Optional<ButtonType>result2 = a_Confirmar.showAndWait();
                    if(result2.get()==ButtonType.OK){
                        file.delete();
                        file.createNewFile();
                    }
                } else if (!file.exists()) {
                    file.createNewFile();


                    FileWriter fw2 = new FileWriter(file2, true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    bw2.write(ruta+".txt"  +"|"+"..."+"\n");
                    bw2.close();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return gP_interface;
    }

}

