package juego;

import java.util.List;
import java.util.Scanner;

import domain.enums.EstadoPersonaje;
import domain.models.Personaje;

public class Batalla {
    // Manejadores para las rondas y partidas
    boolean finalPartida = true;
    int ronda = 1;

    byte opcionUsuario;
    boolean contrladorBucles = true;

    Personaje objetivo;

    // Lista de los personajes y enemigo
    private List<Personaje> personajesLista;


    // Constructor de la clase para obtener lista de personajes
    public Batalla(List<Personaje> personajesLista) {
        this.personajesLista = personajesLista;
    }

    Scanner skan = new Scanner(System.in);

    // Clase de orco
    SistemaAtaqueOrco sistemaAtaqueOrco;

    // Manejador de acciones para el juego principal
    void juegoPrincipal() {

        do {
            if (comprobarDerrota()) {
                partidaTerminada(false);
                finalPartida = false;
            }

            if (comprobarVictoria()) {
                partidaTerminada(true);
                finalPartida = false;
            }
            System.out.println("Numero de ronda: " + ronda);

            if ((ronda % 2) == 0)
                turnoMaquina();
            turnoUsuario();

        } while (finalPartida);
    }

    // Metodo para pantalla al final de la partida
    void partidaTerminada(Boolean resultados) {
        reiniciadorVida();
        System.out.println(resultados);
    }
    
    // Al terminar la ronda, reinicia la vida de todos los personajes
    void reiniciadorVida() {

        for (Personaje p : personajesLista) {
            p.setVidaActual(p.getVidaMaxima());
        }
    }

    // Aumenta las rondas y si termina la partida reinicia el contador de rondas
    int controladorRonda() {
        if (finalPartida) {
            return ronda = 1;
        }
        return ronda++;
    }

    // Decide de manera aleatoria lo que realizara el enemigo
    void turnoMaquina() {
        System.out.println("El orco ataca");


        controladorRonda();
        
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
        if (personajesLista.get(4).getEstadoPersonaje() == EstadoPersonaje.MUERTO) {
            ronda = 1;
            return finalPartida = true;
        }
        return finalPartida = false;
    }

    // selector para manejar el 
    void turnoUsuario() {
        do {
            try {

                opcionUsuario = skan.nextByte();
                switch (opcionUsuario) {
                    case 1:
                        manejadorAtaquesUsuario(personajesLista.get(0));
                        contrladorBucles = false;
                        break;
                    case 2:
                        manejadorAtaquesUsuario(personajesLista.get(1));
                        contrladorBucles = false;
                        break;
                    case 3:
                        manejadorAtaquesUsuario(personajesLista.get(2));
                        contrladorBucles = false;
                        break;
                    case 4:
                        manejadorAtaquesUsuario(personajesLista.get(3));
                        contrladorBucles = false;
                        break;
                    default:
                        System.out.println("Error: Esa opcion no existe");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un caracter valido");
                skan.nextLine();
            }
        } while (contrladorBucles);
        controladorRonda();
        juegoPrincipal();
    }

    // Es el detector de ataques del usuario, segun el personaje que escoja
    void manejadorAtaquesUsuario(Personaje atacante) {
        System.out.println("Usuario ataca");
        objetivo = getObjetivo();
        System.out.println("Objetivo seleccionado: " + objetivo.getNombrePersonaje());
        objetivo.recibirDanio(atacante.getPoderAtaque());
    }

    // Obtiene el objetivo al que el usuario desea afectar con su accion
    Personaje getObjetivo() {
        System.out.println("El orco el el 5");
        contrladorBucles = true;
        do {
            System.out.println("Seleccione el objetivo");
            try {
                opcionUsuario = skan.nextByte();
                switch (opcionUsuario) {
                    case 1:
                        objetivo = personajesLista.get(0);

                        contrladorBucles = false;
                        break;
                    case 2:
                        objetivo = personajesLista.get(1);
                        contrladorBucles = false;
                        break;
                    case 3:
                        objetivo = personajesLista.get(2);
                        contrladorBucles = false;
                        break;
                    case 4:
                        objetivo = personajesLista.get(3);
                        contrladorBucles = false;
                        break;
                    case 5:
                        objetivo = personajesLista.get(4);
                        contrladorBucles = false;
                        break;
                    default:
                        System.out.println("Error: Objetivo no existente");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un caracter valido");
                skan.nextLine();
            }
        } while (contrladorBucles);
        return objetivo;
    }
}
