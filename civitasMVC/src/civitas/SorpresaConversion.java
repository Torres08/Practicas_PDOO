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
public class SorpresaConversion extends Sorpresa {

    public SorpresaConversion(String texto) {
        super(texto, 0);
    }

    @Override
    void informe(int actual, ArrayList<Jugador> todos) {
        String evento = "¡El jugador " + todos.get(actual).getNombre()
                + " se le ha convertido en Especulador! " + toString();
        Diario.getInstance().ocurreEvento(evento);
    }

    @Override
    void aplicaraJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        JugadorEspeculador especulador = todos.get(actual).convertir();
        todos.set(actual, especulador);
    }

}
