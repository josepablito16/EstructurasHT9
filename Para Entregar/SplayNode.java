/**
 *
 * @author Jose Cifuentes
 * @author Luis Delgado
 * @version 20.4.18
 * Clase SplayNode
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
