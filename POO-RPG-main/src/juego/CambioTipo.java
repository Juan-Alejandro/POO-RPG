package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.enums.HabilidadClase;
import domain.enums.TiposPersonajes;
import domain.models.Personaje;
import domain.util.interfaces.HabilidadEspecial;

public class CambioTipo {

    private List<Personaje> listaPersonajes;
    private List<Personaje> listaProvisionalPersonajes = new ArrayList<>();
    private List<TiposPersonajes> tiposPersonajes = List.of(
            TiposPersonajes.BASTO,
            TiposPersonajes.COPA,
            TiposPersonajes.ESPADA,
            TiposPersonajes.ORO);

    private byte k, opcionUsuario, i;
    private Motor motor = new Motor();
    private Scanner skan = new Scanner(System.in);
    private Personaje objetivoCambio;

    public CambioTipo(List<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    void cambiarClase() {
        if (listaProvisionalPersonajes.isEmpty()) {
            listaProvisionalPersonajes = creadorListaProvisional();
        }

        k = 1;
        try {
            System.out.println("Escoja personaje");
            for (Personaje p : listaProvisionalPersonajes) {

                System.out.println("[" + k + "] Nombre:" +
                        p.getNombrePersonaje() +
                        "| Clase: " + p.getPersonaje() +
                        "| Tipo: " + p.getTiposPersonajes() +
                        "| Habilidad: " + p.getNombreHabilidad());
                k++;
            }

            System.out.print("Ingrese cualquier letra para volver al menu\n" + "Opcion: ");
            opcionUsuario = skan.nextByte();

            if (opcionUsuario >= 1 && opcionUsuario <= listaPersonajes.size()) {
                objetivoCambio = listaPersonajes.get(opcionUsuario - 1);
                ajusteTipo(objetivoCambio);
            } else {
                System.out.println("Opcion no existente, ingrese otra por favor");
                cambiarClase();
            }
        } catch (Exception e) {
            skan.nextLine();
            motor.menuPrincipal();
        }
        k = 1;
    }

    List<Personaje> creadorListaProvisional() {
        k = 0;
        for (Personaje p : listaPersonajes) {
            if (esAptoCambio(p)) {
                listaProvisionalPersonajes.add(listaPersonajes.get(k));

            }
            k++;

        }
        return listaProvisionalPersonajes;
    }

    boolean esAptoCambio(Personaje objevitoCambio) {
        if (objevitoCambio instanceof HabilidadEspecial) {
            return true;
        }
        return false;
    }

    void ajusteTipo(Personaje objetivoCambio) {
        i = 0;
        try {
            System.out.println("Seleccione el tipo para cambiar ");
            for (TiposPersonajes tp : tiposPersonajes) {
                System.out.println("[" + (i + 1) + "]: " + tp);
                i++;
            }
            opcionUsuario = skan.nextByte();
            opcionUsuario--; 

            realizarAjusteTipo(objetivoCambio, opcionUsuario);

            realizarAjusteHabilidadesClase(objetivoCambio, opcionUsuario);

            System.out.println("Cambio exitoso:");
            System.out.println("Nuevo Tipo: " + objetivoCambio.getTiposPersonajes());
            System.out.println("Nueva Habilidad: " + objetivoCambio.getNombreHabilidad() + "\n");

            cambiarClase();

        } catch (Exception e) {
            System.out.println("Opcion no valida, regresando...");
            skan.nextLine(); // Limpiar buffer
            cambiarClase();
        }
    }

    void realizarAjusteTipo(Personaje objetivoCambio, byte opcionUsuario) {
        objetivoCambio.setTiposPersonajes(tiposPersonajes.get(opcionUsuario));
    }

    void realizarAjusteHabilidadesClase(Personaje objetivoCambio, byte opcionUsuario) {
        TiposPersonajes tipoSeleccionado = tiposPersonajes.get(opcionUsuario);

        switch (objetivoCambio.getPersonaje()) {
            case ARQUERO:
                switch (tipoSeleccionado) {
                    case ORO:
                        objetivoCambio.setHabilidadClase(HabilidadClase.OJO_DE_HALCON);
                        break;
                    case ESPADA:
                        objetivoCambio.setHabilidadClase(HabilidadClase.RAFAGA);
                        break;
                    case COPA:
                        objetivoCambio.setHabilidadClase(HabilidadClase.ATURDIDORA);
                        break;
                    case BASTO:
                        objetivoCambio.setHabilidadClase(HabilidadClase.TRIFUERZA);
                        break;
                    default:
                        break;
                }
                break;

            case GUERRERO:
                switch (tipoSeleccionado) {
                    case ORO:
                        objetivoCambio.setHabilidadClase(HabilidadClase.DOBLEFILO);
                        break;
                    case ESPADA:
                        objetivoCambio.setHabilidadClase(HabilidadClase.DESINTERESADO);
                        break;
                    case COPA:
                        objetivoCambio.setHabilidadClase(HabilidadClase.DESESTABILIZADOR);
                        break;
                    case BASTO:
                        objetivoCambio.setHabilidadClase(HabilidadClase.FRENESI);
                        break;
                    default:
                        break;
                }
                break;

            case MAGO:
                if (tipoSeleccionado == TiposPersonajes.ORO || tipoSeleccionado == TiposPersonajes.COPA) {
                    objetivoCambio.setHabilidadClase(HabilidadClase.EXPLOSION);
                } else {
                    objetivoCambio.setHabilidadClase(HabilidadClase.AUTOCURACION);
                }
                break;
            default:
                break;
        }
    }

}
