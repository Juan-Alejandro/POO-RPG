package domain.models;

import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;

public abstract class Personaje {
    private final String nombrePersonaje;
    private final int vidaMaxima;
    private final ClasesPersonajes personaje;
    private EstadoPersonaje estadoPersonaje;
    private int vidaActual;
    private int poderAtaque;
    private final int defensa;



    public Personaje(
        String nombrePersonaje, 
        int vidaMaxima,
        ClasesPersonajes personaje,
        EstadoPersonaje estadoPersonaje,
        int vidaActual,
        int poderAtaque,
        int defensa){

            this.nombrePersonaje = nombrePersonaje;
            this.vidaMaxima = vidaMaxima;
            this.personaje = personaje;
            this.estadoPersonaje = estadoPersonaje;
            this.vidaActual = vidaActual;
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

    /*Abstracts */
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


    // Curar vida
    public void curarVida() {

    }

    
    // Estado del personaje 
    public void estatusVida() {

    }



    // Impresion de estadisticas
    public void mostrarStats() {
        
    }


     @Override
    public String toString() {
        return "Personaje: " + 
        "\nNombre: " + nombrePersonaje +
        "\nVida maxima: " + vidaMaxima +
        "\nVida Actual: " + vidaActual + 
        "\nClase: " + personaje +
        "\nEstado: " + estadoPersonaje +
        "\nPoder de ataque: " + poderAtaque +
        "\nDefensa: " + defensa +
        "\n";
    }
}
