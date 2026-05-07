package domain.models;

import domain.enums.ClasesPersonajes;

public abstract class Personaje {
    private final String nombrePersonaje;
    private final int vidaMaxima;
    private final ClasesPersonajes personaje;
    private int vidaActual;
    private int poderAtaque;
    private final int defensa;



    public Personaje(
        String nombrePersonaje, 
        int vidaMaxima,
        ClasesPersonajes personaje,
        int vidaActual,
        int poderAtaque,
        int defensa){

            this.nombrePersonaje = nombrePersonaje;
            this.vidaMaxima = vidaMaxima;
            this.personaje = personaje;
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
    public abstract void recibirDanio();
    public abstract void atacar();


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
        "\nClase: " + personaje;
    }
}
