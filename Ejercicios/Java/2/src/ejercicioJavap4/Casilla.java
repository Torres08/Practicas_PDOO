/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioJavap4;

/**
 *
 * @author lazaro
 */
public class Casilla {
    private final String nombre;
    
    public Casilla (String _nombre){
        this.nombre = _nombre;
    }
    
    // metodo RecibeJugador
    // int iactual, ArrayList<Jugador>
    boolean RecibeJugador(){
        System.out.println("\nHa recibido un jugador | " + getNombre());
        return true;
    }
    
    protected String getNombre(){
        return nombre;
    }
}
