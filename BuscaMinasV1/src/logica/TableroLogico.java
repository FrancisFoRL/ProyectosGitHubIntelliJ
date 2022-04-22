/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author monto
 */
public class TableroLogico {
    
    private int dim;  //no hace falta poner filas y columnas ya que si establezco dimensión 4= 4x4
    private int numMinas;
    private int numCasillasAbiertas; //este atributo me permitirá saber cuando he ganado 
    private Casilla [][] tableroJuego; //este array bidimensional de Casilla será mi tablero
    private ArrayList<Casilla> listaMinas; //cada vez que una casilla tenga mina la meteré en mi ArrayList (por tanto contendrá todas las casillas que tienen mina)
    private boolean juegoGanado; //true o false si gana o pierde el juego
    
    
    public TableroLogico(int dim, int numMinas){
       
        this.dim=dim;
        this.numMinas=numMinas; 
        tableroJuego= new Casilla [dim][dim];
        listaMinas= new ArrayList<Casilla>(); //inicializo mi ArrayList también
        iniciarTablero();
        
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------
    public void iniciarTablero(){
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                int [] p={i, j}; //en la primera vuelta p valdrá 0,0 (primer nº de filas y segundo columas)
                tableroJuego[i][j]= new Casilla(p);//a cada posición correspondiente le daré si propio número como valor (ej: fila=1 columna=2
                //tentrá valor 1,2 y así sabré en que casilla estoy pinchando)
                
            }
        }
        colocaMinas();
        colocaPistas();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------
    private void colocaMinas(){
        Random r= new Random();
        int f, c, cont=0;
        do{
            f=r.nextInt(dim); //así genero un aleatorio entre 0 y uno menos que la dimensión
            c=r.nextInt(dim);
            if(!tableroJuego[f][c].isMina()){ //si no tiene mina lo cuento y le asigno mina
                cont++;
                tableroJuego[f][c].setMina(true);
                //como esta posición ya tiene minas la introduciré dentro de listaMinas
                listaMinas.add(tableroJuego[f][c]);
            }
        }while(cont<numMinas);
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
    private void colocaPistas(){     //recorro el tablero y cuando encuentre una mina alrededor de ella le sumaré 1 al nº de minas (comprobando que no sea mina, ya que si no no le podré sumar 1)
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                if (tableroJuego[i][j].isMina()){
                    calcular(i,j);
                }
                
            }
        }       
    }
    //------------------------------------------------------------------------------------------------------------------------------------
    public void calcular (int f, int c){ //calcular asignará 1 + a las que no tengan mina de alrededor de las que tienen(ya que solo le pasamos las que tienen mina)
        for(int i=Math.max(0,f-1); i<=Math.min(f+1, dim-1); i++){
            for(int j=Math.max(0,c-1); j<=Math.min(dim-1, c+1); j++){
                if(!tableroJuego[i][j].isMina()){
                    int v= tableroJuego[i][j].getMinasCerca();
                    tableroJuego[i][j].setMinasCerca(++v);
                }
            }
        }
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
    public void pintarTablero(){
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
               if(tableroJuego[i][j].isMina()){
                   System.out.print("*\t");
               }else{
                   System.out.print(tableroJuego[i][j].getMinasCerca()+"\t");
               } 
            }
            System.out.println("");
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------
    
    
    
}
