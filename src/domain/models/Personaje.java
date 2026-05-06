package domain.models;

public abstract class Personaje {
    private final String nombrePersonaje;
    private final int vidaMaxima;
    private int vidaActual;
    private int poderAtaque;
    private final int defensa;



    public Personaje(
        String nombrePersonaje, 
        int vidaMaxima,
        int vidaActual,
        int poderAtaque,
        int defensa){

            this.nombrePersonaje = nombrePersonaje;
            this.vidaMaxima = vidaMaxima;
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
        return "Personaje:"
    }
}
