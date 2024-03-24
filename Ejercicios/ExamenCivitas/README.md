# Examen 2º Prácticas PDOO 17/12/2020

## Descripción

El examen consiste en modificar un proyecto Java relacionado con el juego Civitas para incorporar nuevas reglas y funcionalidades. Se agregan calles ecológicas o sostenibles que requieren una inversión para su sostenibilidad. Además, se introduce una nueva gestión inmobiliaria llamada HACER_SOSTENIBLE. El objetivo es implementar las clases y métodos necesarios según un diagrama de clases y un diagrama de secuencias proporcionados.

## Pasos para la implementación

1. **Clase `CasillaCalleSostenible`**: Crear la subclase con el atributo `porcentajeInversion`, sobrescribir el constructor y el método `toString`.

2. **Método `getPrecioAlquilerCompleto`**: Sobrescribir el método para aplicar la nueva regla del juego relacionada con el precio de alquiler.

3. **Método `calcularPorcentajeInversionPorSostenibilidad`**: Definir este método en la clase `CasillaCalle` para calcular el porcentaje requerido para hacer la propiedad sostenible.

4. **Método `getImporteHacermeSostenible`**: Definir este método en la clase `CasillaCalle` para calcular el importe necesario para hacer la propiedad sostenible.

5. **Método `hacermeSostenible`**: Definir este método en la clase `CasillaCalle` para convertir la calle en sostenible.

6. **Método `soySostenible`**: Definir este método en la clase `CasillaCalle` para devolver `false`.

7. **Método `soySostenible` en `CasillaCalleSostenible`**: Redefinir este método para devolver `true`.

8. **Método `getImporteHacermeSostenible` en `CasillaCalleSostenible`**: Redefinir este método para devolver `0`.

9. **Método `hacermeSostenible` en `CasillaCalleSostenible`**: Redefinir este método para devolver `null`.

10. **Método `inicializaTablero` en `CivitasJuego`**: Cambiar la creación de dos calles para que sean de tipo `CasillaCalleSostenible`.

11. **Método `hacerCalleSostenible` en `CivitasJuego`**: Implementar según el diagrama de secuencias proporcionado.

12. **Método `juega` en `Controlador`**: Añadir el código necesario para llamar al método `hacerSostenible` de `CivitasJuego` cuando el jugador elija la operación inmobiliaria HACER_CALLE_SOSTENIBLE.

13. **Constructor en `GestionarDialog`**: Asegurarse de que se muestran todos los valores del enumerado `GestionesInmobiliarias`, incluyendo la nueva operación `HACER_CALLE_SOSTENIBLE`.

14. **Clase `PropiedadPanel`**: Agregar un `JCheckBox` que esté marcado si se trata de una calle sostenible.

15. **Método `main` en `TestP5`**: Probar el programa y realizar los cambios necesarios para que funcione correctamente.
