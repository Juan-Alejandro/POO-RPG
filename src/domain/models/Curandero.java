package domain.models;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;
import domain.util.interfaces.Curable;

public class Curandero extends Personaje implements Curable {

    private final int puntosCuracion;

    public Curandero(String nombrePersonaje,
            int vidaMaxima,
            int vidaActual,
            ClasesPersonajes personaje,
            EstadoPersonaje estadoPersonaje,
            BandoPersonaje bandoPersonaje,
            TiposPersonajes tiposPersonajes,
            PoderPersonajes nombrePoder,
            HabilidadClase habilidadClase,
            int poderAtaque,
            int defensa,
            int puntosCuracion) {
        super(nombrePersonaje, 
            vidaMaxima, 
            vidaActual, 
            personaje, 
            estadoPersonaje, 
            bandoPersonaje, 
            tiposPersonajes,
            nombrePoder,
            habilidadClase,
            poderAtaque,
            defensa);

        this.puntosCuracion = puntosCuracion;
    }

    public int getPuntosCuracion() {
        return puntosCuracion;
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Golpe de angel");

        enemigo.recibirDanio(getPoderAtaque());
    }

    @Override
    public void curar(Personaje aliado) {
        aliado.setVidaActual(aliado.getVidaActual() + puntosCuracion);
    }

    @Override
    public void poderMagico(Personaje objetivo) {
        System.out.println("Que mi muerte sea tu motivación");
        objetivo.setVidaActual(objetivo.getVidaMaxima());
        System.out.println(objetivo.getPersonaje() + " ha sido curado en un 100%");

        setEstadoPersonaje(EstadoPersonaje.MUERTO);
        setVidaActual(0);

        System.out.println("\nEstadisticas del curandero: " +
                    "\nVida: " + getVidaActual() + 
                    "\nEstado: " + getEstadoPersonaje());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCapacidad de curacion: " + puntosCuracion + "\n";
    }

}
