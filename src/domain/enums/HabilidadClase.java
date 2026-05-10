package domain.enums;

public enum HabilidadClase {
    // Arquero
        // ORO
    OJO_DE_HALCON, // 50% de probabilidad de atacar ignorando la defensa del enemigo, si falla no
                   // hara daño
        // ESPADA
    RAFAGA, // 20% de activacion , lanza una rafaga de flechas multiplicando su daño base
            // por la cantidad de flechas (max 5 flechas)
        // COPA
    ATURDIDORA, // 50% de probabilidad de aturdir al enemigo
        // BASTO
    TRIFUERZA, // 70% de probabilidad de disparar 3 flechas y hacer el 75% del daño base por
               // cada flecha ((dB * .75) * 3)

    // Guerrero
        // ORO
    DOBLEFILO, // 40% de probabilidad a acertar triple de daño 60% a hacerse daño a si mismo
               // "50% del daño base"
        // ESPADA
    DESINTERESADO, // 30% de probabilidad de hacer 300% de daño pero se pierde el 10% de su vida
                   // actual
        // COPA
    DESESTABILIZADOR, // 70% de aturdir al enemigo pero tambien se aturde a si mismo
        // BASTO
    FRENESI, // Mientras mas dañado este mas daño inflingira (ab + (VM - VA))

    // Mago
        // ORO Y COPA
    EXPLOSION, // Multiplica su daño entre 1-5 y recibe la mitad del daño total
        // ESPADA Y BASTO
    AUTOCURACION, // 40% de probabilidad de que golpea y cura la misma vida que quito al enemigo

    // Curandero
    CURACION,

    // Orco
    SEEK_AND_DESTROY // 50% de activacion, hace 1000 puntos de daño
}
