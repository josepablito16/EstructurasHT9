/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ht9.Association;
import ht9.RedBlackTree;
import ht9.SplayTree;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class RBTtest 
{
    @Test
  public void IngresarYBuscar() {
      RedBlackTree spt = new RedBlackTree();                     
      spt.put("a","a");
      
      boolean respuesta;
      
      if(spt.get("a")!=null)
                {
                    respuesta=true;
                }
                else
                {
                    respuesta=false;
                }
    
    
    assertEquals(true, respuesta);
  }
    
    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /** Creating object of SplayTree **/
        SplayTree spt = new SplayTree(); 
        System.out.println("RBT Test\n");          
        char ch;
        String key;
        String value;
        /**  Perform tree operations  **/
        do    
        {
            System.out.println("\n RBT Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search ");
            
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter  element to insert");
                key=scan.next();
                value=scan.next();                
                spt.insert((new Association(key,value)));  //CORRE BIEN                   
                break;
            case 2 : 
                System.out.println("Enter the element to search");
                key=scan.next();
                if(spt.translate(key)!=null)
                {
                    System.out.println("True");
                }
                else
                {
                    System.out.println("False");
                }
                                
                break;                          
            
            }
            /**  Display tree  **/
            System.out.print("\nPost order : ");
            spt.postorder();
            System.out.print("\nPre order : ");
            spt.preorder();
            System.out.print("\nIn order : ");
            spt.inorder(); 
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}
