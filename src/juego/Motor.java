package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.HabilidadClase;
import domain.enums.PoderPersonajes;
import domain.enums.TiposPersonajes;
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
            ClasesPersonajes.ARQUERO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.BASTO,
            PoderPersonajes.RAFAGA,
            HabilidadClase.TRIFUERZA,
            500,
            100);

    static Guerrero guerrero = new Guerrero("Guerrero",
            100,
            100,
            ClasesPersonajes.GUERRERO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.BASTO,
            PoderPersonajes.DESESPERACION,
            HabilidadClase.FRENESI,
            500,
            100);

    static Mago mago = new Mago("Mago",
            100,
            100,
            ClasesPersonajes.MAGO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.BASTO,
            PoderPersonajes.REGALO,
            HabilidadClase.AUTOCURACION,
            500,
            100);

    static Curandero curandero = new Curandero("Curandero",
            100,
            100,
            ClasesPersonajes.CURANDERO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.CURANDERO,
            PoderPersonajes.SACRIFICIO,
            HabilidadClase.CURACION,
            500,
            100,
            200);

    static Orco orco = new Orco("Orco",
            100,
            100,
            ClasesPersonajes.ORCO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ENEMIGO,
            TiposPersonajes.BASTO,
            PoderPersonajes.KILL_EM_ALL,
            HabilidadClase.SEEK_AND_DESTROY,
            500,
            400);

    static List<Personaje> person = new ArrayList<>();

    static Batalla batalla = new Batalla(person, orco);

    static MirarEstadisticas mirarEstadisticas = new MirarEstadisticas(person);

    static CambioTipo cambioClase = new CambioTipo(person);

    Scanner skan = new Scanner(System.in);
    byte opcionUsuario;

    public static void main(String[] args) {
        Motor motor = new Motor();

        motor.menuPrincipal();

        

    }

    void menuPrincipal() {
        if(person.isEmpty()) {
            anadirPersonajes();
        }

        try {
            System.out.print("\n\n" +
                    "=================================================\n" +
                    "||                                             ||\n" +
                    "||          B R I S C A   P E G E:             ||\n" +
                    "||                                             ||\n" +
                    "=================================================\n" +
                    "||                                             ||\n" +
                    "||  MENÚ PRINCIPAL                             ||\n" +
                    "||                                             ||\n" +
                    "||  [1] Jugar                                  ||\n" +
                    "||  [2] Ver estadisticas                       ||\n" +
                    "||  [3] Modificar clases                       ||\n" +
                    "||  [0] Cerrar juego                           ||\n" +
                    "||                                             ||\n" +
                    "=================================================\n" +
                    "Elige una opción: ");
            opcionUsuario = skan.nextByte();
            switch (opcionUsuario) {
                case 0: 
                    System.out.println("Gracias por jugar :D xd");
                    break;
                case 1:
                    batalla.juegoPrincipal();
                    break;
                case 2:
                    mirarEstadisticas.stats();
                    break;
                case 3:
                    cambioClase.cambiarClase();
                    break;
                default:
                    System.out.println("Opcion no disponible ");
                    menuPrincipal();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Caracter no valido, ingrese uno correcto");
            skan.nextLine();
            menuPrincipal();
        }

    }



    static List<Personaje> anadirPersonajes() {
        // Aqui se aniaden los personajes a una lista

        person.add(arquero); // 0
        person.add(guerrero); // 1
        person.add(mago); // 2
        person.add(curandero); // 3

        return person;
    }
}
