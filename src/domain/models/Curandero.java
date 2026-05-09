package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.Curable;

public class Curandero extends Personaje implements Curable{

    private final int puntosCuracion;

    public Curandero(String nombrePersonaje,
            int vidaMaxima,
            int vidaActual,
            ClasesPersonajes personaje,
            EstadoPersonaje estadoPersonaje,
            BandoPersonaje bandoPersonaje,
            TiposPersonajes tiposPersonajes,
            int poderAtaque,
            int defensa,
            int puntosCuracion) {
        super(nombrePersonaje, vidaMaxima, vidaActual, personaje, estadoPersonaje, bandoPersonaje, tiposPersonajes,
                poderAtaque, defensa);
        this.puntosCuracion = puntosCuracion;
    }

    public int getPuntosCuracion() {
        return puntosCuracion;
    }


    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Golpe de angel");
        
        enemigo.recibirDanio(getPoderAtaque());
    }

    @Override
    public void curar(Personaje aliado) {
        aliado.setVidaActual(aliado.getVidaActual()+puntosCuracion);
    }

    @Override 
    public String toString(){
        return super.toString() +
            "\n\n";
    }

}
