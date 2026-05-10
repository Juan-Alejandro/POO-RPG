package domain.models;

import java.util.concurrent.ThreadLocalRandom;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.HabilidadEspecial;

public class Arquero extends Personaje implements HabilidadEspecial {

    public Arquero(
            String nombrePersonaje,
            int vidaMaxima,
            int vidaActual,
            ClasesPersonajes personaje,
            EstadoPersonaje estadoPersonaje,
            BandoPersonaje bandoPersonaje,
            TiposPersonajes tiposPersonajes,
            PoderPersonajes nombrePoder,
            HabilidadClase habilidadClase,
            int poderAtaque,
            int defensa) {
        super(nombrePersonaje, 
            vidaMaxima, 
            vidaActual, 
            personaje, 
            estadoPersonaje, 
            bandoPersonaje, 
            tiposPersonajes,
            nombrePoder,
            habilidadClase,
            poderAtaque, 
            defensa);
    }


    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Flecha disparada\n");
        
        enemigo.recibirDanio(getPoderAtaque());
    }



    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

    }

    @Override
    public void poderMagico(Personaje objetivo) {
        if(ThreadLocalRandom.current().nextBoolean()){
            System.out.println("Rafaga de flechas");
            objetivo.recibirDanio(ThreadLocalRandom.current().nextInt(6)*getPoderAtaque());
            return;
        }
        System.out.println("Arquero: Fallo al disparar");
    }

    // Impresion de datos
    @Override
    public String toString() {
        return super.toString();
    }

}
