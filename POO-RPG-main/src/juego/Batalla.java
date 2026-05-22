package juego;

import java.util.List;
import java.util.Scanner;

import domain.enums.ClasesPersonajes;
import domain.enums.EstadoPersonaje;
import domain.enums.TipoAtaque;
import domain.models.Arquero;
import domain.models.Curandero;
import domain.models.Guerrero;
import domain.models.Mago;
import domain.models.Orco;
import domain.models.Personaje;

public class Batalla {
    // Manejadores para las rondas y partidas
    private boolean finalPartida = false;
    private int ronda = 0;
    private byte i = 0;
    private int opcionUsuario;
    private TipoAtaque tipoAtaque;

    private Motor motor = new Motor();
    private Orco orco;
    private Personaje objetivo;
    private Arquero arquero;
    private Mago mago;
    private Guerrero guerrero;
    private Curandero curandero;
    // Lista de los personajes y enemigo
    private List<Personaje> personajesLista;

    // Constructor de la clase para obtener lista de personajes
    public Batalla(List<Personaje> personajesLista, Orco orco) {
        this.personajesLista = personajesLista;
        this.sistemaAtaqueOrco = new SistemaAtaqueOrco(personajesLista, this, orco);
        this.orco = orco;

        // Se instancian las clases de los objetos para poder utilizarse a lo largo del
        // codigo sin problemas
        for (Personaje p : personajesLista) {
            if (p instanceof Arquero) {
                this.arquero = (Arquero) p;
            } else if (p instanceof Guerrero) {
                this.guerrero = (Guerrero) p;
            } else if (p instanceof Mago) {
                this.mago = (Mago) p;
            } else if (p instanceof Curandero) {
                this.curandero = (Curandero) p;
            }
        }
    }

    Scanner skan = new Scanner(System.in);

    // Clase de orco
    SistemaAtaqueOrco sistemaAtaqueOrco;

    private boolean despertadorAturdimiento = true;

    // Manejador de acciones para el juego principal
    void despertadorPersonajes() {
        if (orco.getVidaActual() > 0) {
            orco.setEstadoPersonaje(EstadoPersonaje.VIVO);
        }
        for (Personaje p : personajesLista) {
            if (p.getVidaActual() > 0)
                p.setEstadoPersonaje(EstadoPersonaje.VIVO);
        }
    }

    void juegoPrincipal() {

        while (!finalPartida) {
            guerrero.recuperarEstaminaGuerrero();
            mago.recuperarManaMago();

            // Quita el aturdimiento a los personajes en las rondas que sean multiplos de 3
            if (ronda % 3 == 0) {
                despertadorPersonajes();
            }

            controladorRonda();
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
            opcionUsuario = skan.nextInt();

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
        arquero.setFlechasActuales(arquero.getFlechasMaximas());
        guerrero.setEstaminaActual(guerrero.getEstaminaMax());
        mago.setManaActual(mago.getManaMax());
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
        if (orco.getEstadoPersonaje() == EstadoPersonaje.ATURDIDO) {
            System.out.println("El orco esta aturdido");

        } else {
            sistemaAtaqueOrco.inciarAtaque();
        }
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

    // selector para manejar elturno del usuario
    void turnoUsuario() {

        i = 0;
        System.out.print("\n--- [ TU TURNO ] --------------------------------\n" +
                "¿Qué heroe atacara?\n");
        for (Personaje p : personajesLista) {

            System.out.println("[" + (i + 1) + "] " + p.getPersonaje() +
                    " ,Tipo: " + p.getTiposPersonajes() +
                    " ,Estado: " + p.getEstadoPersonaje());
            i++;
        }
        System.out.println("Elige una opción: ");
        try {
            opcionUsuario = skan.nextInt();
            if (opcionUsuario >= 1 && opcionUsuario <= personajesLista.size()) {
                Personaje p = personajesLista.get(opcionUsuario - 1);
                if (p.getEstadoPersonaje() == EstadoPersonaje.VIVO) {
                    selectorHabilidadesOPoderes(p);
                    return;
                } else if (p.getEstadoPersonaje() == EstadoPersonaje.ATURDIDO) {
                    System.out.println(" El personaje esta aturdido seleccione otro");
                    turnoUsuario();
                } else {
                    System.out.println("El personaje esta muerto escoja otro");
                    turnoUsuario();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Ingresa un caracter valido");
            skan.nextLine();
            turnoUsuario();
        }

    }

    String obtenerDatosHeroe(Personaje p) {
        switch (p.getPersonaje()) {
            case ClasesPersonajes.ARQUERO:
                return "Flechas: "+arquero.getFlechasActuales() + "/" + arquero.getFlechasMaximas();
            case ClasesPersonajes.GUERRERO:
                return "Estamina: "+guerrero.getEstaminaActual() + "/" + guerrero.getEstaminaMax();
            case ClasesPersonajes.MAGO:
                return "Maná: " + mago.getManaActual() + "/" + mago.getManaMax();
            default:
                return "";
        }
    }

    void selectorHabilidadesOPoderes(Personaje p) {
        try {
            System.out.println("\n" +
                    "╔═════════════════════════════════════════════════╗\n" +
                    "║            M E N Ú   D E   A C C I Ó N          ║\n" +
                    "╠═════════════════════════════════════════════════╣\n" +
                    "  Héroe: " + p.getNombrePersonaje() + " (" + p.getTiposPersonajes() + ")\n" +
                    "  Estado: " + p.getEstadoPersonaje() + " | Vida: " + p.getVidaActual() + "/" + p.getVidaMaxima() +
                    "  \n" + obtenerDatosHeroe(p) + "\n" +
                    "  \n" +
                    "  \n" +
                    "  ¿Qué tipo de ataque deseas realizar?\n" +
                    "  [1] PODER       - Poder del personaje \n" +
                    "  [2] HABILIDAD   - Habilidad segun la clase \n" +
                    "  [3] NORMAL      - Ataque básico\n" +
                    "╚═════════════════════════════════════════════════╝\n" +
                    "Selección: ");
            opcionUsuario = skan.nextInt();
            switch (opcionUsuario) {
                case 1:
                    tipoAtaque = TipoAtaque.PODER;
                    if (p.getPersonaje() == ClasesPersonajes.ARQUERO) {
                        p.poderMagico(p);
                        return;
                    }

                    manejadorAtaquesUsuario(p, tipoAtaque);
                    break;
                case 2:
                    tipoAtaque = TipoAtaque.HABILIDAD;
                    manejadorAtaquesUsuario(p, tipoAtaque);
                    break;
                case 3:
                    tipoAtaque = TipoAtaque.NORMAL;
                    manejadorAtaquesUsuario(p, tipoAtaque);
                    break;
                default:
                    System.out.println("Opcion no valida ");
                    selectorHabilidadesOPoderes(p);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Caracter no valido, inserte uno valido zzzzzz");
            skan.nextLine();
            selectorHabilidadesOPoderes(p);
        }
    }

    // Es el detector de ataques del usuario, segun el personaje que escoja
    void manejadorAtaquesUsuario(Personaje atacante, TipoAtaque tipoAtaque) {
        int j = 1;
        System.out.print("\n--- [ SELECCIÓN DE OBJETIVO ] -------------------\n" +
                "Aliados:\n\n");
        for (Personaje p : personajesLista) {

            System.out.print("    " + "[" + j + "]" + p.getPersonaje() + "    ");

            j++;
        }

        System.out.println("\n\nEnemigo:\n" +
                "    " + "\n[" + j + "] ORCO (Jefe)\n" +
                "-----------------------------------------------------------");

        objetivo = getObjetivo();
        System.out.println("Objetivo seleccionado: " + objetivo.getNombrePersonaje());
        switch (tipoAtaque) {
            case TipoAtaque.PODER:
                usuarioPoder(atacante, objetivo);
                break;
            case TipoAtaque.HABILIDAD:
                usuarioHabilidad(atacante, objetivo);
                break;
            case TipoAtaque.NORMAL:
                atacante.atacar(objetivo);
                break;
            default:
                break;
        }

    }

    void usuarioPoder(Personaje atacante, Personaje objetivo) {
        atacante.poderMagico(objetivo);
    }

    void usuarioHabilidad(Personaje atacante, Personaje objetivo) {
        switch (atacante.getPersonaje()) {
            case ClasesPersonajes.ARQUERO:
                arquero.usarHabilidadEspecial(objetivo, atacante.getTiposPersonajes());
                break;
            case ClasesPersonajes.GUERRERO:
                guerrero.usarHabilidadEspecial(objetivo, atacante.getTiposPersonajes());
                break;
            case ClasesPersonajes.MAGO:
                mago.usarHabilidadEspecial(objetivo, atacante.getTiposPersonajes());
                break;
            case ClasesPersonajes.CURANDERO:
                curandero.curar(objetivo);
                break;

            default:
                break;
        }
    }

    // Obtiene el objetivo al que el usuario desea afectar con su accion
    Personaje getObjetivo() {
        try {
            opcionUsuario = skan.nextInt();
            if (opcionUsuario >= 0 && opcionUsuario <= personajesLista.size()) {
                objetivo = personajesLista.get(opcionUsuario - 1);
            } else if (opcionUsuario == personajesLista.size() + 1) {
                objetivo = orco;
            } else {
                System.out.println("Error: Objetivo no existente");
                getObjetivo();
            }
        } catch (Exception e) {
            System.out.println("Error: Ingresa un caracter valido");
            skan.nextLine();
            getObjetivo();
        }
        return objetivo;
    }
}
