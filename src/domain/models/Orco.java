package domain.models;

import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;

public class Orco extends Personaje {

    public Orco(
        String nombrePersonaje,
        int vidaMaxima, 
        int vidaActual, 
        ClasesPersonajes personaje,
        EstadoPersonaje estadoPersonaje,
        int poderAtaque, 
        int defensa){
        super(nombrePersonaje, vidaMaxima, personaje,estadoPersonaje, vidaActual, poderAtaque, defensa);
    }


    @Override
    public void atacar(Personaje enemigo) {
    }
}
