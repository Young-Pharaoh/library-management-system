
package com.mycompany.proyecto;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Abdelrahman, Eric, Daniel, Eduardo
 */

public class Proyecto {
    public static void main(String[] args) {
        ABB books = new ABB();
        List Users = new List();
        ArrayList<Book> mostrarBooks = new ArrayList<>();
        String dueDate = "7";
        
        User usr ;
        String idSearch = "";
        while(true){
            String[] options = {"Agregar Libro", "Agregar Usuario", "Buscar Libro disponible", "Buscar Usuario", "alquilar Libro", "Imprimir Libros"};
            int choice = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            try{
                switch(choice){
            case 0:
                String title = JOptionPane.showInputDialog("Ingrese el nombre del libro: ");
                String author = JOptionPane.showInputDialog("Ingrese el nombre del autor: ");
                String isbn = JOptionPane.showInputDialog("Ingrese el ISBN del libro: ");
                Integer.parseInt(isbn);
                books.add(new NodeABB(new Book(title, author, isbn)));
                mostrarBooks.add(new Book(title, author, isbn));
                break;
            case 1:
                String name = JOptionPane.showInputDialog("Ingrese el nombre del Usuario: ");
                String id = JOptionPane.showInputDialog("Ingrese el id del Usuario: ");
                Integer.parseInt(id);
                Users.add(new Node(new User(name,id)));
                break;
            case 2:
                String isbnSearch = JOptionPane.showInputDialog("Ingrese el ISBN del libro: ");
                Integer.parseInt(isbnSearch);
                if(!books.search(isbnSearch))
                    JOptionPane.showMessageDialog(null, "este libro esta disponible");
                else
                    JOptionPane.showMessageDialog(null, "este libro no esta disponible");
                break;
            case 3:
                idSearch = JOptionPane.showInputDialog("Ingrese el ID del Usuario: ");
                Integer.parseInt(idSearch);
                usr = Users.search(idSearch);
                if(usr != null)
                    usr.print();
                else
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                break;
            case 4:
                isbnSearch = JOptionPane.showInputDialog("Ingrese el ISBN del libro que quieres alquilar: ");
                Integer.parseInt(isbnSearch);
                Book book = books.searchToUse(isbnSearch);
                if(book != null){
                    if(!book.isTaken()){
                        idSearch = JOptionPane.showInputDialog("Ingrese el ID del Usuario que quiere alquilar: ");
                        Integer.parseInt(idSearch
                        );
                        usr = Users.search(idSearch);
                           if(usr != null){
                               usr.addBook(book);
                               usr.setDueDates(dueDate, book.getIsbn());
                               book.setTaken(true);
                           }
                           else
                               JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "este libro no esta disponible");
                }
                else
                    JOptionPane.showMessageDialog(null, "este libro no esta disponible");
                break;
            case 5:
                StringBuilder nombresLibros = new StringBuilder();
                for(int i = 0; i < mostrarBooks.size(); i++)
                    nombresLibros.append((mostrarBooks.get(i).getTitle()) + "\n");
                JOptionPane.showMessageDialog(null, nombresLibros.toString());
                break;
            default:
                break;  
            } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "En los campos de ID de usuario y ISBN de libro solo se puede ingresar numeros");

            }
        }
    }
}
