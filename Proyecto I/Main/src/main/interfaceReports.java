
package main;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class interfaceReports {
    TableView<CatalogGS> currentTv = new TableView<>();
    logicCatalogs lC = new logicCatalogs();
    private String UrlCatalog = "catalogo.txt";
    public VBox getInterfaceReports(){
        VBox vB_interfaceReports = new VBox();

        ComboBox<String> cB_CatalogList = new ComboBox<>();
        //Crea un combobox, tiene la lista de productos
        cB_CatalogList.setValue("Seleccione el catalogo:");
        for (int i = 0; i < lC.readRegistersFile(UrlCatalog).length; i++) {
            cB_CatalogList.getItems().add(lC.readRegistersFile(UrlCatalog)[i].getNameCountry());
        }
        cB_CatalogList.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue)->{


            TableView<CatalogGS> tV_Countries = new TableView<>();



            //Crear la columna país
            TableColumn tC_NameCountry = new TableColumn("Nombre");
            tC_NameCountry.setCellValueFactory(new PropertyValueFactory("nameCountry"));




            //Crear la columna descripcion
            TableColumn tC_Description = new TableColumn("Descripción");
            tC_Description.setCellValueFactory(new PropertyValueFactory("description"));

            tV_Countries.setItems(getListCatalogs(newValue));
            tV_Countries.getColumns().addAll(tC_NameCountry, tC_Description);
            vB_interfaceReports.getChildren().remove(currentTv);
            vB_interfaceReports.getChildren().addAll(tV_Countries);
            currentTv = tV_Countries;
        });


        Label lB_Report = new Label("Información");
        lB_Report.setFont(new Font("Impact", 25));
        lB_Report.setTextFill(Color.web("#e0e5d6"));
         vB_interfaceReports.setAlignment(Pos.TOP_CENTER);

         vB_interfaceReports.getChildren().addAll(lB_Report,cB_CatalogList);
        return vB_interfaceReports;
        
    }

    public ObservableList<CatalogGS> getListCatalogs(String archivo){

        ArrayList array = new ArrayList();
        CatalogGS tempCountries[] = lC.readRegistersFile(archivo);

        for (int i = 0; i <tempCountries.length; i++) {
            array.add(tempCountries[i]);

        }
        ObservableList<CatalogGS> oL_dataCountries = FXCollections.observableArrayList(array);
        return oL_dataCountries;
    }
}
