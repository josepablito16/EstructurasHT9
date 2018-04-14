/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

import java.util.Scanner;

/**
 *
 * @author jose
 */
public class SplayTree<E> 
{
    
    private SplayNode root;
    private int count = 0;
 
     /** Constructor **/
     public SplayTree()
     {
         root = null;
     }
 
     /** Function to check if tree is empty **/
     public boolean isEmpty()
     {
         return root == null;
     }
 
     /** clear tree **/
     public void clear()
     {
         root = null;
     }
 
     /** function to insert element */
     public void insert(Association<String, String> ele)
     {
         SplayNode z = root;
         SplayNode p = null;
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
         z = new SplayNode();
         z.element = ele;
         z.parent = p;
         
         if(p == null)
         {
             root = z;
         }else if((ele.getKey()).compareTo(p.getKey())>0)
         {
             p.left = z;
         }
         else{p.right = z;}
         
         Splay(z);
         count++;
     }
     /** rotate **/
     public void makeLeftChildParent(SplayNode c, SplayNode p)
     {
         if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
 
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else 
                 p.parent.right = c;
         }
         if (c.right != null)
             c.right.parent = p;
 
         c.parent = p.parent;
         p.parent = c;
         p.left = c.right;
         c.right = p;
     }
 
     /** rotate **/
     public void makeRightChildParent(SplayNode c, SplayNode p)
     {
         if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
             throw new RuntimeException("WRONG");
         if (p.parent != null)
         {
             if (p == p.parent.left)
                 p.parent.left = c;
             else
                 p.parent.right = c;
         }
         if (c.left != null)
             c.left.parent = p;
         c.parent = p.parent;
         p.parent = c;
         p.right = c.left;
         c.left = p;
     }
 
     /** function splay **/
     private void Splay(SplayNode x)
     {
         while (x.parent != null)
         {
             SplayNode Parent = x.parent;
             SplayNode GrandParent = Parent.parent;
             if (GrandParent == null)
             {
                 if (x == Parent.left)
                     makeLeftChildParent(x, Parent);
                 else
                     makeRightChildParent(x, Parent);                 
             } 
             else
             {
                 if (x == Parent.left)
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeLeftChildParent(Parent, GrandParent);
                         makeLeftChildParent(x, Parent);
                     }
                     else 
                     {
                         makeLeftChildParent(x, x.parent);
                         makeRightChildParent(x, x.parent);
                     }
                 }
                 else 
                 {
                     if (Parent == GrandParent.left)
                     {
                         makeRightChildParent(x, x.parent);
                         makeLeftChildParent(x, x.parent);
                     } 
                     else 
                     {
                         makeRightChildParent(Parent, GrandParent);
                         makeRightChildParent(x, Parent);
                     }
                 }
             }
         }
         root = x;
     }
 
     /** function to remove element **/
     public void remove(Association<String, String> ele)
     {
         SplayNode node = findNode(ele);
        remove(node);
     }
 
     /** function to remove node **/
     private void remove(SplayNode node)
     {
         if (node == null)
             return;
 
         Splay(node);
         if( (node.left != null) && (node.right !=null))
         { 
             SplayNode min = node.left;
             while(min.right!=null)
                 min = min.right;
 
             min.right = node.right;
             node.right.parent = min;
             node.left.parent = null;
             root = node.left;
         }
         else if (node.right != null)
         {
             node.right.parent = null;
             root = node.right;
         } 
         else if( node.left !=null)
         {
             node.left.parent = null;
             root = node.left;
         }
         else
         {
             root = null;
         }
         node.parent = null;
         node.left = null;
         node.right = null;
         node = null;
         count--;
     }
 
     /** Functions to count number of nodes **/
     public int countNodes()
     {
         return count;
     }
 
     /** Functions to search for an element **/
     public boolean search(String val)
     {
         Association<String,String> b=new Association<String, String>(val,"");
         return findNode(b) != null;
     }
     private SplayNode findNode(Association<String, String> ele)
     {
         SplayNode z = root;
         while (z != null)
         {
             if((ele.getKey()).compareTo(z.getKey())>0)
             {
                 z = z.left;
             }
             else if((ele.getKey()).compareTo(z.getKey())<0)
             {
                 z = z.right;
             }
             else
                 return z;
         }
         return null;
     }
     
     
     public String translate(String s){
       SplayNode n=translateRecursive(root,s);
       if (n==null){
           return null;
       }else{
           return n.getValue();
       }
   }

   
   public SplayNode translateRecursive(SplayNode current, String s){
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
     private void inorder(SplayNode r)
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
     private void preorder(SplayNode r)
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
     private void postorder(SplayNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.element.key +" ");
         }
     }     
 }
 
 
