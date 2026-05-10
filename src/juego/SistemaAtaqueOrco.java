package juego;

import java.util.List;

import domain.models.Orco;
import domain.models.Personaje;

public class SistemaAtaqueOrco {

    // Lista de personajes
    private List<Personaje> personajeLista;
    private Orco orco;
    private Personaje objetivo;
    private Batalla batalla;

    public SistemaAtaqueOrco(List<Personaje> personajeLista, Batalla batalla, Orco orco) {
        this.personajeLista = personajeLista;
        this.batalla = batalla;
        this.orco = orco;
    }

    void inciarAtaque() {
        System.out.print("\n\n" +
                "=================================================\n" +
                "⚠️  ¡EL ORCO PREPARA SU ATAQUE!  ⚠️\n" +
                "=================================================\n");
        objetivo = getObjetivo();

        System.out.println("El orco usara alguna habilidad/poder? ");
        if (usarPoder()) {
            usoPoderes(objetivo);
            return;
        }

        System.out.println("El orco ha decidido no usar habilidades " + "\nEl orco realizara un ataque normal ");
        objetivo.recibirDanio(orco.getPoderAtaque());
    }

    void usoPoderes(Personaje objetivo) {
        if (usarPoder()) {
            orco.poderMagico(orco);
            return;
        }
        orco.usarHabilidadEspecial(objetivo);
    }

    boolean usarPoder() {
        if (((int) (Math.random() * (2 - 1)) + 1) == 2) {
            return true;
        }
        return false;
    }

    Personaje getObjetivo() {
        switch ((int) ((Math.random() * (4 - 1)) + 1)) {
            case 1:
                objetivo = personajeLista.get(0);
                break;
            case 2:
                objetivo = personajeLista.get(1);
                break;
            case 3:
                objetivo = personajeLista.get(2);
                break;
            case 4:
                objetivo = personajeLista.get(3);
                break;
            default:
                break;
        }
        return objetivo;
    }

    void ataqueGuerrero() {

    }

    void ataqueArquero() {

    }

    void ataqueMago() {

    }

    void ataqueCurandero() {

    }
}
