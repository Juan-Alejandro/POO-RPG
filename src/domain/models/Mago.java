package domain.models;

import java.util.concurrent.ThreadLocalRandom;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.HabilidadEspecial;

public class Mago extends Personaje implements HabilidadEspecial {

    public Mago(String nombrePersonaje,
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
        System.out.println("Fireball ");

        enemigo.recibirDanio(getPoderAtaque());

    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo, TiposPersonajes tiposPersonajes) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        if (tiposPersonajes == TiposPersonajes.ORO || tiposPersonajes == TiposPersonajes.COPA) {
            int multiplicador = random.nextInt(1, 6);
            int dañoTotal = getPoderAtaque() * multiplicador;
            int dañoRecibido = dañoTotal / 2;

            System.out.println("El multiplicador de daño es: " + multiplicador);
            objetivo.recibirDanio(dañoTotal);

            System.out.println("Recibes " + dañoRecibido + " de daño.");
            this.recibirDanio(dañoRecibido);

        } else {
            System.out.println("Preparando autocuracion");
            int dañoRealizado = getPoderAtaque();
            objetivo.recibirDanio(dañoRealizado);

            if (random.nextInt(100) < 40) {
                System.out.println("Se recupero " + dañoRealizado + " puntos de vida.");
                this.curarVida(dañoRealizado);
            } else {
                System.out.println("No surtio efecto la curacion");
            }
        }
    }

    @Override
    public void poderMagico(Personaje objetivo) {
        int probabilidad = ThreadLocalRandom.current().nextInt(100);
        if (probabilidad < 50) {
            objetivo.curarVida(10);
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\n";
    }
}
