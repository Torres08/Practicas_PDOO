package EjerciciosJava;

public class EjerciciosJava{

    public static void imprimirParcela(Parcela a){
        System.out.println("\nNombre de la parcela " + a.getNombre());
        System.out.println("Precio de la parcela " + a.getPrecioCompra());
        System.out.println("Alquiler Completo de la parcela " + a.getPrecioAlquilerCompleto());
        System.out.println("Edificar en la parcela " + a.getPrecioEdificar());
        System.out.println("Casas en la parcela "+ a.getNumCasas());
        System.out.println("Hoteles de la parcela " + a.getNumHOteles());
        
    
    
    }
    
    public static void main(String[] args) {
        
        Parcela parcela1 = new Parcela("Parcela 1 ", 10000, 5000, 1000);
        Parcela parcela2 = new Parcela("Parcela 2 ", 20000, 7000, 3000);
        
        parcela1.construirCasa();
        parcela2.construirHotel();
        
        System.out.println("\nInicio ");
        imprimirParcela(parcela1);
        imprimirParcela(parcela2);

    }

}
