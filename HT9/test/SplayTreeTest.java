/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ht9.Association;
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
public class SplayTreeTest 
{
    /** Class SplayTreeTest **/

    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /** Creating object of SplayTree **/
        SplayTree spt = new SplayTree(); 
        System.out.println("Splay Tree Test\n");          
        char ch;
        String key;
        String value;
        /**  Perform tree operations  **/
        do    
        {
            System.out.println("\nSplay Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove ");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty");
            System.out.println("6. clear tree");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                key=scan.next();
                value=scan.next();
                Association<String,String> a=new Association<String, String>(key,value);
                
                spt.insert(a);  //CORRE BIEN                   
                break;
            case 2 : 
                System.out.println("Enter integer element to remove");
                key=scan.next();
                value=scan.next();
                Association<String,String> b=new Association<String, String>(key,value);
                
                spt.remove(b);  //NO SE USA                   
                break;                          
            case 3 : 
                System.out.println("Enter integer element to search");
                
                key=scan.next();
               
                
                System.out.println("Search result : "+ spt.search(key));//CORRE BIEN
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ spt.countNodes());
                break;     
            case 5 : 
                System.out.println("Empty status = "+ spt.isEmpty());
                break;     
            case 6 : 
                System.out.println("\nTree Cleared");
                spt.clear();
                break;        
            default : 
                System.out.println("Wrong Entry \n ");
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
    
    

