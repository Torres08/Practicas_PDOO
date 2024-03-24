/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.Random;

/**
 *
 * @author lazaro
 */
/**
 * @brief Clase Dado que gestiona las posiciones del jugador en el tablero.
 * Devuelve numeros pseudoaleatorios.
 * Es un singleton por lo que no puede ser instanciada(No hay constructor)
 * Igualmente se pueden crear objetos dado para no escribir dado.getInstance()
 * Puede ponerse en modo debug para que siempre tire 1.
 */
public class Dado {
     
    /*
    *   @brief  Atributos de instancia, mi objeto es el dado
    */
    private static final Dado instance = new Dado();
    private boolean debug;
    private int ultimoResultado;
    private final Random random;
    
    private static final int VALORESDADO = 6;
    private static final int VALORESDEBUG = 1;
    
     /*
    *   @brief Constructor privado vacio
    */
    private Dado(){
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }
    
     /*
     *  @brief Consultor
     */
     
    public static Dado getInstance(){
        return instance;
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;
    }
    
     public boolean getDebug(){
        return debug;
    }
     
     /*
    *   @brief Modificadores
    */
     
    public int tirar(){
         int valor = VALORESDEBUG;
         
         if (!debug){
             valor = random.nextInt(VALORESDADO)+1;
         }
         
         ultimoResultado = valor;
         return valor;
     }
     
    public int quienEmpieza(int n){ // n total jugadores
           return random.nextInt(n);
     }
    
    public void setDebug(boolean d){
        debug = d;
        Diario.getInstance().ocurreEvento("El Dado ha cambiado debug a " + debug + ".");
    }
    
    @Override
    public String toString() {
        return "\nDado\n" + "valor: " + Integer.toString(tirar()) + "   Empieza Jugador: "+ this.quienEmpieza(4)+ " \n";
    }
    
}
