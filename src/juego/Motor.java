package juego;

import java.util.ArrayList;
import java.util.List;

import domain.enums.EstadoPersonaje;
import domain.models.Arquero;
import domain.models.Curandero;
import domain.models.Guerrero;
import domain.models.Mago;
import domain.models.Orco;
import domain.models.Personaje;

public class Motor {

    // Objetos de los personajes
    static Arquero arquero = new Arquero("Arquero",
            100,
            100,
            null,
            EstadoPersonaje.VIVO,
            null,
            null,
            500,
            0,
            0,
            0);

    static Guerrero guerrero = new Guerrero("Guerrero",
            0,
            0,
            null,
            null,
            null,
            null,
            0,
            0);

    static Mago mago = new Mago("Mago",
            0,
            0,
            null,
            null,
            null,
            null,
            0,
            0);

    static Curandero curandero = new Curandero("Curandero",
            0,
            0,
            null,
            null,
            null,
            null,
            0,
            0,
            0);

    static Orco orco = new Orco("Orco",
            1000,
            1000,
            null,
            EstadoPersonaje.VIVO,
            null,
            null,
            0,
            0);

    static List<Personaje> person = new ArrayList<>();

    static Batalla batalla = new Batalla(person);
    static SistemaAtaqueOrco sistemaAtaqueOrco = new SistemaAtaqueOrco(person);


    public static void main(String[] args) {

        anadirPersonajes();
        batalla.juegoPrincipal();


    }




    static List<Personaje> anadirPersonajes() {
        // Aqui se aniaden los personajes a una lista

        person.add(arquero); // 0 
        person.add(guerrero); // 1
        person.add(mago); // 2
        person.add(curandero); // 3
        person.add(orco); // 4

        return person;
    }
}
