/**
 *
 * @author Jose Cifuentes
 * @author Luis Delgado
 * @version 20.4.18
 * Clase RedBlackTree
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
