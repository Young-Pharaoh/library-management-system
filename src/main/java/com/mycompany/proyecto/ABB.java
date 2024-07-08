
package com.mycompany.proyecto;
/**
 *
 * @author Abdelrahman, Eric, Daniel, Eduardo
 */
class NodeABB{
    Book book;
    NodeABB right, left;
    
    public NodeABB(Book book){
        this.book = book;
        this.right = this.left = null;
    }
}



public class ABB {
     NodeABB root;

    public ABB(){
        this.root = null;
    }
    
    public void add(NodeABB node){
        if (root == null)
            root = node;
        else{
            if(Integer.parseInt(node.book.getIsbn()) > Integer.parseInt(root.book.getIsbn()))
                root.right = node;
            else
                root.left = node;
        }
    }
    
    public boolean search(String entry){
        NodeABB run = this.root;
        while(run != null){
            if(Integer.parseInt(entry) > Integer.parseInt(run.book.getIsbn()))
                run = run.right;
            else if (Integer.parseInt(entry) < Integer.parseInt(run.book.getIsbn()))
                run = run.left;
            else
                return run.book.isTaken();
        }
        return true;
    }  
    public Book searchToUse(String entry){
        NodeABB run = this.root;
        while(run != null){
            if(Integer.parseInt(entry) > Integer.parseInt(run.book.getIsbn()))
                run = run.right;
            else if (Integer.parseInt(entry) < Integer.parseInt(run.book.getIsbn()))
                run = run.left;
            else
                return run.book;
        }
        return null;
    }
}