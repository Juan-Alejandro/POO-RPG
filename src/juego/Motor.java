package juego;

import java.util.Scanner;

import domain.enums.ClasesPersonajes;
import domain.models.Arquero;
import domain.models.Personaje;

public class Motor {

    static Motor motor = new Motor();
    static Scanner skan = new Scanner(System.in);
    public static byte opcUser;

    boolean terminadorBucle = true;

    //Objetos de los personajes
    Arquero arquero;
   
    
    ClasesPersonajes personaje;

    String nomPer;

    // Elementos arquero
    


    public static void main(String[] args) {

        motor.menuPrincipal();
    }

    public void menuPrincipal() {

        do {
            System.out.println(
                    "==============================================" +
                            "\n            Bienvenido a BriscaPege          " +
                            "\n                Menu de opciones:            " +
                            "\n            >> [1] Iniciar                   " +
                            "\n            >> [2] Como jugar                " +
                            "\n            >> [3] Creditos                  " +
                            "\n==============================================");

            opcUser = skan.nextByte();
            switch (opcUser) {
                case 1:
                    motor.inicioJuego();
                    terminadorBucle = false;
                    break;
                case 2:
                    motor.comoJugar();
                    terminadorBucle = false;
                    break;

                case 3:
                    motor.listaCreditos();
                    terminadorBucle = false;
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        } while (terminadorBucle);
    }

    public void inicioJuego() {

        do {
            System.out.println("Crea tus personajes (Minimo 2, Maximo 4)" +
                    "\nElige entre:" +
                    "\n[1]Arquero" +
                    "\n[2]Guerrero" +
                    "\n[3]Mago" +
                    "\n[4]Curandero");

            opcUser = skan.nextByte();

            switch (opcUser) {
                case 1:
                    System.out.println("Como desea nombrar a su personaje: ");
                    nomPer = skan.next();


                    arquero = new Arquero(
                        nomPer, 
                        100,
                        100,
                        personaje.ARQUERO, 
                        2,
                        20, 
                        40, 
                        40);
                    terminadorBucle = false;
                    break;
                case 2:

                    terminadorBucle = false;
                    break;
                case 3:

                    terminadorBucle = false;
                    break;
                case 4:

                    terminadorBucle = false;
                    break;
                default:
                    break;
            }
        } while (terminadorBucle);

    }




    public void comoJugar() {

    }

    public void listaCreditos() {

    }

}
