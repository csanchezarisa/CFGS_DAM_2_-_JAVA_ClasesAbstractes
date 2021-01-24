import TipusDada.Persona.Persona;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestionaLlistes {

    private static String vehiclesJsonPath = "./people.json";
    private static String personesJsonPath;

    public static Persona[] getPersonas() throws IOException, ParseException {

        Persona[] personas = (Persona[]) new JSONParser().parse(new FileReader(GestionaLlistes.class.getResource("people.json").getPath()));

        return personas;

    }

}
