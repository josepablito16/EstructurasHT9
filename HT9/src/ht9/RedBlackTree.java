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
public class RedBlackTree<E> 
{
    RedBlackNode root;
    
    public RedBlackTree(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
    /** clear tree **/
    public void clear()
    {
        root = null;
    }
    
    public void insert(Association<String,String>ele)
    {
        RedBlackNode z=root;
        RedBlackNode p=z;
        while (z != null)
        {
            p = z;
            if((ele.getKey()).compareTo(p.getKey())>0)
            {
                z = z.left;
            }
            else
            {
                z = z.right;
            }   
        }
        z=new RedBlackNode();
        z.element=ele;
        z.parent=p;
        if (p==null){
            root=z;
        }else if(z.getKey().compareTo(p.getKey())<0){
            p.left=z;
        }else{
            p.right=z;
        }
        z.left=null;
        z.right=null;
        z.isBlack=false;
        
        insertFixup(z);
    }
    
    public void insertFixup(RedBlackNode z){
        while (!z.parent.isBlack){
            if (z.parent==z.parent.parent.left){
                RedBlackNode y=z.parent.parent.right;
                if (!y.isBlack){
                    z.parent.isBlack=true;
                    z.parent.parent.isBlack=false;
                    z.parent.parent.left.isBlack=true;
                    z=z.parent.parent;
                } else if(z==z.parent.right){
                    z=z.parent;
                    leftRotate(z);
                }
                z.parent.isBlack=true;
                z.parent.parent.isBlack=false;
                rightRotate(z.parent.parent);
            }else{
                RedBlackNode y=z.parent.parent.left;
                if (!y.isBlack){
                    z.parent.isBlack=true;
                    z.parent.parent.isBlack=false;
                    z.parent.parent.right.isBlack=true;
                    z=z.parent.parent;
                } else if(z==z.parent.left){
                    z=z.parent;
                    rightRotate(z);
                }
                z.parent.isBlack=true;
                z.parent.parent.isBlack=false;
                leftRotate(z.parent.parent);
            }
        }
        root.isBlack=true;
    }
    public void leftRotate(RedBlackNode z){
        z.left=z;
        z.left.right=z.right.left;
        z.right.left=z;
        z=z.right;
    }
    public void rightRotate(RedBlackNode z){
        z.right=z;
        z.right.left=z.right.right;
        z.left.right=z;
        z=z.left;
    }
    public String translate(String s){
       RedBlackNode n=translateRecursive(root,s);
       if (n==null){
           return null;
       }else{
           return n.getValue();
       }
    }
    public RedBlackNode translateRecursive(RedBlackNode current,String s){
        if (current == null) 
        {
            return null;
        }
       if (s.compareTo(current.getKey())>0) {
            return translateRecursive(current.left, s);
        } else if (s.compareTo(current.getKey())<0) {
            return translateRecursive(current.right, s);
        } else {
            // value already exists
            return current;
        }
    }
    /** Function for inorder traversal **/ 
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(RedBlackNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.element.key +" ");
             inorder(r.right);
         }
     }
 
     /** Function for preorder traversal **/
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(RedBlackNode r)
     {
         if (r != null)
         {
             System.out.print(r.element.key +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
 
     /** Function for postorder traversal **/
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(RedBlackNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.element.key +" ");
         }
     } 
}
