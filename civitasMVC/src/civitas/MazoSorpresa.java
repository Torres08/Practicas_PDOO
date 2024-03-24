/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lazaro
 */
/*
*   @brief Esta clase representa el mazo de cartas sorpresa. Además de almacenar cartas, las instancias
*          de esta clase velan por que el mazo se mantenga constistente a lo largo del juego.  
 */
public class MazoSorpresa {

    /*
    *   @brief  Atributos de instancia, mi objeto es el Mazo
     */
    private ArrayList<Sorpresa> sorpresa; // almacena las cartas sorpresa
    private boolean barajada;   // Si ha barajado o no
    private int usadas;
    private boolean debug;

    /*
    *   @brief Constructores 
     */
    private void init() {
        barajada = false;
        debug = false;
        usadas = 0;
        sorpresa = new ArrayList<>();
    }

    public MazoSorpresa() {
        init();
    }

    public MazoSorpresa(boolean _debug) {
        init();
        debug = _debug;
        Diario.getInstance().ocurreEvento("El mazo ha cambiado debug a " + debug);
    }

    /**
     * @brief Consultores
     */
    public ArrayList<Sorpresa> getMazoSorpresas() {
        return sorpresa;
    }

    void alMazo(Sorpresa s) {
        if (!barajada) {
            sorpresa.add(s);
        }

    }

    public Sorpresa siguiente() {
        if ((!barajada || usadas == sorpresa.size()) && !debug) {
            Collections.shuffle(sorpresa); //mezclamos los objetos
            usadas = 0;
            barajada = true;
        }
        usadas++;
        Collections.rotate(sorpresa, -1);
        return sorpresa.get(sorpresa.size() - 1);
    }
}
