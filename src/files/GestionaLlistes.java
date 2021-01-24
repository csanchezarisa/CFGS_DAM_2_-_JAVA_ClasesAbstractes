package files;

import TipusDada.Persona.Persona;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionaLlistes {

    private static String vehiclesJsonPath;
    private static String personesJsonPath = GestionaLlistes.class.getResource("people.json").getPath();

    public static boolean getPersonas() throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(personesJsonPath));

        JSONArray jsonArray = (JSONArray) obj;

        ArrayList<Persona> personas = new ArrayList<Persona>();

        for (Object object:
             jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            personas.add(new Persona((String) jsonObject.get("Name")));
        }

        return true;

    }

}
