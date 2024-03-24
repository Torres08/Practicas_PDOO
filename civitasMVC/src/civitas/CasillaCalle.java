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
public class CasillaCalle extends Casilla {
    
    private float precioCompra, precioEdificar, precioBaseAlquiler;// COntiene para las casillas de tipo calle los respectivos precios asociados
    private int numCasas,numHoteles; // tipo casilla -> numero de casa y hoteles
    
    private static final float FACTORALQUILERCALLE=1.0f;
    private static final float FACTORALQUILERCASA=1.0f;
    private static final float FACTORALQUILERHOTEL=4.0f;
    
    private Jugador propietario;
    
    
    CasillaCalle(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
            super(titulo); // **
            this.precioCompra = precioCompra;
            this.precioEdificar = precioEdificar;
            this.precioBaseAlquiler = precioBaseAlquiler;
            
    }
    
    
    // deben ser privados
    protected float getPrecioCompra(){return precioCompra;}
    protected float getPrecioEdificar(){return precioEdificar ;}
    public float getPrecioBaseAlquiler() {return precioBaseAlquiler;}
    public int getNumCasas(){return numCasas;}
    public int getNumHoteles(){return numHoteles;}
   
    protected static float getFACTORALQUILERHOTEL(){return FACTORALQUILERHOTEL;}
    protected static float getFACTORALQUILERCASA(){return FACTORALQUILERCASA;}
    protected static float getFACTORALQUILERCALLE(){return  FACTORALQUILERCALLE;}
    
    public int cantidadCasasHoteles(){
        return numCasas+numHoteles;
    }
    
    private float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler*FACTORALQUILERCALLE*(1+numCasas*FACTORALQUILERCASA + 4*numHoteles*FACTORALQUILERHOTEL));
    }
    
    protected boolean comprar(Jugador jugador){
       
        boolean puedeComprar = jugador.puedeComprarCasilla();
        if (puedeComprar){
               propietario=jugador;
            jugador.paga(precioCompra);
        }
      
        return puedeComprar; // Completar
    }
    
    protected boolean ConstruirCasa(Jugador jugador){
        jugador.paga(precioCompra);
        numCasas++;
        return true; // Completar
    }
    
    protected boolean ConstruirHotel(Jugador jugador){
        jugador.paga(precioCompra);
        numHoteles++;
        return true; // Completar
    }
    
    
    public boolean TienePropietario(){
        return propietario != null;
        
    }
    
    protected boolean derruirCasas(int n, Jugador jugador){
        
        if (esEsteElPropietario(jugador) && n >= getNumCasas()){
              this.numCasas -= 1;
              return true;
        } else
              return false;  
         
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        
        return !(propietario.getNombre().equals(jugador.getNombre())); // equals es  == 
      
    }
    
    public void TramitarAlquiler(Jugador jugador){
        
        if (this.TienePropietario() && !esEsteElPropietario(jugador)){
            float importe = getPrecioAlquilerCompleto();
            Diario.getInstance().ocurreEvento(jugador.getNombre() + 
                    " paga un alquiler de " + importe + "€ a " + propietario.getNombre()
                    + " por la propiedad " + getNombre());
            jugador.pagaAlquiler(importe);
            this.propietario.recibe(importe);
            
            
        }
        
    }
    
    @Override
    void RecibeJugador(int iactual, ArrayList<Jugador> todos){
           Jugador jugador = todos.get(iactual);
           
           if (!TienePropietario()){
               jugador.puedeComprarCasilla();
           } else {
               TramitarAlquiler(jugador);
           }
           
           super.RecibeJugador(iactual, todos); // IMPORTANTE HACER SUPER PARA RELLENAR AL PADRE
    }
    
    @Override
    public String ToString(){
         String cad = "\nCalle \n" + super.ToString() + "\n\nPrecios \nCompra: " + precioCompra + ", Edificar: " + precioEdificar + ", AlquilerBase: " + precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + numHoteles  +"\n" ;
    
         if (TienePropietario())
               cad += "Propietario " + propietario.getNombre();
         else
               cad += "Sin propietarios";
    
         return cad;
    }
    
    void actualizaPropietarioPorConversion(JugadorEspeculador convertido){
        Jugador antiguo = propietario;
        propietario = convertido;
        
        // solo informo
        Diario.getInstance().ocurreEvento("La propiedad "+ getNombre() + " pasa de " + antiguo.getNombre() + " a " + propietario.getNombre() );
    }
}
