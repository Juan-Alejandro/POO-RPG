package domain.models;

import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.util.interfaces.HabilidadEspecial;

public class Arquero extends Personaje implements HabilidadEspecial{

    private final int flechasMaximas;
    private int cantidadFlechas;

    public Arquero(
            String nombrePersonaje,
            int vidaMaxima,
            int vidaActual,
            ClasesPersonajes personaje,
            EstadoPersonaje estadoPersonaje,
            int poderAtaque,
            int defensa,
            int flechasMaximas,
            int cantidadFlechas) {
        super(nombrePersonaje, vidaMaxima, personaje,estadoPersonaje, vidaActual, poderAtaque, defensa);
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

    // Impresion de datos
    @Override
    public String toString() {
        return super.toString() +
                "\nFlechas maximas: " + flechasMaximas +
                "\nCantidad de flechas disponibles: " + cantidadFlechas;
    }

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println("Rafaga de flechas ");
        int flechasEnviadas = (int)(Math.random()*5) + 1;
        System.out.println(flechasEnviadas);
        enemigo.recibirDanio(getPoderAtaque()*flechasEnviadas);

        this.cantidadFlechas -= flechasEnviadas;
        
    }

}
