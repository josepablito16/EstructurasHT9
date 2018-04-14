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
            if(linea.indexOf("\t")!=-1)
            {
                linea=linea.replace("\t","-");
            }
            
            linea=linea.replaceAll(",",";");
            //System.out.println(linea);
            
            if(linea.indexOf(";")!=-1)
            {
                linea=linea.substring(0,linea.indexOf(";"));
            }
            
            ingles=linea.substring(0,linea.indexOf("-")).toLowerCase();
            espanol=linea.substring(linea.indexOf("-")+1,linea.length()).toLowerCase();
            bt.insert(new Association(ingles,espanol));
            
                    
            //System.out.println(ingles+"-"+espanol);
                    
        }
        
        //File archivo2 = new File ("./texto.txt");//PARA ENTREGA FINAL
        File archivo2 = new File ("C:\\Users\\jose\\Desktop\\DISEÑO\\TRABAJOS\\UVG\\3er Semestre\\Estructura de Datos\\HT9\\EstructurasHT9\\texto.txt");
        FileReader fr2 = new FileReader (archivo2);
        BufferedReader br2 = new BufferedReader(fr2);
        
        String ingreso="";
        while( (linea=br2.readLine())!=null)
        {
            ingreso+=linea;
        }
        
        
        String[] separado=ingreso.split(" ");
        
        for (int i=0; i<separado.length;i++)
        {
            if (bt.search(separado[i].toLowerCase()))
            {
                separado[i]=bt.translate(separado[i].toLowerCase());
            }
            else
            {
                separado[i]="*"+separado[i]+"*";
            }
        }
        
         for (int i=0; i<separado.length;i++){
            System.out.print(separado[i]+" ");
        }
                
                
        
        
        
        
    }
    
}
