package domain.models;

import java.util.concurrent.ThreadLocalRandom;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.HabilidadEspecial;

public class Guerrero extends Personaje implements HabilidadEspecial {

    public Guerrero(
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
        System.out.println("Golpe de arma");
        enemigo.recibirDanio(getPoderAtaque());
    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo, TiposPersonajes tiposPersonajes) {
        int probabilidad = java.util.concurrent.ThreadLocalRandom.current().nextInt(100);
        int danioBase = getPoderAtaque();

        switch (tiposPersonajes) {
            case ORO:
                if (probabilidad < 40) {
                    System.out.println("Se le ha hecho el triple de daño al enemigo");
                    enemigo.recibirDanio(danioBase * 3);
                } else {
                    int autoDanio = (int) (danioBase * 0.5);
                    System.out.println("No acerto acerto y se hizo " + autoDanio + " de daño");
                    this.recibirDanio(autoDanio);
                }
                break;

            case ESPADA: 
                if (probabilidad < 30) {
                    System.out.println("Golpe acertado, pero pierdes 10% de tu vida");
                    enemigo.recibirDanio(danioBase * 3);
                } else {
                    System.out.println("Golpe no acertado, pierdes 10% de tu vida");
                }
                int vidaPerdida = (int) (getVidaActual() * 0.1);
                setVidaActual(getVidaActual() - vidaPerdida);
                break;

            case COPA:
                if (probabilidad < 70) {
                    System.out.println("Has aturdido al enemigo y a ti mismo");
                    enemigo.setEstadoPersonaje(domain.enums.EstadoPersonaje.ATURDIDO);
                    this.setEstadoPersonaje(domain.enums.EstadoPersonaje.ATURDIDO);
                } else {
                    System.out.println("Ninguno fue aturdido");
                }
                break;

            case BASTO:
                int bonusDanio = getVidaMaxima() - getVidaActual();
                int danioTotal = danioBase + bonusDanio;
                System.out.println("Tienes un bonus de daño debido a la vida perdida y es de: " + bonusDanio);
                enemigo.recibirDanio(danioTotal);
                break;
            default:
                break;
        }
    }

    @Override
    public void poderMagico(Personaje objetivo) {
        int probabilidad = ThreadLocalRandom.current().nextInt(100);
        if(probabilidad < 50) {
            objetivo.recibirDanio(this.getPoderAtaque()*2);
        } 
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\n";
    }

}
