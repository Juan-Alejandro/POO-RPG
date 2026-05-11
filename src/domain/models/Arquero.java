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
public void usarHabilidadEspecial(Personaje enemigo, TiposPersonajes tiposPersonajes) {
    int probabilidad = ThreadLocalRandom.current().nextInt(100); 

    switch (tiposPersonajes) {
        case BASTO: 
            if (probabilidad < 70) {
                int dañoTotal = (int) ((getPoderAtaque() * 0.75) * 3);
                System.out.println("TRIFUERZA: Disparas tres flechas bendecidas.");
                enemigo.recibirDanio(dañoTotal);
            } else {
                System.out.println("Trifuerza fallida");
            }
            break;

        case ORO: 
            if (probabilidad < 50) {
                int danioTotal = getPoderAtaque() + enemigo.getDefensa(); 
                System.out.println("OJO DE HALCÓN penetro la armadura");
                enemigo.recibirDanio(danioTotal);
            } else {
                System.out.println("Ojo de halcón no sirvio");
            }
            break;

        case ESPADA:
            if (probabilidad < 20) {
                int numFlechas = ThreadLocalRandom.current().nextInt(1, 6);
                int dañoRafaga = getPoderAtaque() * numFlechas;
                System.out.println("🌪️ ¡RÁFAGA! Has disparado " + numFlechas + " flechas seguidas.");
                enemigo.recibirDanio(dañoRafaga);
            } else {
                System.out.println("Rafaga fallida");
            }
            break;

        case COPA:
            if (probabilidad < 50) {
                System.out.println("El enemigo ha sido aturdido");
                enemigo.setEstadoPersonaje(domain.enums.EstadoPersonaje.ATURDIDO);
                enemigo.recibirDanio((int)(getPoderAtaque() / 4));
            } else {
                System.out.println("El enemigo no fue aturdido");
            }
            break;
        default:
            break;
    }
}

    @Override
    public void poderMagico(Personaje objetivo) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            System.out.println("Rafaga de flechas");
            objetivo.recibirDanio(ThreadLocalRandom.current().nextInt(6) * getPoderAtaque());
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
