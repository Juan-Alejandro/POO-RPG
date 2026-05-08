package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.HabilidadEspecial;

public class Arquero extends Personaje implements HabilidadEspecial {

    private final int flechasMaximas;
    private int cantidadFlechas;

    public Arquero(
            String nombrePersonaje,
            int vidaMaxima,
            int vidaActual,
            ClasesPersonajes personaje,
            EstadoPersonaje estadoPersonaje,
            BandoPersonaje bandoPersonaje,
            TiposPersonajes tiposPersonajes,
            int poderAtaque,
            int defensa,
            int flechasMaximas,
            int cantidadFlechas) {
        super(nombrePersonaje, vidaMaxima, vidaActual, personaje, estadoPersonaje, bandoPersonaje, tiposPersonajes,
                poderAtaque, defensa);
        this.flechasMaximas = flechasMaximas;
        this.cantidadFlechas = cantidadFlechas;
    }

    public int getFlechasMaximas() {
        return flechasMaximas;
    }

    public int getCantidadFlechas() {
        return cantidadFlechas;
    }

    public void restarFlechas() {
        this.cantidadFlechas -= 1;
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Flecha disparada\n");

        enemigo.recibirDanio(getPoderAtaque());
        restarFlechas();
    }

    @Override
    public void habilidades(Personaje enemigo) {

        switch (this.getTiposPersonajes()) {
            case TiposPersonajes.ORO:

                break;

            case TiposPersonajes.ESPADA:
                System.out.println("Rafaga de flechas ");
                int flechasEnviadas = (int) (Math.random() * 5) + 1;
                System.out.println(flechasEnviadas);
                enemigo.recibirDanio(getPoderAtaque() * flechasEnviadas);

                this.cantidadFlechas -= flechasEnviadas;
                break;

            case TiposPersonajes.COPA:

                break;

            case TiposPersonajes.BASTO:

                break;
            default:
                break;
        }

    }

    @Override
    public void habilidadBase(Personaje enemigo) {

    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

    }


    // Impresion de datos
    @Override
    public String toString() {
        return super.toString() +
                "\nFlechas maximas: " + flechasMaximas +
                "\nCantidad de flechas disponibles: " + cantidadFlechas;
    }

}
