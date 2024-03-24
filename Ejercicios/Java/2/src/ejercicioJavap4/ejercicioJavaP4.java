/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioJavap4;

import java.util.ArrayList;

/**
 *
 * @author lazaro
 */
public class ejercicioJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Casilla casilla = new Casilla("Casilla");
        CasillaCalle casillacalle = new CasillaCalle("CasillaCalle",0);
        
        System.out.println("Ejemplo Herencia ");
        casilla.RecibeJugador();
        casillacalle.RecibeJugador();
        
        //casilla.construirCasa();
        System.out.println(casillacalle.ConstruirCasa());
        
        // arraylist tablero
        ArrayList<Casilla> tablero = new ArrayList<>();
        tablero.add(casilla);
        tablero.add(casillacalle);
        
        //for (int i = 0; i < tablero.size(); i++)
             // System.out.println(tablero.get(1).construirCasa());
        ((CasillaCalle)tablero.get(1)).ConstruirCasa();
        
        */
        
        /*
            Crea una casiila 1 casilla calle
            casilla2 tipo casilla
        */
        
        CasillaCalle casilla1 = new CasillaCalle ("Casilla1",0);
        Casilla casilla2 = (Casilla)casilla1;
        
        casilla1.RecibeJugador();
        casilla2.RecibeJugador();
        
        System.out.println(casilla1.ConstruirCasa());
       // System.out.println((CasillaCalle)casilla2.ConstruirCasa());
        
        
        
        
        
        
        
        }
    
}
