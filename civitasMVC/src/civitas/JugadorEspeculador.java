/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author lazaro
 */
public class JugadorEspeculador extends Jugador{
    
    protected static float FactorEspeculador = 2;
    
    protected JugadorEspeculador(Jugador otro){
        super(otro);
        CasasMax*=FactorEspeculador;
        HotelesMax*=FactorEspeculador;
        
        ActualizaPropiedadesPorConversion(otro);
    }
    
    private void ActualizaPropiedadesPorConversion(Jugador jugador){
        jugador.getPropiedades().forEach(propiedad -> { propiedad.actualizaPropietarioPorConversion(this); });
    }
    
    float getFactorEspeculador(){return FactorEspeculador; }
    
    @Override
    boolean paga(float cantidad){
        float dinero = cantidad / FactorEspeculador;
        
        // Informo
        Diario.getInstance().ocurreEvento(this.getNombre() + " paga " + dinero + " en vez de " + cantidad + " por ser especulador");
        return super.paga(dinero); // vuelvo a hacer lo mismo
    }
}
