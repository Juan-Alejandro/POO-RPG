package juego;

import java.util.Scanner;

import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.models.Arquero;
import domain.models.Orco;

import java.util.Scanner;

public class Motor {

    // Instancias de clases
    static PantallasAscii pantallasAscii = new PantallasAscii();
    static JuegoPrincipal juegoPrincipal = new JuegoPrincipal();

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
            10,
            30,
            20,
            20);

    static Orco orco = new Orco(
        "Orco", 
        50, 
        50, 
        ClasesPersonajes.ORCO, 
        EstadoPersonaje.VIVO,
        30, 
        9);

    public static void main(String[] args) {
        //pantallaPrincipal();


        arquero.habilidadEspecial(orco);


        System.out.println(orco);

        System.out.println(arquero);
    }

    /*

    static void pantallaPrincipal() {
        do {
            pantallasAscii.pantallaMenu();
            opcionUsuario = skan.nextByte();

            switch (opcionUsuario) {
                case 1:

                    terminadorBucles = false;
                    break;
                case 2:

                    terminadorBucles = false;
                    break;
                case 3:

                    terminadorBucles = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    terminadorBucles = true;
                    break;
            }
        } while (terminadorBucles);

    }*/

}
