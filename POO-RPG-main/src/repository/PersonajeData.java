package repository;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;

public class PersonajeData {
    private final String nombrePersonaje;
    private final int vidaMaxima;
    private final ClasesPersonajes personaje;
    private EstadoPersonaje estadoPersonaje;
    private BandoPersonaje bandoPersonaje;
    private TiposPersonajes tiposPersonajes;
    private final PoderPersonajes nombrePoder;
    private HabilidadClase habilidadClase;
    private int vidaActual;
    private int poderAtaque;
    private final int defensa;

    public PersonajeData(
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

        this.nombrePersonaje = nombrePersonaje;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.bandoPersonaje = bandoPersonaje;
        this.personaje = personaje;
        this.estadoPersonaje = estadoPersonaje;
        this.tiposPersonajes = tiposPersonajes;
        this.nombrePoder = nombrePoder;
        this.habilidadClase = habilidadClase;
        this.poderAtaque = poderAtaque;
        this.defensa = defensa;
    }

    public BandoPersonaje getBandoPersonaje() {
        return bandoPersonaje;
    }

    public int getDefensa() {
        return defensa;
    }

    public EstadoPersonaje getEstadoPersonaje() {
        return estadoPersonaje;
    }

    public HabilidadClase getHabilidadClase() {
        return habilidadClase;
    }

    public ClasesPersonajes getPersonaje() {
        return personaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public ClasesPersonajes getClasesPersonajes() {
        return personaje;
    }

    public PoderPersonajes getNombrePoder() {
        return nombrePoder;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public TiposPersonajes getTiposPersonajes() {
        return tiposPersonajes;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
}
