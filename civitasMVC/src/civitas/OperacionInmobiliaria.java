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
public enum OperacionInmobiliaria {
    CONSTRUIR_CASA, CONSTRUIR_HOTEL, HACER_CALLE_SOSTENIBLE, TERMINAR;
    
    /**
     * @brief Convierte el enumerado en ArrayList de String necesario para el menú
     * de @¢ VistaTextual
     * @return el enumerado en forma de ArrayList de String
     */
    public static ArrayList<String> operaciones(){
        
        ArrayList<String> operaciones = new ArrayList<String> (){{
            for (OperacionInmobiliaria value : OperacionInmobiliaria.values()) 
                add(value.toString() + ",");
            
        }};
        return operaciones;
    }
    
    public static OperacionInmobiliaria eleccion(int opcion){
        OperacionInmobiliaria eleccion = null;
        switch(opcion){
            case 0:
                eleccion = OperacionInmobiliaria.CONSTRUIR_CASA;
                break;
            case 1:
                eleccion = OperacionInmobiliaria.CONSTRUIR_HOTEL;
                break;
            case 2:
                eleccion = OperacionInmobiliaria.HACER_CALLE_SOSTENIBLE;
                break;
            case 3:
                eleccion = OperacionInmobiliaria.TERMINAR;
        }
        return eleccion;
    }
}

