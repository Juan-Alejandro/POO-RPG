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
        System.out.println("Orcotaque ");
        enemigo.recibirDanio(getPoderAtaque());
        
    }




    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {
        
    }

    @Override 
    public String toString(){
        return super.toString() +
            "\n\n";
    }
}
