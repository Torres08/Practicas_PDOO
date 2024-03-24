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
/**
 * @brief Clase Padre Jugador que gestiona sus atributos y propiedades. Un
 * jugador puede: -Moverse por el tablero. -Comprar propiedades(Casilla calle)
 * -Construir casas y hoteles dentro de las reglas del juego -Pagar o Cobrar
 * dinero de sorpresas y/o hipotecas de calles de otro jugador -Convertirse en
 * un Especulador(Clase hija) que modifica ciertos atributos
 *
 * El implements Comparable es necesario para el método CompareTo necesario para
 * el ranking de jugadores por saldo(compara saldos)
 *
 * El jugador gana si el resto están en bancarrota y pierde si acaba en
 * bancarrota
 */
public class Jugador {

    protected static int CasasMax = 4;
    protected static int HotelesMax = 4;
    protected static int CasasPorHotel = 4;
    protected static float PasoporSalida = 1000f;
    private static float SaldoInicial = 7500f;

    private boolean puedeComprar;
    private int CasillaActual;
    private String Nombre;
    private float saldo;

    private ArrayList<CasillaCalle> propiedades; //*

    /*
    * @brief Constructor
     */
    private void init() {

        this.puedeComprar = false;
        this.Nombre = "";
        this.CasillaActual = 0;
        this.saldo = SaldoInicial;
        propiedades = new ArrayList<>();

    }

    public Jugador(String unNombre) {

        init();
        this.Nombre = unNombre;

    }

    protected Jugador(Jugador origen) {

        this.propiedades = origen.propiedades; // copio el array
        this.puedeComprar = origen.puedeComprar;
        this.Nombre = origen.Nombre;
        this.CasillaActual = origen.CasillaActual;
        this.saldo = origen.saldo;
    }

    /**
     * @return 
     * @brief consultores
     */
    public String getNombre() {
        return Nombre;
    }

    public int getCasillaActual() {
        return CasillaActual;
    }

    public float getSaldo() {
        return saldo;
    }
    
    public ArrayList<CasillaCalle> getPropiedades() {
        return propiedades;
    }

    private static int getCasasMax() {
        return CasasMax;
    }
    
    protected boolean getPuedeComprar(){
        return puedeComprar;
    }

    protected static int getCasasporHotel() {
        return CasasPorHotel;
    }

    private static int getHotelesMax() {
        return HotelesMax;
    }

    private static float getPremioPasoporSalida() {
        return PasoporSalida;
    }

    public int compareTo(Jugador otro) {
        return Float.compare(otro.getSaldo(), saldo);
    }

    /**
     * @brief Modificadores
     */
    boolean puedeComprarCasilla() {
        puedeComprar = true;
        return puedeComprar;
    }

    private boolean puedoGastar(float precio) {
        return saldo >= precio;
    }

    protected void setPuedeComprar(boolean condicion){
        puedeComprar = condicion;
        
    }
     
    boolean enBancarrota() {
        return saldo < 0;
    }

    boolean modificarSaldo(float cantidad) {
        String evento = "";
        saldo += cantidad;
        if (cantidad > 0) {
            evento = Nombre + " ha recibido " + cantidad + " €";
        } else if (cantidad < 0) {
            evento = Nombre + " ha gastado " + cantidad + " €";
        }
        Diario.getInstance().ocurreEvento(evento);
        return true;
    }

    protected int cantidadCasasHoteles() {

        int total = 0;

        for (int i = 0; i < propiedades.size(); i++) {
            total += propiedades.get(i).cantidadCasasHoteles();
            
        }

        return total;

    }

    boolean paga(float Cantidad) {
        return modificarSaldo(Cantidad * -1);
    }
    
    JugadorEspeculador convertir(){
        return new JugadorEspeculador(this);
    }

    protected boolean pagaAlquiler(float Cantidad) { // private
        return paga(Cantidad);
    }

    boolean pasaPorSalida() {
        recibe(getPremioPasoporSalida());
        String evento = Nombre + " ha pasado por la Salida";
        Diario.getInstance().ocurreEvento(evento);
        return true;
    }

    protected boolean recibe(float Cantidad) {
        return modificarSaldo(Cantidad);
    }

    boolean MoverACasilla(int numCasilla) {

        CasillaActual = numCasilla;
        puedeComprar = false;
        String evento = Nombre + " se ha movido a la casilla "
                + numCasilla;
        Diario.getInstance().ocurreEvento(evento);
        return true;

    }

    boolean tieneAlgoQueGestionar() {
        return !propiedades.isEmpty();
    }

    private boolean existeLaPropiedad(int ip) {

        return (ip > -1 && ip < propiedades.size()); // compurebo si la ip es menor que el total y mayor igual 0

    }

    private boolean puedoEdificarCasa(CasillaCalle propiedad) {
        boolean puedoEdificar = false;
        if (!puedoGastar(propiedad.getPrecioEdificar())) {
            Diario.getInstance().ocurreEvento(this.Nombre
                    + " ha intentado edificar una casa en " + propiedad.getNombre()
                    + " pero no tiene suficiente dinero." + "La casa vale "
                    + propiedad.getPrecioEdificar() + " y el jugador tiene " + saldo);
        } else if (propiedad.getNumCasas() >= getCasasMax()) {
            Diario.getInstance().ocurreEvento(this.Nombre
                    + " ha intentado edificar una casa en " + propiedad.getNombre()
                    + " pero ha excedido el limite de casas");
        } else {
            puedoEdificar = true;
        }

        return puedoEdificar;
    }

    private boolean puedoEdificarHotel(CasillaCalle propiedad) {
        boolean puedoEdificar = false;
        float precioHotel = propiedad.getPrecioEdificar() * CasillaCalle.getFACTORALQUILERHOTEL();
        if (!puedoGastar(precioHotel)) {
            Diario.getInstance().ocurreEvento(this.Nombre
                    + " ha intentado edificar un hotel en " + propiedad.getNombre()
                    + " pero no tiene suficiente dinero." + "El hotel vale "
                    + precioHotel + " y el jugador tiene " + saldo);
        } else if (propiedad.getNumCasas() < CasasPorHotel) {
            Diario.getInstance().ocurreEvento(this.Nombre
                    + " ha intentado edificar un hotel en " + propiedad.getNombre()
                    + " pero no tiene suficientes casas. Necesita " + CasasPorHotel
                    + " y tiene " + propiedad.getNumCasas());
        } else if (propiedad.getNumHoteles() >= getHotelesMax()) {
            Diario.getInstance().ocurreEvento(this.Nombre
                    + " ha intentado edificar un hotel en " + propiedad.getNombre()
                    + " pero ha excedido el limite de hoteles");
        } else {
            puedoEdificar = true;
        }

        return puedoEdificar;
    }

    //////////////////////////////////////////////////////////////////////
    boolean comprar(CasillaCalle titulo) {
        boolean result = false;
        if (puedeComprarCasilla()) { //puedeComprarCasilla?
            float precio = titulo.getPrecioCompra();

            if (puedoGastar(precio)) {
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento(Nombre + " compra la propiedad " + titulo.getNombre());
                puedeComprar = false;
            } else {
                Diario.getInstance().ocurreEvento(Nombre + " no tiene saldo para ocmprar la propiedad " + titulo);
            }
        }

        return result;
    }

    protected boolean construirHotel(int ip) { // private

        boolean result = false;

        if (existeLaPropiedad(ip)) {

            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            float precio = propiedad.getPrecioEdificar();

            if (puedoGastar(precio) && propiedad.getNumHoteles() < getHotelesMax() && propiedad.getNumCasas() >= getCasasporHotel()) {
                puedoEdificarHotel = true;
            }

            if (puedoEdificarHotel == true) {
                result = propiedad.ConstruirHotel(this);
                int casasPorHotel = getCasasporHotel();
                propiedad.derruirCasas(casasPorHotel, this);
            }

            Diario.getInstance().ocurreEvento("El jugador " + Nombre + " Construye hotel en la propiedad " + ip);

        }

        return result;
    }

    protected boolean construirCasa(int ip) {

        boolean result = false;

        boolean existe = existeLaPropiedad(ip);

        if (existe == true) {
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            float precio = propiedad.getPrecioEdificar();

            if (puedoGastar(precio) && propiedad.getNumCasas() < getCasasMax()) {
                puedoEdificar = true;
            }

            if (puedoEdificar) {
                result = propiedad.ConstruirCasa(this);
            }

            if (result) {
                Diario.getInstance().ocurreEvento("El jugador " + Nombre + " construye cas en la propiedad " + ip);
            }

        }

        return result;
    }

    @Override
    public String toString() {
        String cadena = "Jugador: " + Nombre
                + ", Casilla Actual: " + CasillaActual
                + ", Saldo: " + saldo;
        if (!propiedades.isEmpty()) {
            cadena += ". Propiedades de " + this.Nombre + ":\n";
            for (int i = 0; i < propiedades.size(); i++) {
                cadena += "- " + propiedades.get(i).getNombre() + " | Casas: "+ propiedades.get(i).getNumCasas() + " Hoteles: " +propiedades.get(i).getNumHoteles();
            }
        } else {
            cadena += ". No tiene propiedades aún.";
        }

        cadena += "\n";
        return cadena;
    }

}
