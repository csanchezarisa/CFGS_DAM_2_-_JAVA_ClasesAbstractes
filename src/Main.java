import TipusDada.Persona.*;
import TipusDada.Vehicle.*;
import files.GestionaLlistes;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private ArrayList<Persona> personas;
    private ArrayList<Vehicle> vehicles;

    public static void main(String[] args) throws IOException, ParseException {

        GestionaLlistes.getPersonas();

    }
}
