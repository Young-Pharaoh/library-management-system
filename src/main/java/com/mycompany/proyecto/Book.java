
package com.mycompany.proyecto;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdelrahman, Eric, Daniel, Eduardo
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean taken = false;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    public void print(){
        String s = "Title: " + this.title + "Author: " + this.author + "ISBN: " + this.isbn;
        JOptionPane.showMessageDialog(null, s);
    }
}