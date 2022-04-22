/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author monto
 */
public class Casilla {
    
    private int [] posicion= new int[2]; //posición es un array de 2 (filas y columnas que me indicará donde se encuentra, es
    //decir, la primera posición valdrá filas y la segunda columnas)
    private  boolean mina, abierta, marcada;
    private int minasCerca;
    
    public Casilla (int [] posicion){
        this.posicion=posicion;
    }
    
    public int getX(){
        return posicion[0];
    }
    
    public int getY(){
        return posicion[1];
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

    public int getMinasCerca() {
        return minasCerca;
    }

    public void setMinasCerca(int minasCerca) {
        this.minasCerca = minasCerca;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    
    
              
              
    
}
