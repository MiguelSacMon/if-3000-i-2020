
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class logicCatalogs {
    private String UrlCatalog = "catalogo.txt";


    public void insertProduct(CatalogGS c, String Archivo){
        File fileCountries = new File(Archivo);
        
        try{
            FileOutputStream fos = new FileOutputStream(fileCountries, true);
            PrintStream ps = new  PrintStream(fos);
            ps.println(c.getNameCountry()+"|"+c.getDescription());
        }//End Try
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }
        
    }


    public int getFileRegisters(){
    File fileCountries = new File(UrlCatalog);
        int countRegister =0;
    try{
        FileInputStream fis = new FileInputStream(fileCountries);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String actualRegister = br.readLine();
        
        while(actualRegister != null){
            countRegister++;
        actualRegister=br.readLine();
    }


    }
    catch(FileNotFoundException NFE){
    JOptionPane.showMessageDialog(null, "Problemas con el archivo");
    }
    catch(IOException io){
     JOptionPane.showMessageDialog(null, "Problemas con el archivo");
    }
    return countRegister;
    }
    public CatalogGS[] readRegistersFile(String archivo){
        CatalogGS array[] = new CatalogGS[getFileRegisters()];

        File fileCountries = new File(archivo);
        int indexArray = 0;
        try{
            FileInputStream fis = new FileInputStream(fileCountries);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String actualRegister = br.readLine();

            while(actualRegister != null){
                String name = "", description = "";
                if (actualRegister.equals("")){
                    actualRegister = br.readLine();
                    continue;
                }
                int controlTokens = 1;

                StringTokenizer sT = new StringTokenizer(actualRegister, "|");
                while(sT.hasMoreTokens()){
                    if(controlTokens==1)
                        name = sT.nextToken();
                    else if(controlTokens==2)
                        description = sT.nextToken();

                    controlTokens++;
                }//End While
                CatalogGS c = new CatalogGS(name, description);
                array[indexArray] = c;
                indexArray++;

                actualRegister = br.readLine();
            }
        }
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null,"Problemas con el archivo");
        }
        catch(IOException io){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
        return array;
    }

        
    
    public void modifyProducts(String all, String pais){
    
                    File fileCountry = new File(UrlCatalog);
            try {
                
                File file = new File(UrlCatalog);
                
                File temp = File.createTempFile("catalogo", ".txt", file.getParentFile());
                String charset = "UTF-8";
                
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
                
                for (String line; (line = br.readLine()) != null;){
                    
                    if(line.contains(pais))                      
                    line = line.replace(line, all);                
                    else
                        writer.println(line.trim());
                   
                    }
                br.close();
                writer.close();
                file.delete();
                temp.renameTo(file);
                
            }//End Try
            catch (IOException ex) {
               
            }//End catch
    }//End deleteACountry   
    

    
    
}


