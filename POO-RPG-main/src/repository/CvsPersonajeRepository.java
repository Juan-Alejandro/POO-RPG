package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import domain.models.Personaje;

public class CvsPersonajeRepository implements PersonajeRepository{
    private final String ruta;

    public CvsPersonajeRepository(String ruta){
        this.ruta = ruta;
    }


    @Override
    public List<Personaje> getListaPersonaje() {
        
        final List<Personaje> personajes = new ArrayList<>();

        try {
            final BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;
            reader.readLine();//opcional dependiendo el caso

            while ((linea = reader.readLine()) != null) {
                final String[] columnas = linea.split(",");
                final PersonajeData data = new PersonajeData(linea, 0, 0, null, null, null, null, null, null, 0, 0);
                final Personaje personaje = PersonajeFactory.crearDesdeData(data);
                personajes.add(personaje);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Error leyendo el archiv CSV");
            System.out.println(e.getMessage());
        }
        return personajes;

        
    }

    

}
