/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GUI;

/**
 *
 * @author lazaro
 */
//import GUI.*;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controlador.Respuesta;

/**
 * @brief Interfaz Vista que declara los metodos de la @c VistaTextual.
 * Funciona como un fichero .h de C++
 */
interface Vista{

    public void actualiza();

    public void pausa();

    public Respuesta comprar();

    public OperacionInmobiliaria elegirOperacion();

    public int elegirPropiedad();

    public void mostrarSiguienteOperacion(OperacionJuego operación);

    public void mostrarEventos();

}

