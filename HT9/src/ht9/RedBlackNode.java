/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

/**
 *
 * @author ledod
 */
public class RedBlackNode<E> {
    RedBlackNode<E> parent,left,right;
    Association<String, String> element;
    boolean isBlack;
    
    /** Constructor **/
     public RedBlackNode()
     {
         isBlack=false;
         parent=null;
         left=null;
         right=null;
         element=null;
     }          
     /** Constructor **/
     public RedBlackNode(Association<String, String> ele)
     {
         isBlack=false;
         parent=null;
         left=null;
         right=null;
         element=ele;
     } 
     /** Constructor **/
     public RedBlackNode(Association<String, String> ele, RedBlackNode left, RedBlackNode right, RedBlackNode parent)
     {
         isBlack=false;
         this.left = left;
         this.right = right;
         this.parent = parent;
         this.element = ele;         
     }      
     
     public String getKey()
    {
        return element.key;
    } 
    
    public String getValue()
    {
        return element.value;
    }
    
}
