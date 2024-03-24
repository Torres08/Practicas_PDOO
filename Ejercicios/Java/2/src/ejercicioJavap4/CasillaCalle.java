/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioJavap4;

/**
 *
 * @author lazaro
 */
public class CasillaCalle extends Casilla{
   
    private int numCasas;
    
    public CasillaCalle(String nombre, int numero){
        super(nombre);
        this.numCasas = numero;
    }
    
    public int ConstruirCasa(){
        return numCasas++;
    }
    
    @Override
    boolean RecibeJugador(){
       
       if (super.RecibeJugador() == true){
           System.out.println("\nHa recibido un jugador feo | " + getNombre() + "\n");
            return true;
       } else
            return false;
    }
    
}
