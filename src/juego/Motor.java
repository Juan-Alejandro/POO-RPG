package juego;

import java.util.Scanner;

import domain.enums.BandoPersonaje;
import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.TiposPersonajes;
import domain.models.Arquero;
import domain.models.Guerrero;
import domain.models.Orco;

import java.util.Scanner;

public class Motor {

    static Scanner skan = new Scanner(System.in);

    static boolean terminadorBucles = false;

    static byte opcionUsuario;

    // Personajes

    static Arquero arquero = new Arquero(
            "As",
            50,
            50,
            ClasesPersonajes.ARQUERO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.BASTO,
            50,
            30,
            20,
            20);

    static Orco orco = new Orco(
            "Orco",
            50,
            50,
            ClasesPersonajes.ORCO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ENEMIGO,
            TiposPersonajes.ORCO,
            30,
            9);

    static Guerrero guerrero = new Guerrero(
            "Joaquin",
            100,
            100,
            ClasesPersonajes.GUERRERO,
            EstadoPersonaje.VIVO,
            BandoPersonaje.ALIADO,
            TiposPersonajes.COPA,
            20,
            20);

    public static void main(String[] args) {
        System.out.println(guerrero);

        guerrero.habilidades(orco);

        System.out.println(orco);

    }

    /*
     * 
     * static void pantallaPrincipal() {
     * do {
     * pantallasAscii.pantallaMenu();
     * opcionUsuario = skan.nextByte();
     * 
     * switch (opcionUsuario) {
     * case 1:
     * 
     * terminadorBucles = false;
     * break;
     * case 2:
     * 
     * terminadorBucles = false;
     * break;
     * case 3:
     * 
     * terminadorBucles = false;
     * break;
     * default:
     * System.out.println("Opcion no valida");
     * terminadorBucles = true;
     * break;
     * }
     * } while (terminadorBucles);
     * 
     * }
     */

}
