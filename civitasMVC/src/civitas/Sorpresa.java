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
 * @brief Clase ABSTRACTA sorpresa que hace de base para los 3 tipos de sorpresa.
 * Hay 3 tipos de sorpresas hasta la fecha:
 *  -PAGARCOBRAR: paga o cobra una cantidad fija
 *  -PORCASAHOTEL: paga o cobra una cantidad en funcion de sus propiedades
 *  -CONVERTIRME: convierte un jugador en especulador
 */

public abstract class Sorpresa {
    
    /*
    *   @brief  Atributos de instancia, mi objeto es el Sorpresa
    */
    private final String texto;
    private final int valor;
   
    /*
    *   @brief COnstructor
    */
    
    public Sorpresa(String texto, int valor ) {
        this.texto = texto;
        this.valor = valor;
        
    }
    
    // consultores necesarios
    String getTexto() {
        return texto;
    }

    int getValor() {
        return valor;
    }

    /*
    *    @brief Modificadores
    */
    
    abstract void informe(int actual, ArrayList<Jugador> todos);
    //private void informe( int actual, ArrayList<Jugador> todos ){
    //    Diario.getInstance().ocurreEvento("Se esta aplicando una sorpresa del tipo " + tipo + " a " + todos.get(actual).getNombre());
                
    // }
    
    abstract void aplicaraJugador(int actual, ArrayList<Jugador> todos);
    //protected void aplicaraJugador(int actual, ArrayList<Jugador> todos){ // actual determina mi jugador
        
    //   if (tipo ==  TipoSorpresa.PAGARCOBRAR)
    //       aplicaraJugador_pagarCobrar(actual,  todos);
    //    else
    //       aplicaraJugador_porCasaHotel(actual,  todos);    
    //    llamo a pagarCobrar o porCasaHotel segun el tipoSorpresa
    //  }
    
    
    @Override
    public String toString() {
        return "\nSorpresa: "  + texto + " " + Integer.toString(valor) ;
    }
    
    
}
