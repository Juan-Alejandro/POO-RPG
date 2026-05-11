package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;

public abstract class Personaje {
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



    public Personaje(
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

            this.nombrePersonaje = nombrePersonaje;
            this.vidaMaxima = vidaMaxima;
            this.vidaActual = vidaActual;
            this.bandoPersonaje  = bandoPersonaje;
            this.personaje = personaje;
            this.estadoPersonaje = estadoPersonaje;
            this.tiposPersonajes = tiposPersonajes;
            this.nombrePoder = nombrePoder;
            this.habilidadClase = habilidadClase;
            this.poderAtaque = poderAtaque;
            this.defensa = defensa;
    }


    /*Getters */


    public int getDefensa() {
        return defensa;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public ClasesPersonajes getPersonaje() {
        return personaje;
    }

    public BandoPersonaje getBandoPersonaje() {
        return bandoPersonaje;
    }

    public EstadoPersonaje getEstadoPersonaje() {
        return estadoPersonaje;
    }

    public TiposPersonajes getTiposPersonajes() {
        return tiposPersonajes;
    }

    public HabilidadClase getNombreHabilidad() {
        return habilidadClase;
    }

    public PoderPersonajes getNombrePoder() {
        return nombrePoder;
    }

    //Setters

    public void setVidaActual(int vidaCurada) {
        this.vidaActual = vidaCurada;
    }

    public void setEstadoPersonaje(EstadoPersonaje estadoPersonaje) {
        this.estadoPersonaje = estadoPersonaje;
    }

    public void setTiposPersonajes(TiposPersonajes tiposPersonajes) {
        this.tiposPersonajes = tiposPersonajes;
    }


    public void recibirDanio(int cantidad){
        int danioRecibido = cantidad - this.defensa;

        if(danioRecibido < 0) danioRecibido = 0;

        this.vidaActual -= danioRecibido;

        if(vidaActual <= 0) {
            estadoPersonaje = EstadoPersonaje.MUERTO;
        }
        System.out.println(this.nombrePersonaje + 
            " recibio: " + 
            danioRecibido + 
            " de daño" + 
            "\nVida restante: " + 
            vidaActual +
            "\nEstado: " +
            estadoPersonaje +
            "\n");
    }

    public abstract void atacar(Personaje enemigo);
    public abstract void poderMagico(Personaje objetivo);


    // Curar vida
    public void curarVida(int cantidad) {
        this.vidaActual += cantidad;
        if(this.vidaActual > vidaMaxima) this.vidaActual = vidaMaxima;
    }

    
     @Override
    public String toString() {
        return "Personaje: " + 
        "\nNombre: " + nombrePersonaje +
        "\nVida maxima: " + vidaMaxima +
        "\nVida Actual: " + vidaActual + 
        "\nClase: " + personaje +
        "\nBando del personaje: " + bandoPersonaje +
        "\nTipo del personaje: " + tiposPersonajes +
        "\nPoder del personaje: "+ nombrePoder +
        "\nHabilidad clase: " + habilidadClase +
        "\nEstado: " + estadoPersonaje +
        "\nPoder de ataque: " + poderAtaque +
        "\nDefensa: " + defensa;
    }
}
