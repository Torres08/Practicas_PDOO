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
public class CasillaSorpresa extends Casilla{
    private MazoSorpresa mazo; // mazo
    private Sorpresa sorpresa;  // sorpresa
    
   public CasillaSorpresa(){
       super(null);
   } 
   
   CasillaSorpresa(String nombre, MazoSorpresa mazo){
       super(nombre);
       this.mazo = mazo;
   }
   
   @Override
   void RecibeJugador(int iactual, ArrayList<Jugador> todos){
       super.RecibeJugador(iactual, todos);
       Sorpresa _sorpresa = mazo.siguiente();
       _sorpresa.aplicaraJugador(iactual, todos);
       
   }
   
   @Override
    public String toString(){
        String cadena = "una casilla Sorpresa";
        
        return cadena;
    }
   
   
}
