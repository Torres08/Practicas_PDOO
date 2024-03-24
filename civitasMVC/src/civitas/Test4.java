/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author lazaro
 */
public class Test4 {

    
    public static void main(String[] args) {
        /*
            Crea un jugador
            Asocia una propiedad
            Conviertelo a JUgadorEspectador y muestralo
            
            Comprueba que la propiedad que se le asocia cambia de propietario en la conversion ToString
        */
        
        // creo mi jugador
        Jugador jugador_ejemplo = new Jugador("Juan");
        
        // mi array de jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador_ejemplo);
        
        // creo mi propiedad a la que voy a convertir, con us sorpresa
        CasillaCalle propiedad = new CasillaCalle("Casa Ejemplo 1", 10,50,0); // vale 10$
        SorpresaConversion sorpresa = new SorpresaConversion("Te ha tocado una sorpresa -> convertirte");
        
        // compro la propiedad para tenerla
        jugador_ejemplo.comprar(propiedad);
        
        // convertimos a el jugador
        System.out.println("Jugador antes de convertirse " + "\n" + jugadores.get(0).toString());
        // aplicamos la sorpresa
        sorpresa.aplicaraJugador(0, jugadores);
        System.out.println("Jugador despues de convertirse " + "\n" + jugadores.get(0).toString());

        // imprimo los eventos de mi diario
        while(Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
        System.out.println("");
        
        // llamo al array creando Convertido
        //JugadorEspeculador Convertido = (JugadorEspeculador)jugadores.get(0);
        JugadorEspeculador Convertido = new JugadorEspeculador(jugadores.get(0)); // lo mismo que arriba
        // creamos una casilla para que especulador lo compre a mitad de precio lo compra a 5
        CasillaCalle propiedad2 = new CasillaCalle("Casa Ejemplo 2", 10,50,0);

        Convertido.comprar(propiedad2);
        
         // imprimo los eventos de mi diario
        while(Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
        System.out.println("");
        
        // construyo al completo la propiedad2
        for(int i = 0; i < 8; i++){
            while(!Convertido.construirHotel(1)){
                Convertido.construirCasa(1); //construye casas
            } //debe de poder construirlas todas
        }
        
        for(int i = 0; i < 4; i++)
            Convertido.construirCasa(1);
        
        
        // leo mi diario
        //while(Diario.getInstance().eventosPendientes()){
        //   System.out.println(Diario.getInstance().leerEvento());
        //}
       
        
        //System.out.println("Tiene " + Convertido.getPropiedades().get(1).getNumCasas() + " casas");
        //System.out.println("Tiene " + Convertido.getPropiedades().get(1).getNumHoteles() + " hoteles");
        System.out.println(Convertido.toString());

        // no podemos construir de mas !!
        
        /*
         La propiedad  y 2 son de juan, ahora, compro la propiedad 1, luego le
         toco sorpresa y se convirtio a jugadoEspeculadoe "tiene ventajas" y luego compro
         propiedad 2
         //la propiedad 2 esta bajo los efectos de jugadorEspeculador, la propiedad 1 actua normal
        
        */
        
    }
    
}
