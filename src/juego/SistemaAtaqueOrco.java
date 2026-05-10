package juego;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

        System.out.println("El orco usara su poder? ");
        if (ThreadLocalRandom.current().nextBoolean()) {
            orco.poderMagico(orco);
            return;
        }
        
        System.out.println("El orco ha decidido no usar poder magico\n ");

        System.out.println("El orco usara su habilidad?");
        if (ThreadLocalRandom.current().nextBoolean()) {
            System.out.println("Orco: Os asesinare a todos");
            for(Personaje p : personajeLista) {
                orco.usarHabilidadEspecial(p);
            }
            return;
        }

        System.out.println("El orco ha decidido no usar habilidades " + "\nEl orco realizara un ataque normal ");
        objetivo.recibirDanio(orco.getPoderAtaque());
    }

    Personaje getObjetivo() {
        int objOrco = (int) ((Math.random() * (4 - 1)) + 1);
        try {
            objetivo = personajeLista.get(objOrco);
        } catch (Exception e) {
            System.out.println("Error del sistema aleatorio");
        }
        return objetivo;
    }
}
