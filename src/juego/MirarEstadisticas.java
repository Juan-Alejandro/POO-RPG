package juego;

import java.util.List;
import java.util.Scanner;

import domain.models.Personaje;

public class MirarEstadisticas {
    private byte opcionUsuario;
    private byte mostradorStats = 1;
    Scanner skan = new Scanner(System.in);
    Motor motor = new Motor();
    private List<Personaje> person;

    public MirarEstadisticas(List<Personaje> person) {
        this.person = person;
    }

    void stats() {
        mostradorStats = 1;
        try {
            System.out.println("\n" +
                    "┌─────────────────────────────────────────────────┐\n" +
                    "│           📜 REPORTE DE ESTADÍSTICAS            │\n" +
                    "├─────────────────────────────────────────────────┤\n" +
                    "│ Selecciona un héroe para ver su estado actual:  │\n" +
                    "│                                                 │");
            for (Personaje p : person) {
                System.out.println("|");
                System.out
                        .print("│ [" + mostradorStats + "]" + p.getNombrePersonaje() + "  " + p.getPersonaje() + "\n");
                mostradorStats++;
            }
            System.out.print("|\n" +
                    "| [" + mostradorStats + "] Para regresar al menu\n" +
                    "|\n" +
                    "| Ingrese su opcion: ");

            opcionUsuario = skan.nextByte();
            if (opcionUsuario >= 0 && opcionUsuario <= person.size()) {
                System.out.println(person.get(opcionUsuario - 1));
                stats();
            } else if (opcionUsuario == mostradorStats) {
                motor.menuPrincipal();
            } else {

                System.out.println("Opcion no valida");
                stats();
            }
        } catch (Exception e) {
            System.out.println("Error: Ingrese un caracter valido");
            skan.nextLine();
            stats();
        }
    }
}
