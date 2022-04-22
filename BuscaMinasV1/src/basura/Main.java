/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basura;
import logica.TableroLogico;

/**
 *
 * @author monto
 */
public class Main {
    
    public static void main(String [] args){
        
        TableroLogico tab= new  TableroLogico(10,20); //me creo un tablero de 10x10 y con 20 minas
        tab.pintarTablero();
                  
        
    }
    
}
