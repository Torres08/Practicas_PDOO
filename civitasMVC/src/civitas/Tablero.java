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

/*
*   @brief Esta clase tiene la responsabilidad de representar el tablero de juego imponiendo
*          las restricciones existentes sobre las reglas de juego. Dispone de los atributos
*          Dispone de atributos y metodos especificos cuya finalidad es asegurar que el tablero
*          sea construido correctamente y que no acceda a posiciones invalidas.
*
*          Su responsabilidad es el calculo de la posicion de destino despues de una tirada con
*          el dado.
 */
public class Tablero {

    /**
    *   @brief  Atributos de instancia, mi objeto es el tablero
     */
    private final ArrayList<Casilla> casillas;
    private boolean porSalida;
    private static final int TAMANIOTABLERO = 20;
    private static final int ERROR = -1;

    /**
    * @brief Constructor
     */
    public Tablero(){
        casillas = new ArrayList<>();
        //Casilla salida = new Casilla("Salida");
        //casillas.add(salida);
        porSalida = false;
    }
    
    /**
    *   @brief Comprobadores
    *   @return true si su parametro es un indice valido para acceder a elementos casilla
    */
    private boolean correcto(int numCasilla){
        return numCasilla > -1 && numCasilla < casillas.size();
    }
    
    /**
    * @brief consultores
    * @return actual
    */
    
    public boolean computarPasoPorSalida(){
        boolean actual = porSalida;
        porSalida = false;
        return actual;
    }
    
    public Casilla getCasilla(int numCasilla){
        if (correcto(numCasilla)) // Compruebo si es correcto
            return casillas.get(numCasilla); // 0 tmb vale, es salida
        else
            return null;
    }
    
    public Casilla getCasilla(){
        int ultimaposicion = Dado.getInstance().getUltimoResultado();
        return getCasilla(ultimaposicion);
    }
    
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
     public int nuevaPosicion(int actual, int tirada){
         int nuevaPosicion = (actual+tirada)%TAMANIOTABLERO;
         if (nuevaPosicion != actual  +tirada)
               porSalida = true;
         return nuevaPosicion;
     }
     
    public void anaideCasilla( Casilla nueva){
        casillas.add(nueva);
    }
}
