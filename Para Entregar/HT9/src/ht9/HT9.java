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
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class HT9 
{

    /**
     * @param args the command line arguments
     */
     private static Scanner teclado;
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        SplayTree bt = new SplayTree();
        RedBlackTree bt2=new RedBlackTree();
        String linea, ingles,espanol;
        //File archivo = new File ("./freedict-eng-spa.txt");//PARA LA ENTREGA FINAL
        File archivo = new File ("C:\\Users\\jose\\Desktop\\DISEÑO\\TRABAJOS\\UVG\\3er Semestre\\Estructura de Datos\\HT9\\EstructurasHT9\\freedict-eng-spa.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        teclado = new Scanner(System.in);
        
        System.out.println("Ingrese Con que implementacion desea realizar la traduccion");
        System.out.println("1. Splay Tree");
        System.out.println("2. RBT");
        String tipo=teclado.nextLine();
        
        
        
        
        
        
        
        
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
            if(tipo.equalsIgnoreCase("1"))
            {
                bt.insert(new Association(ingles,espanol));

            }
            else
            {
                bt2.put(ingles,espanol);


            }
            
            
            
                    
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
            if(tipo.equals("1"))
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
            else
            {
                boolean var;
                if(bt2.get(separado[i].toLowerCase())!=null)
                {
                    var=true;
                }
                else
                {
                    var=false;
                }
                
                 if (var)
                {
                    separado[i]=(String) bt2.get(separado[i].toLowerCase());
                }
                else
                {
                    separado[i]="*"+separado[i]+"*";
                }
                
                


            }
            
            
            
            
            
            
            
            
            
            
        }
        
         for (int i=0; i<separado.length;i++){
            System.out.print(separado[i]+" ");
        }
                
                
        
        
        
        
    }
    
}
