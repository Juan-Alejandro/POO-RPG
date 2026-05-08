package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.HabilidadEspecial;

public class Orco extends Personaje implements HabilidadEspecial {


    public Orco(
        String nombrePersonaje,
        int vidaMaxima, 
        int vidaActual, 
        ClasesPersonajes personaje,
        EstadoPersonaje estadoPersonaje,
        BandoPersonaje bandoPersonaje,
        TiposPersonajes tiposPersonajes,
        int poderAtaque, 
        int defensa){
        super(nombrePersonaje, vidaMaxima, vidaActual, personaje,estadoPersonaje, bandoPersonaje, tiposPersonajes, poderAtaque, defensa);
    }




    @Override
    public void atacar(Personaje enemigo) {

    }




    @Override
    public void habilidades(Personaje enemigo) {

        if(this.getVidaActual() <= 0) return;

        System.out.println("Comelon");
        setVidaActual(this.getVidaMaxima());
    }


    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

    }

    @Override
    public void habilidadBase(Personaje enemigo) {

    }
}
