package EjerciciosJava;
public class Parcela {

    private String nombre;
    private float precioCompra, precioEdificar,precioBaseAlquiler;
    private int numCasas, numHoteles;
    
    // variables de clase
    private static float FACTORALQUILERCALLE=1.0f ;
    private static float FACTORALQUILERCASA= 1.0f;
    private static float FACTORALQUILERHOTEL= 4.0f;

    //inicializador
    public Parcela(String _nombre, float _precioCompra, float _precioEdificar, float _precioBaseAlquiler){
        this.nombre= _nombre;
        this.precioBaseAlquiler= _precioBaseAlquiler;
        this.precioCompra=_precioCompra;
        this.precioEdificar=_precioEdificar;
        this.numCasas=this.numHoteles=0; // caso en el que solar esta vacio
        
    }
    
    //Consultores
    public String getNombre(){return nombre;}
    public float getPrecioCompra(){return precioCompra;}
    public float getPrecioEdificar(){return precioEdificar;}
    public int getNumCasas(){return numCasas;}
    public int getNumHOteles(){return numHoteles;}

    //Metodo Alquiler Completo
    public float getPrecioAlquilerCompleto(){
        return (precioBaseAlquiler* FACTORALQUILERCALLE*(1+numCasas*FACTORALQUILERCASA + 4*numHoteles*FACTORALQUILERHOTEL));

    }

    //Modificadores
    public boolean construirCasa(){
        numCasas++;
        return true;
    }

    public boolean construirHotel(){
        numHoteles++;
        return true;
    }

    public boolean IgualIdentidad(Parcela OtraParcela){

        boolean resultado = (this == OtraParcela)?true:false;
        return resultado;

    }

    public boolean igualdadEstado(Parcela OtraParcela){
        boolean resultado = (this.equals(OtraParcela))?true:false;
        return resultado;
    }


    }
