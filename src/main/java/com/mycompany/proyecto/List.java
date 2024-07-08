
package com.mycompany.proyecto;
/**
 *
 * @author Abdelrahman, Eric, Daniel, Eduardo
 */
public class List {
    Node inicial;
    Node end;
    
    public List(){
        this.inicial = this.end = null;
    }
    
    public void add(Node item){
        if(inicial == null)
            this.inicial = this.end = item;
        else{
            end.next = item;
            end = end.next;
            end.next = null;    
        }
    }
    
    public void showList(){
        Node run = this.inicial;
        while(run != null){
            run.user.print();
            System.out.println(" |\n |\n v");
            run = run.next;
        }
    }
    
    public User search(String id){
        Node temp = this.inicial;
        while(temp != null){
            if((temp.user.getId()).equals(id))
                return temp.user;
            else
                temp = temp.next;
        }
        return null;
    }
}
