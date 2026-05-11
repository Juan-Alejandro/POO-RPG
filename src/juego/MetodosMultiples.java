package juego;

import domain.models.Personaje;
import domain.util.interfaces.HabilidadEspecial;

public class MetodosMultiples {
    boolean esAptoCambio(Personaje objevitoCambio) {
        if (objevitoCambio instanceof HabilidadEspecial) {
            return true;
        }
        return false;
    }

    
}
