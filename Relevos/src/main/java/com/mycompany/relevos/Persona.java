/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David
 */
public class Persona extends Thread {
    Equipo equipo;
    private String nombreCorredor;
    private int inicio;
    private int fin;
    private String equipoUno;
    private String equipoDos;
    private String equipoTres;
    
    public Persona ( String nombreCorredor, int inicio, int fin, Equipo equipo ){
        this.equipo = equipo;
        this.fin = fin;
        this.inicio = inicio;
        this.nombreCorredor = nombreCorredor;
    }
    public void Run (){
        if (inicio == 0){
            personaUno();}
        else{
            esperar();}
        if (inicio == 33){
            personaDos();}
        else{
            esperar();}
        if (inicio == 66){
            personaTres();}
        else{
            esperar();}
    }
    public void personaUno(){
        while (true){
            int posicionActual = avanzar(1);
            if (posicionActual >= 33 ){
                equipo.setPosicionCorredorUno(33);
                synchronized (equipo){
                    equipo.notifyAll();
                    inicio = 33;
                }break;
            }
        }
    }
    public void personaDos(){
        while (true){
            int posicionActual = avanzar(2);
            if ( posicionActual >= 66 ){
                equipo.setPosicionCorredorDos(66);
                synchronized (equipo){
                    equipo.notify();
                    inicio = 66;
                }break;
            }
        }
    }
    public void personaTres(){
        while (true){
            int posicionActual = avanzar(3);
            if ( posicionActual >= 100 ){
                equipo.setPosicionCorredorTres(100);
                if (equipo.getNombre().equals("Amarillo")){
                    equipo.setNombre("AMARILLO");
                }else if(equipo.getNombre().equals("Azul")){
                    equipo.setNombre("AZUL");
                }else if(equipo.getNombre().equals("Rojo")){
                    equipo.setNombre("ROJO");
                }
                System.out.println("EL PRIMER EQUIPO EN LLEGAR ES: "+equipo.getNombre());
                Principal principal = new Principal();
                principal.mostrarMedalla(equipo.getNombre());
                break;
            }
        }
    }
    public void esperar(){
        synchronized (equipo){
            try{
                equipo.wait();
            }catch (InterruptedException ex){
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public int avanzar (int numCorredor){
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avanzando = Utilitario.Random();
        if ( numCorredor == 1 ){
            equipo.setPosicionCorredorUno(equipo.getPosicionCorredorUno()+ avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorUno();
        }
        if ( numCorredor == 2 ){
            equipo.setPosicionCorredorDos(equipo.getPosicionCorredorDos()+avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorDos();
        }
        if ( numCorredor == 3 ){
            equipo.setPosicionCorredorTres(equipo.getPosicionCorredorTres()+avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorTres();
        }
        return 0;
    }

    private void validarEquipo() {
        if (equipo.mostrarPosicion().contains("Amarrillo")){
            String Amarillo = equipo.mostrarPosicion();
            if (Amarillo != null){
                System.out.println(Amarillo);
            }
        }else if (equipo.mostrarPosicion().contains("Azul")){
            String azul = equipo.mostrarPosicion();
            if (azul != null){
                System.out.println(azul);
            }
        }else if (equipo.mostrarPosicion().contains("Rojo")){
            String rojo = equipo.mostrarPosicion();
            if (rojo != null){
                System.out.println(rojo);
            }
        }
        
    }
}
