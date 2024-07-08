/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author abduj
 */

public class Node {
    User user;
    Node next;

    public Node(User user) {
        this.user = user;
        this.next = null;
    }
}
