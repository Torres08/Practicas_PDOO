/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author lazaro
 */
/**
 * @brief Esta clase representa las casillas del juego. recibir a los jugadores
 * y aplicarles a estos segun la situacion del juego cuando cae en la casilla.
 * Segun la casilla se le aplican unas propiedades o otras
 */
public class Casilla {

    
    private final String Nombre; // nombre de la casilla, si el tipo es calle, se llama calle
  
    public Casilla(String unNombre) { // DESCANSO
        this.Nombre = unNombre;

    }

    
    void RecibeJugador(int iactual, ArrayList<Jugador> todos) {
        informe(iactual, todos);

    }

    public String getNombre(){return Nombre;}
     
    public String ToString() {  
        return Nombre;
    }

    protected void informe(int actual, ArrayList<Jugador> todos) {
        // uso to string, dar info de la casilla
        // Informa al diario acerca del jugador que ha caido en la casilla
        Diario.getInstance().ocurreEvento("Ha caido en la casilla " + ToString() + " el jugador " + todos.get(actual).getNombre()); // cojo su nombre

    }

}
