/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;

import GUI.CapturaNombres;
import GUI.CivitasView;
import controlador.Controlador;
import java.util.ArrayList;

/**
 *
 * @author lazaro
 */
public class Test5 {

    /**
     * @param args the command line arguments
     */
    /*
        Crea un objeto CivitasView
    
        Crear una instancia de CapturaNombres
    
        Crear un ArrayList de nombres, vacío y asignarle los nombres que se obtengan tras enviar el
        mensaje getNombres a la instancia de CapturaNombres anterior.
    
        Crear un objeto de CivitasJuego
    
        Crear una instancia de la clase Controlador
    
        Enviar a la vista el mensaje setCivitasJuego, con el objeto CivitasJuego creado
    
        
    */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        CivitasView vistaCivitas = new CivitasView();
        
        CapturaNombres capturaNombres = new CapturaNombres(vistaCivitas,true);
        
        ArrayList<String> nombres= capturaNombres.getNombres();
        
        CivitasJuego juego = new CivitasJuego(nombres,true);
        
        Controlador controlador = new Controlador(juego,vistaCivitas);
        
        vistaCivitas.setCivitasJuego(juego);
        
        controlador.juega();
    }
    
}
