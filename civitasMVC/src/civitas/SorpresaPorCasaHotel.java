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
public class SorpresaPorCasaHotel extends Sorpresa{
    
    
    public SorpresaPorCasaHotel(String texto, int valor){
        super(texto,valor);
    } 

    @Override
    void informe(int actual, ArrayList<Jugador> todos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void aplicaraJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        int coste = this.getValor() * todos.get(actual).cantidadCasasHoteles();
        todos.get(actual).modificarSaldo(coste);
    }
    
}
