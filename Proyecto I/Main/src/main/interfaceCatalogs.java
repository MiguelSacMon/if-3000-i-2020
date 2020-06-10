

package main;


import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Miguel IK
 */
public class interfaceCatalogs {
    
    logicCatalogs lC = new logicCatalogs();
    private String UrlCatalog = "catalogo.txt";
    public GridPane setInterfaceCatalogs(){


       //Configura el GridPane Inicial
        GridPane gP_interface = new GridPane();
        gP_interface.setVgap(20);
        gP_interface.setHgap(20);

        //Crea y agrega un label para el textfield tF_Name
        Label lB_Name = new Label("Nombre del producto:");
        lB_Name.setFont(new Font("Times New Roman", 19.5));
        lB_Name.setTextFill(Color.rgb(28, 41, 172));
        lB_Name.setStyle("-fx-font-weight: bold");
        gP_interface.add(lB_Name, 1, 0);



        //Crea y agrega un text field para añadir el nombre de los paises
        TextField tF_Name = new TextField();
         tF_Name.setMaxSize(120, 50);
        gP_interface.add(tF_Name,2,0);



         //Crea y agrega un label para el TextArea tA_Description
           Label lB_Description = new Label("Descripcion  a agregar");
        lB_Description.setFont(new Font("Times New Roman", 19.5));
        lB_Description.setTextFill(Color.rgb(28, 41, 172));
        lB_Description.setStyle("-fx-font-weight: bold");
        gP_interface.add(lB_Description, 1, 1);


        //Crea y agrega un TextArea para añadir una descripcion del país
         TextArea tA_Description = new TextArea();
          tA_Description.setMaxSize(250,125);
            GridPane.setColumnIndex(tA_Description, 0 );
            GridPane.setColumnSpan(tA_Description, 2 );
            tA_Description.setWrapText(true);
         gP_interface.add(tA_Description,2,1);

        ComboBox<String> cB_CatalogList = new ComboBox<>();
        //Crea un combobox, tiene la lista de productos
        cB_CatalogList.setValue("Seleccione el catalogo:");
        for (int i = 0; i < lC.readRegistersFile(UrlCatalog).length; i++) {
            cB_CatalogList.getItems().add(lC.readRegistersFile(UrlCatalog)[i].getNameCountry());
        }
        gP_interface.add(cB_CatalogList,2,2);
        
        //Crea y agrega un boton que añade toda la información al archivo  
        Button bTN_InsertCountry = new Button("Insertar producto");
             bTN_InsertCountry.setFont(new Font("Impact", 17.5));
         bTN_InsertCountry.setTextFill(Color.rgb(28, 41, 172));
        gP_interface.add(bTN_InsertCountry,1, 6);
        bTN_InsertCountry.setOnAction((event)->{
            String name = tF_Name.getText();
            String description =  tA_Description.getText();
            CatalogGS c = new CatalogGS(name, description);
            lC.insertProduct(c, cB_CatalogList.getValue());
            tF_Name.setText(null);

        });
        

    return gP_interface;
    }
            

    public GridPane setInterfaceModify(){
        //Crea el gridpane que funciona como interfaz para la subventana "modificar"
        GridPane gP_interfaceModify = new GridPane();
        gP_interfaceModify.setVgap(20);
        gP_interfaceModify.setHgap(20);

        //Crea un label
        Label lB_Name = new Label("Nombre del producto a modificar");
        lB_Name.setFont(new Font("IMPACT", 18));
        lB_Name.setTextFill(Color.web("#eff2e9"));
        gP_interfaceModify.add(lB_Name, 2, 1);
        
      
        TextField tF_Name = new TextField(); 
        tF_Name.setMaxSize(120, 50);
        gP_interfaceModify.add(tF_Name,4,1);
        
        
        //Crea un boton para confirmar los cambios
        Button bTN_ConfirmationModify = new Button("Confirmar cambios");
        bTN_ConfirmationModify.setFont(new Font("Impact", 17.5));
         bTN_ConfirmationModify.setTextFill(Color.web("#094293"));
         gP_interfaceModify.add(bTN_ConfirmationModify,2, 2);

           Label lB_Description = new Label("Descripcion del producto:");
        lB_Description.setFont(new Font("Impact", 19.5));
        lB_Description.setTextFill(Color.web("#eff2e9"));
        lB_Description.setStyle("-fx-font-weight: bold");
        gP_interfaceModify.add(lB_Description, 3, 3);
       
         TextArea tA_Description = new TextArea(); 
         tA_Description.setMaxSize(300, 100);
            GridPane.setColumnIndex(tA_Description, 0 );
            GridPane.setColumnSpan(tA_Description, 2 );
        gP_interfaceModify.add(tA_Description,4,3);
        

        ComboBox<String> cB_ProductList = new ComboBox<>();
        //Crea un combobox, tiene la lista de productos
        cB_ProductList.setValue("Seleccione el producto:");

        for (int i = 0; i < lC.readRegistersFile(UrlCatalog).length; i++) {
            cB_ProductList.getItems().add(lC.readRegistersFile(UrlCatalog)[i].getNameCountry());
            }

        gP_interfaceModify.add(cB_ProductList,3,1);
            bTN_ConfirmationModify.setOnAction((event)->{
                 
            String name = tF_Name.getText();
            String description =  tA_Description.getText();

            String all;
                all = tF_Name.getText()+"|"+tA_Description.getText();
                CatalogGS c = new CatalogGS(name, description);

            lC.modifyProducts(all, cB_ProductList.getValue());
            lC.insertProduct(c, cB_ProductList.getValue());
      
                  
                  tF_Name.setText(null);

                  tA_Description.setText(null);

         
        });
        
        return gP_interfaceModify;   
        
         
    }


    
   
}
