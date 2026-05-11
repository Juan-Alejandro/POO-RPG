package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.enums.TiposPersonajes;
import domain.models.Personaje;

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

    private MetodosMultiples metodosVerificacion = new MetodosMultiples();


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
                        " Clase: " + p.getPersonaje()
                        + " Tipo: " + p.getTiposPersonajes());
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
            if (metodosVerificacion.esAptoCambio(p)) {
                listaProvisionalPersonajes.add(listaPersonajes.get(k));

            }
            k++;

        }
        return listaProvisionalPersonajes;
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

            System.out.println(
                    "El personaje ahora pertenece a la clase: " + objetivoCambio.getTiposPersonajes() + "\n\n");
                cambiarClase();

        } catch (Exception e) {
            System.out.println("Opcion no valida, ingrese otra");
            ajusteTipo(objetivoCambio);
        }

    }

    void realizarAjusteTipo(Personaje objetivoCambio, byte opcionUsuario) {
        objetivoCambio.setTiposPersonajes(tiposPersonajes.get(opcionUsuario));
    }

}
