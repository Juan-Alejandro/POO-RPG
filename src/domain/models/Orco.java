package domain.models;

import java.util.concurrent.ThreadLocalRandom;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
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
        PoderPersonajes nombrePoder,
        HabilidadClase habilidadClase,
        int poderAtaque, 
        int defensa){
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
        System.out.println("Orcotaque ");
        enemigo.recibirDanio(getPoderAtaque());
        
    }




    @Override
    public void usarHabilidadEspecial(Personaje enemigo, TiposPersonajes tiposPersonajes) {
        
        if (ThreadLocalRandom.current().nextInt(15) == 0 ||
                ThreadLocalRandom.current().nextInt(15) == 4 ||
                ThreadLocalRandom.current().nextInt(15) == 14) {
            System.out.println("Kill 'Em All !!! - Orco: Hora de la masacre");
            enemigo.recibirDanio(200);
            return;
        }

       
    }

    @Override
    public void poderMagico(Personaje objetivo) {
    System.out.println("Orco: Tratare de curarme\n");
        if (ThreadLocalRandom.current().nextInt(6) == 3) {
            System.out.println("Glotoneria!! - Orco: He curado mi vida a tope");

            setVidaActual(getVidaMaxima());

            System.out.println("Orco: Mi vida ahora es de- " + getVidaActual());
            return;
        }
        System.out.println("Orco: No pude usar mi poder Grrrrr");
    }

    @Override 
    public String toString(){
        return super.toString() +
            "\n\n";
    }
}
