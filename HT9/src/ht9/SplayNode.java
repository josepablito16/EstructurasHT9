/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

/**
 *
 * @author jose
 */
public class SplayNode<E> 
{
    SplayNode<E> left, right, parent;
    Association<String, String> element;
    
 
     /** Constructor **/
     public SplayNode()
     {
         this(null,null, null, null);
     }          
     /** Constructor **/
     public SplayNode(Association<String, String> ele)
     {
         this(ele, null, null, null);
     } 
     /** Constructor **/
     public SplayNode(Association<String, String> ele, SplayNode left, SplayNode right, SplayNode parent)
     {
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
