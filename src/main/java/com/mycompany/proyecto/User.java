
package com.mycompany.proyecto;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Abdelrahman, Eric, Daniel, Eduardo
 */
public class User {
    private String name;
    private String id;
    private ArrayList<String> borrowedBooks;
    private String[][] dueDates = {
        {"", ""},
        {"", ""},
        {"", ""}
    };
    private int numeroLibros = 0;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
        this.dueDates = new String[3][2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(Book book) {
        this.borrowedBooks.add(book.getIsbn());
    }
    
    public void returnBook(Book book){
        this.borrowedBooks.remove(book);
    }

    public String[][] getDueDates() {
        return dueDates;
    }

    public void setDueDates(String dueDates, String bookID) {
        if(this.numeroLibros < 3){
            this.dueDates[this.numeroLibros][0] = bookID;
            this.dueDates[this.numeroLibros][1] = dueDates;
            this.numeroLibros++;
        }
        else
            JOptionPane.showMessageDialog(null, "El usuario ya tiene 3 libros alquilados");
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book.getIsbn());
    }
    
    public void print(){
        String s = "Nombre de usuario: " + this.name + "\nid: " + this.id
        + "\nLibros prestados: " + Arrays.toString(this.borrowedBooks.toArray())
        + "\nFechas de entrega: " + printDueDates();
        JOptionPane.showMessageDialog(null, s);
    }
    public String printDueDates(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 2; j++)
                str.append("[" + i + "][" + j + "] = " + this.dueDates[i][j] + "\n");
        return str.toString();
    }
}