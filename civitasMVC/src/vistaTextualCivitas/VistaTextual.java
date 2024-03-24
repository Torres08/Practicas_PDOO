/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaTextualCivitas;


import civitas.*; // asi englobamos todo lo de civitas
import controlador.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements VistaT {
  
    
  //private static final String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
   private void separador(){
        for(int i = 0; i < 200; i++)
            System.out.print("-");
        System.out.println("");
    }
           
  @Override
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

    @Override
    public void actualiza() {
       if(juegoModel.finalDelJuego()){
            ArrayList<Jugador> ranking = juegoModel.Ranking();
            for(int i = 0; i < ranking.size(); i++)
                System.out.println(ranking.get(i).getNombre() 
                        + " " + ranking.get(i).getSaldo() + "€");
            separador();
            System.out.println("Fin del juego");
            separador();
        }
        else{
            Jugador jugadorActual = juegoModel.getJugadorActual();
            System.out.println(jugadorActual.toString());   
        }
    }

    @Override
    public Respuesta comprar() {
        int opcion = menu("¿Desea comprar la casilla en la que ha caido?", new ArrayList<>(Arrays.asList("SI","NO")));
        return (Respuesta.values()[opcion]);  
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        int opcion = menu ("¿Cual es el numero de gestion inmobiliaria elegida?", new ArrayList<>(Arrays.asList("CONSTRUIR_CASA","CONSTRUIR_HOTEL","TERMINAR"))); 
        return (OperacionInmobiliaria.values()[opcion]);
    }

    @Override
    public int elegirPropiedad() {
         ArrayList<CasillaCalle> propiedades = juegoModel.getJugadorActual().getPropiedades();
        String titulo = "Elige una propiedad." 
                + "(Tienes " + propiedades.size()
                + " propiedades):";
        ArrayList<String> nombrePropiedades = new ArrayList<String> (){{
            for(int i = 0; i < propiedades.size(); i++)
                add(propiedades.get(i).getNombre());
        }};
        
        return  menu(titulo,nombrePropiedades);
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
            System.out.println(operación);
    }

    @Override
    public void mostrarEventos() {
        if(Diario.getInstance().eventosPendientes()){
            separador();
            while(Diario.getInstance().eventosPendientes()){
                System.out.println(Diario.getInstance().leerEvento());
            }
            separador();
        }
    }

}

