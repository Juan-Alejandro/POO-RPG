package domain.util.interfaces;

import domain.models.Personaje;

public interface HabilidadEspecial {
    void habilidades(Personaje enemigo);
    void habilidadBase(Personaje enemigo);
    void usarHabilidadEspecial(Personaje enemigo);
} 
