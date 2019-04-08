/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

import java.util.Date;

/**
 *
 * @author David
 */
public class Equipo {
    
    private String nombreEquipo;
    private Date finalizo;
    private int posicion;
    private int posicionCorredorUno;
    private int posicionCorredorDos;
    private int posicionCorredorTres;
    
    public Equipo ( String nombreEquipo ){
        
        this.nombreEquipo = nombreEquipo;
        this.posicionCorredorUno = 0;
        this.posicionCorredorDos = 33;
        this.posicionCorredorTres = 66;
        finalizo = null;}
    
    public synchronized String mostrarPosicion(){
        String posicion ="";
        posicion = "equipo:  "+nombreEquipo;
        
        for(int i = 0; i<= 100; i++){
            if(i == posicionCorredorUno){
                posicion = "(°)";}
            else if (i == posicionCorredorDos){
                posicion = "(!)";}
            else if (i == posicionCorredorTres){
                posicion = "(#)";}
            else{
                posicion = "_";}
        }
    return posicion;}

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo
     
     */
    public void setNombre(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the finalizo
     */
    public Date getFinalizo() {
        return finalizo;
    }

    /**
     * @param finalizo the finalizo to set
     */
    public void setFinalizo(Date finalizo) {
        this.finalizo = finalizo;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
        
    }

    /**
     * @return the posicionCorredorUno
     */
    public int getPosicionCorredorUno() {
        return posicionCorredorUno;
    }

    /**
     * @param posicionCorredorUno the posicionCorredorUno to set
     */
    public void setPosicionCorredorUno(int posicionCorredorUno) {
        this.posicionCorredorUno = posicionCorredorUno;
    }

    /**
     * @return the posicionCorredorDos
     */
    public int getPosicionCorredorDos() {
        return posicionCorredorDos;
    }

    /**
     * @param posicionCorredorDos the posicionCorredorDos to set
     */
    public void setPosicionCorredorDos(int posicionCorredorDos) {
        this.posicionCorredorDos = posicionCorredorDos;
    }

    /**
     * @return the posicionCorredorTres
     */
    public int getPosicionCorredorTres() {
        return posicionCorredorTres;
    }

    /**
     * @param posicionCorredorTres the posicionCorredorTres to set
     */
    public void setPosicionCorredorTres(int posicionCorredorTres) {
        this.posicionCorredorTres = posicionCorredorTres;
    }
}
