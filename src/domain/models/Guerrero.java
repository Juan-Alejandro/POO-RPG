package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
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
            int poderAtaque,
            int defensa) {

        super(nombrePersonaje, vidaMaxima,vidaActual, personaje, estadoPersonaje, bandoPersonaje, tiposPersonajes, poderAtaque, defensa);
    }


    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Golpe de ");
        enemigo.recibirDanio(getPoderAtaque());
    }

    @Override
    public void habilidades(Personaje enemigo) {

        switch (this.getTiposPersonajes()) {
            case TiposPersonajes.ORO:
                
                break;

            case TiposPersonajes.ESPADA:

                break;

            case TiposPersonajes.COPA:

                break;
            
            case TiposPersonajes.BASTO:
                System.out.println("Daño duplicado ");
                enemigo.recibirDanio((getPoderAtaque()*2));
                break;
            default:
                break;
        }

        
    }

    @Override
    public void habilidadBase(Personaje enemigo){

    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
