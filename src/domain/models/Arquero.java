package domain.models;

public class Arquero extends Personaje{
    
    private final int flechasMaximas;
    private int cantidadFlechas; 



    public Arquero(
        String nombrePersonaje,
        int vidaMaxima, 
        int vidaActual, 
        int poderAtaque, 
        int defensa, 
        int flechasMaximas, 
        int cantidadFlechas){
        super(nombrePersonaje, vidaMaxima, vidaActual, poderAtaque, defensa);
        this.flechasMaximas = flechasMaximas;
        this.cantidadFlechas = cantidadFlechas;
    }
     
    public int getFlechasMaximas() {
        return flechasMaximas;
    }

    public int getCantidadFlechas() {
        return cantidadFlechas;
    }

    public void dispararFlecha() {
        System.out.println("Flecha disparada");
    }


    @Override
    public void recibirDanio(){

    }

    @Override
    public void atacar() {

    }
}
