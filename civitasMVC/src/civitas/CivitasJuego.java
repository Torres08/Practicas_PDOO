/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;
//import java.util.Random;
//import java.util.Collections;

/**
 *
 * @author lazaro
 */
/**
 * @brief Clase Principal del paquete. Gestiona la lógica interna del juego. Se
 * crea el tablero con 14 calles, 4 casillas sorpresa, 1 descanso y la salida.
 * Se crea el dado, el mazo y el diario de eventos.
 */
public class CivitasJuego {

    static final int TAMANIOTABLERO = 20;
    private int indiceJugadorActual;

    private ArrayList<Jugador> jugadores;
    private final Dado dado = Dado.getInstance();
    private MazoSorpresa mazo;
    private Tablero tablero;
    private EstadosJuego estadojuego;
    private GestorEstados gestorestado;

    private void init() {
        indiceJugadorActual = 0;
        jugadores = new ArrayList<>();
        tablero = new Tablero();
        mazo = new MazoSorpresa();
        gestorestado = new GestorEstados();
        estadojuego = null;
    }

    public CivitasJuego(ArrayList<String> nombres, boolean debug) {
        init();

        // jugadores
        for (int i = 0; i < nombres.size(); i++) { // inicializo jugadores
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }

        // fijar estado inicial
        estadojuego = GestorEstados.estadoInicial();

        //Poner el dado en modo debug(o no)
        dado.setDebug(debug);

        //Se sortea el jugador que empieza
        indiceJugadorActual = dado.quienEmpieza(jugadores.size());

        inicializarTablero(mazo);
        inicializarMazoSorpresa();

    }

    private void inicializarMazoSorpresa() {
        Sorpresa s1 = new SorpresaPagarCobrar("COBRAR",2000);
        Sorpresa s2 = new SorpresaPagarCobrar("PAGAR", -2000);
        Sorpresa s3 = new SorpresaPorCasaHotel("PAGA POR CASA", -1000); 
        Sorpresa s4 = new SorpresaPorCasaHotel("COBRA POR CASA", 1000);
        Sorpresa s5 = new SorpresaPorCasaHotel("PAGA POR HOTEL", -4000);
        Sorpresa s6 = new SorpresaPorCasaHotel("COBRA POR HOTEL", 4000);
        
        mazo.alMazo(s1);
        mazo.alMazo(s2);
        mazo.alMazo(s3);
        mazo.alMazo(s4);
        mazo.alMazo(s5);
        mazo.alMazo(s6);
    }

    private void inicializarTablero(MazoSorpresa mazo) {
        
       Casilla calle0 = new Casilla ("Salida"); 
       Casilla calle1 = new CasillaCalle("Lavapies", 60, 50,4); // en M
       Casilla calle2 = new CasillaCalle("Calle Bravo Murillo", 120, 50, 8 );
       Casilla calle3 = new CasillaCalle("Glorieta de Bilbao", 140, 100, 10);
       Casilla calle4 = new CasillaCalle("Calle Serrano", 200, 100, 16 );
       Casilla calle5 = new CasillaCalle("Calle Cea Bermudez", 240, 150, 20);
       Casilla calle6 = new CasillaCalle("Plaza de España", 280, 150, 24);
       Casilla calle7 = new CasillaCalle("Gran Via", 320,200, 28 );
       Casilla calle8 = new CasillaCalle("Paseo del Prado", 400, 200, 50);
       
       Casilla Sorpresa = new CasillaSorpresa("SUERTE", mazo);
       Casilla Parking = new Casilla("Parking");
       
        // tablero.anaideCasilla();
        
        //PARTE INFERIOR DEL TABLERO
        tablero.anaideCasilla(calle0);
        tablero.anaideCasilla(calle1);
        tablero.anaideCasilla(calle2);
        tablero.anaideCasilla(Sorpresa);
        tablero.anaideCasilla(calle3);
        
        //PRIMER LATERAL
        tablero.anaideCasilla(calle4);
        tablero.anaideCasilla(Sorpresa);
        tablero.anaideCasilla(calle5);
        tablero.anaideCasilla(calle6);
        tablero.anaideCasilla(Parking);
        
        //PARTE SUPERIOR
        tablero.anaideCasilla(calle7);
        tablero.anaideCasilla(Sorpresa);
        tablero.anaideCasilla(calle8);
        tablero.anaideCasilla(calle1);
        tablero.anaideCasilla(calle1);
        
        //SEGUNDO LATERAL
        tablero.anaideCasilla(calle1);
        tablero.anaideCasilla(Sorpresa);
        tablero.anaideCasilla(calle1);
        tablero.anaideCasilla(calle1);
        tablero.anaideCasilla(calle1);
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void PasarTurno(){
        indiceJugadorActual = (indiceJugadorActual+1)%jugadores.size();
    }
    
    private void ContabilizarPasosPorSalida(){
        if(tablero.computarPasoPorSalida())
            getJugadorActual().pasaPorSalida();
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = dado.tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        ContabilizarPasosPorSalida();
        jugadorActual.MoverACasilla(posicionNueva);
        casilla.RecibeJugador(indiceJugadorActual, jugadores);
    }
    
    public boolean finalDelJuego(){
        boolean fin = false;
        for(int i = 0; i < jugadores.size() && !fin; i++)
            if(jugadores.get(i).enBancarrota())
                fin = true;
        
        return fin;
    }
    
     public boolean construirCasa(int ip){
        return getJugadorActual().construirCasa(ip);
    }
        
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    public ArrayList<Jugador> Ranking(){
        
        ArrayList<Jugador> Ranking = new ArrayList<>();
        
        
        for (int i =0; i < jugadores.size(); i++)
               Ranking.add(jugadores.get(i)); // paso los jugadores
        
        for (int i =0; i < Ranking.size() - 1; i++) // metodo de ordenacion
            for (int j = i+1; j < Ranking.size(); j++){
                if (Ranking.get(i).compareTo(Ranking.get(j)) < 0){
                    Jugador aux = new Jugador(Ranking.get(i));
                    Ranking.set(i, Ranking.get(j));
                    Ranking.set(j,aux);
                }
            }
                
        
        return Ranking;
        
        //Collections.sort(jugadores);
        //return jugadores;
     
        
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estadojuego = gestorestado.siguienteEstado(getJugadorActual(), estadojuego, operacion);
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual=getJugadorActual();
        OperacionJuego operacion = gestorestado.siguienteOperacion(jugadorActual, estadojuego);
        if(operacion==OperacionJuego.PASAR_TURNO){
            PasarTurno();
            siguientePasoCompletado(operacion);
        }
        else if(operacion==OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
     public boolean comprar(){       
       Jugador jugadorActual = getJugadorActual();
       int numCasillaActual = jugadorActual.getCasillaActual();
       CasillaCalle casilla = ((CasillaCalle)tablero.getCasilla(numCasillaActual)); //*
       boolean res = jugadorActual.comprar(casilla);
       
       return res; 
    }
    
    

}
