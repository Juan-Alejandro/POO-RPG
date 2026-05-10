package juego;

import java.util.List;
import java.util.Scanner;

import domain.enums.EstadoPersonaje;
import domain.enums.TiposPersonajes;
import domain.models.Orco;
import domain.models.Personaje;

public class Batalla {
    // Manejadores para las rondas y partidas
    boolean finalPartida = false;
    int ronda = 0;

    byte opcionUsuario;

    private Motor motor = new Motor();
    private Orco orco;
    private Personaje objetivo;
    // Lista de los personajes y enemigo
    private List<Personaje> personajesLista;

    // Constructor de la clase para obtener lista de personajes
    public Batalla(List<Personaje> personajesLista, Orco orco) {
        this.personajesLista = personajesLista;
        this.sistemaAtaqueOrco = new SistemaAtaqueOrco(personajesLista, this, orco);
        this.orco = orco;
    }

    Scanner skan = new Scanner(System.in);

    // Clase de orco
    SistemaAtaqueOrco sistemaAtaqueOrco;

    // Manejador de acciones para el juego principal
    void juegoPrincipal() {
        controladorRonda();
        while (!finalPartida) {
            if (comprobarDerrota()) {
                partidaTerminada(false);
                finalPartida = true;
                break;
            }

            if (comprobarVictoria()) {
                partidaTerminada(true);
                finalPartida = true;
                break;
            }
            System.out.print("\n\n" +
                    ">>---------------------------------------------<<\n" +
                    "                 R O N D A   " + ronda + "\n" +
                    ">>---------------------------------------------<<\n");

            turnoUsuario();

            if (orco.getEstadoPersonaje() != EstadoPersonaje.MUERTO)
                turnoMaquina();

        }
    }

    // Metodo para pantalla al final de la partida
    void partidaTerminada(Boolean resultados) {
        reiniciadorVida();
        if (resultados) {
            System.out.print("\n\n" +
                    "*************************************************\n" +
                    "* *\n" +
                    "* V I C T O R I A   A P L A S T A N T E     *\n" +
                    "* ¡El Orco ha sido derrotado!          *\n" +
                    "* *\n" +
                    "*************************************************\n");
        } else {
            System.out.print("\n\n" +
                    "#################################################\n" +
                    "#                                               #\n" +
                    "#                  D E R R O T A                #\n" +
                    "#            Tu equipo ha sido aniquilado...    #\n" +
                    "#                                               #\n" +
                    "#################################################\n");
        }
        preguntarReiniciar();
    }

    void preguntarReiniciar() {
        try {
            System.out.print("\n=================================================\n" +
                    "¿Deseas volver a adentrarte en la batalla?\n" +
                    "  [1] Sí, quiero la revancha.\n" +
                    "  [2] No, me retiro por hoy.\n" +
                    "=================================================\n" +
                    "Tu elección: ");
            opcionUsuario = skan.nextByte();

            if (opcionUsuario == 1) {
                System.out.println("Preparando nueva partida...");
                reiniciadorVida();
                juegoPrincipal();

            } else if (opcionUsuario == 2) {
                System.out.println("Regresando al menu principal");
                motor.menuPrincipal();
            } else {

                System.out.println("Opcion no valida. Por favor ingresa 1 o 2.");
                preguntarReiniciar();
            }
        } catch (Exception e) {
            System.out.println("Opcion no valida ");
            skan.nextLine();
            preguntarReiniciar();
        }
    }

    // Al terminar la ronda, reinicia la vida de todos los personajes
    void reiniciadorVida() {
        for (Personaje p : personajesLista) {
            p.setVidaActual(p.getVidaMaxima());
            p.setEstadoPersonaje(EstadoPersonaje.VIVO);
        }
        orco.setVidaActual(orco.getVidaMaxima());
        orco.setEstadoPersonaje(EstadoPersonaje.VIVO);
    }

    // Aumenta las rondas y si termina la partida reinicia el contador de rondas
    int controladorRonda() {
        if (finalPartida) {
            return ronda = 0;
        }
        return ronda++;
    }

    // Decide de manera aleatoria lo que realizara el enemigo
    void turnoMaquina() {

        sistemaAtaqueOrco.inciarAtaque();
    }

    // Comprueba si perdio
    boolean comprobarDerrota() {
        for (Personaje p : personajesLista) {
            if (p.getEstadoPersonaje() != EstadoPersonaje.MUERTO)
                return false;
        }
        return true;
    }

    // Comprueba si gano
    boolean comprobarVictoria() {
        if (orco.getEstadoPersonaje() == EstadoPersonaje.MUERTO && orco.getVidaActual() <= 0) {
            ronda = 1;
            return true;
        }
        return false;
    }

    // selector para manejar el
    void turnoUsuario() {
        System.out.print("\n--- [ TU TURNO ] --------------------------------\n" +
                "¿Qué héroe realizará la acción?\n" +
                "  [1]   Arquero\n" +
                "  [2]   Guerrero\n" +
                "  [3]   Mago\n" +
                "  [4]   Curandero\n" +
                "-------------------------------------------------\n" +
                "Elige una opción: ");
        try {
            opcionUsuario = skan.nextByte();
            switch (opcionUsuario) {
                case 1:
                    manejadorAtaquesUsuario(personajesLista.get(0));
                    break;
                case 2:
                    manejadorAtaquesUsuario(personajesLista.get(1));
                    break;
                case 3:
                    manejadorAtaquesUsuario(personajesLista.get(2));
                    break;
                case 4:
                    manejadorAtaquesUsuario(personajesLista.get(3));
                    break;
                default:
                    System.out.println("Error: Esa opcion no existe");
                    turnoUsuario();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: Ingresa un caracter valido");
            skan.nextLine();
            turnoUsuario();
        }

    }

    // Es el detector de ataques del usuario, segun el personaje que escoja
    void manejadorAtaquesUsuario(Personaje atacante) {
        System.out.print("\n--- [ SELECCIÓN DE OBJETIVO ] -------------------\n" +
                "Aliados:\n" +
                "  [1] Arquero   [2] Guerrero   [3] Mago   [4] Curandero\n" +
                "Enemigos:\n" +
                "  [5]   ORCO (Jefe)\n" +
                "-------------------------------------------------\n" +
                "Selecciona a quién dirigir la acción: ");
        objetivo = getObjetivo();
        System.out.println("Objetivo seleccionado: " + objetivo.getNombrePersonaje());
        objetivo.recibirDanio(atacante.getPoderAtaque());
    }

    // Obtiene el objetivo al que el usuario desea afectar con su accion
    Personaje getObjetivo() {
        try {
            opcionUsuario = skan.nextByte();
            switch (opcionUsuario) {
                case 1:
                    objetivo = personajesLista.get(0);

                    break;
                case 2:
                    objetivo = personajesLista.get(1);
                    break;
                case 3:
                    objetivo = personajesLista.get(2);
                    break;
                case 4:
                    objetivo = personajesLista.get(3);
                    break;
                case 5:
                    objetivo = orco;
                    break;
                default:
                    System.out.println("Error: Objetivo no existente");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: Ingresa un caracter valido");
            skan.nextLine();
            getObjetivo();
        }
        return objetivo;
    }
}
