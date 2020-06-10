
package main;

import javafx.application.Platform;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;


public class intefaceMenu {
 
    InterfaceAboutCredit iA = new InterfaceAboutCredit();
    interfaceCatalogs iC = new interfaceCatalogs();
    interfaceReports iR = new interfaceReports();
    InterfaceMaintenance iMa = new InterfaceMaintenance();
    interfaceCC iCC = new interfaceCC();
    public VBox getVBox(){
        
        VBox vB_Main = new VBox();
        vB_Main.setStyle("-fx-background-image: url(planet.gif);"
                +"-fx-background-position: left, center;" 
                +"-fx-background-repeat: no-repeat;"
                +"-fx-background-size: stretch, cover, auto;");
                
        VBox vB_Windows = new VBox();
            //Barra de menu
       MenuBar mB_Menu = new MenuBar(); 
       
             //Menu sistema
       Menu m_System = new Menu("Sistema");
     
         

       MenuItem mI_Credits = new MenuItem("Créditos");
       mI_Credits.setOnAction((event)->{
            
         vB_Windows.getChildren().clear();
         vB_Windows.getChildren().addAll(iA.getInterfaceCredits());
       });
       MenuItem mI_Exit = new MenuItem("Salir");
       mI_Exit.setOnAction((event)->Platform.exit());
       
       m_System.getItems().addAll( mI_Credits, mI_Exit);


       Menu m_Countries = new Menu("Insertar...");
       MenuItem mI_InsertCountry = new MenuItem("Agregar productos", new ImageView(new Image("Insert.png")));
       mI_InsertCountry.setOnAction((event)->{
          vB_Windows.getChildren().clear();
                vB_Main.setStyle("-fx-background-image: url(Countries.jpg);"
                +"-fx-background-position: left, center;" 
                +"-fx-background-repeat: no-repeat;"
                +"-fx-background-size: stretch, auto;");

          vB_Windows.getChildren().addAll(iC.setInterfaceCatalogs());
             });

        Menu m_Maintenance = new Menu("Mantenimiento");
        MenuItem mI_Clean = new MenuItem("Vaciar Aplicación", new ImageView(new Image("Maintenance.png")));
        mI_Clean.setOnAction((event)->{
            //Crea un JavaFX de tipo alert para confirmar si el usuario desea vaciar los archivos
            vB_Windows.getChildren().clear();
            iMa.cleanText();
        });

        m_Maintenance.getItems().addAll(mI_Clean);

        Menu m_catalogCreator = new Menu("Creacion de catalogos");
        MenuItem mI_CC = new MenuItem("Crear Catalogo", new ImageView(new Image("Insert.png")));
        mI_CC.setOnAction((event)->{

            vB_Windows.getChildren().clear();
            iCC.catalogCreator();
        });

        m_catalogCreator.getItems().addAll(mI_CC);



        MenuItem mI_ModifyCountry = new MenuItem("Modificar",  new ImageView(new Image("Modify.png")));
        mI_ModifyCountry.setOnAction((event)->{
             vB_Windows.getChildren().clear();
             vB_Main.setStyle("-fx-background-image: url(Modification.jpg);"
                +"-fx-background-position: left, center;" 
                +"-fx-background-repeat: no-repeat;"
                +"-fx-background-size: stretch, auto;");
             vB_Windows.getChildren().addAll(iC.setInterfaceModify());
         });

       m_Countries.getItems().addAll(mI_InsertCountry,mI_ModifyCountry);

      Menu m_ReportCountries = new Menu("Catalogos");
      Menu m_report = new Menu("Lista de catalogos", new ImageView(new Image("List.png")));
      m_ReportCountries.getItems().addAll(m_report);
      
      MenuItem mI_ReportCountry = new MenuItem("Ver catalogos");
      mI_ReportCountry.setOnAction((event)->{
           vB_Main.setStyle("-fx-background-image: url(Listing.jpg);"
                +"-fx-background-position: left, center;" 
                +"-fx-background-repeat: no-repeat;"
                +"-fx-background-size: stretch, auto;");

          vB_Windows.getChildren().clear();
          vB_Windows.getChildren().addAll(iR.getInterfaceReports());
      });


      m_report.getItems().addAll(mI_ReportCountry);

        
       mB_Menu.getMenus().addAll(m_System, m_catalogCreator, m_Countries, m_ReportCountries, m_Maintenance);
       
       vB_Main.getChildren().addAll(mB_Menu, vB_Windows);


        return vB_Main;
    }//End getVBox()
}
