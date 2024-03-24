/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lazaro
 */
/*
*   @brief Se utiliza para llevar el registro de todos los eventos relevantes que se van produciendo en el juego
*          El diario solo almacena los eventos pendientes de ser consultados o leidos.
*          
*          Cada evento se representara mediante una cadena de caracteres con la descripcion del mismo
*
*          Sigue un patron Sigleton. Solo existe una instancia de una clase determinada
 */
public class Diario {

    /*
    *   @brief Es un singleton. La propia clase almacena la referenca a la unica instancia
     */
    static final private Diario instance = new Diario();

    private final ArrayList<String> eventos;

    static public Diario getInstance() {
        return instance;
    }

    public ArrayList<String> getEventos() {
        return eventos;
    }

    public int TotalEventos() {
        return eventos.size();
    }

    /*
    *   @brief Constructor privado para evitar que se puedan crear más instancias
     */
    protected Diario() { // private
        eventos = new ArrayList<>();
    }

    void ocurreEvento(String e) {
        eventos.add(e);
    }

    public boolean eventosPendientes() {
        return !eventos.isEmpty();
    }

    public String leerEvento() {
        String salida = "";

        if (!eventos.isEmpty()) {
            salida = eventos.remove(0); // si lee lo borra
        }
        return salida;
    }

}
