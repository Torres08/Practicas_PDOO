/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author lazaro
 */
/**
 * @brief Clase GestionInmobiliaria que gestiona las operaciones sobre las calles.
 */
public class GestionInmobiliaria {
    private int propiedad;
    private final OperacionInmobiliaria operacion;
    
    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip){
        operacion = gest;
        ip = propiedad;
    }
    
    public OperacionInmobiliaria getOperacion(){
        return operacion;
    }
    
    public int getPropiedad(){
        return propiedad;
    }
}
