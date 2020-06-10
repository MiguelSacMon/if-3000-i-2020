
package main;


public class CatalogGS {

    private String nameCountry;
    private String description;



    public CatalogGS(String nameCountry, String description) {
        this.nameCountry = nameCountry;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    }


