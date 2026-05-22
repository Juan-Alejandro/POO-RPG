package repository;

import domain.enums.BandoPersonaje;
import domain.models.Personaje;

public class PersonajeFactory {
    public static Personaje crearDesdeData(
        final PersonajeData data
    ){
        final BandoPersonaje bandoPersonaje = BandoPersonaje.valueOf(bandoPersonaje.getBandoPersonaje());

        switch (bandoPersonaje) {
            case ALIADO:
                return new Personaje(bandoPersonaje.getBandoPersonaje());
                break;
            case ENEMIGO:
                return new Personaje(bandoPersonaje.getBandoPersonaje());
            break;
            default:
                return new Personaje("Alam");
                break;
        }
        
        
    }
}
