/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jose
 */
public class HT9 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        String linea, ingles,espanol;
        //File archivo = new File ("./freedict-eng-spa.txt");//PARA LA ENTREGA FINAL
        File archivo = new File ("C:\\Users\\jose\\Desktop\\DISEÑO\\TRABAJOS\\UVG\\3er Semestre\\Estructura de Datos\\HT9\\EstructurasHT9\\freedict-eng-spa.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        SplayTree bt = new SplayTree();
        
        
        while( (linea=br.readLine())!=null)
        {
            linea.replace("",";");
            System.out.println(linea);
            //linea.replace(",",";");
            
            //ingles=linea.substring(0,linea.indexOf("\t"));
            //espanol=linea.substring(linea.indexOf("\t")+1,linea.length());
            //bt.insert(new Association(ingles,espanol));
            
                    
            //System.out.println(ingles+espanol);
                    
        }
        
        
        
        
        
    }
    
}
