/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author ylopezramirez
 */
public class CasillaCalleSostenible extends CasillaCalle {
    float porcentajeInversion;

    public CasillaCalleSostenible(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        super(titulo, precioCompra, precioEdificar, precioBaseAlquiler);
        porcentajeInversion = 5;
    }

    public void setPorcentajeInversion(float porcentajeInversion) {
        this.porcentajeInversion = porcentajeInversion;
    }
    
    @Override
    public boolean soySostenible(){
        return true;
    }
    
    @Override
    public float getImporteHacermeSostenible(){
        return 0;
    }
    
    @Override
    public CasillaCalleSostenible hacermeSostenible(Jugador jugador){
        return null;
    }
    
    @Override
    public float getPrecioAlquilerCompleto(){
        float precioAlquiler = super.getPrecioAlquilerCompleto();
        return precioAlquiler + precioAlquiler*porcentajeInversion;
    }
    
    @Override
    public String toString() {
        String cadena = "Propiedad Sostenible(Inversion del " + porcentajeInversion
                + "). ";
        cadena += super.toString();
        return cadena;
    }
    
   
}
