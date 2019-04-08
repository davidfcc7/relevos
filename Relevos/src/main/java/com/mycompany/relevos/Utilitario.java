/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 *
 * @author David
 */
public class Utilitario {
    
    public static int random(){
        /*(int) ((Math.random()* n) + 1)
        n es el valor hasta donde va a llegar y +1 es para que el valor no sea 0*/
        int valor = (int) ((Math.random()* 3) + 1);
        return valor;}
}
