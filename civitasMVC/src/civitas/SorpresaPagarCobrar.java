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
public class SorpresaPagarCobrar extends Sorpresa {
    
    // no necesito mas variables a parte de las originales
    
    public SorpresaPagarCobrar(String texto, int valor){
        super(texto, valor);
    }
    
    @Override
    void informe(int actual, ArrayList<Jugador> todos) {
       String evento = "El jugador " + todos.get(actual).getNombre() +
                " se le ha aplicado una Sorpresa de PAGARCOBRAR: " + toString();
        Diario.getInstance().ocurreEvento(evento);
    }

    @Override
    void aplicaraJugador(int actual, ArrayList<Jugador> todos) {
         informe(actual, todos);
        todos.get(actual).modificarSaldo(this.getValor());
    }
}
