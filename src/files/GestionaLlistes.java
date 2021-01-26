package files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import TipusDada.Persona.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionaLlistes {

    private static String vehiclesJsonPath;
    private static String personesJsonPath = GestionaLlistes.class.getResource("people.json").getPath();

    public static ArrayList<Persona> getPersonas() throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(personesJsonPath));

        JSONArray jsonArray = (JSONArray) obj;

        ArrayList<Persona> personas = new ArrayList<Persona>();

        for (Object object:
             jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            personas.add(new Persona(
                    (String) jsonObject.get("nom")));
        }

        return personas;

    }

    /** Va demanant les dades de les persones per després crear
     * el json people.json amb aquestes dades */
    public static void crearPersonas() {

        boolean sortir = false;
        JSONArray jsonArray = new JSONArray();

        do {

            String nom;
            String dni;
            String especialitatVehicle;
            int dia;
            int mes;
            int any;
            char seleccio;


            Scanner teclat = new Scanner(System.in);
            System.out.println("Introdueix el nom de la persona:");
            try {
                nom = teclat.nextLine();
            }
            catch (Exception e) {
                nom = "Proves";
            }

            System.out.println("Introdueix el dni:");
            try {
                dni = teclat.nextLine();
            }
            catch (Exception e) {
                dni = "12345678Z";
            }

            System.out.println("Introdueix la especialitat de la persona:");
            try {
                especialitatVehicle = String.valueOf(teclat.nextLine().toLowerCase().charAt(0));
            }
            catch (Exception e) {
                especialitatVehicle = "m";
            }


            System.out.println("Creant la data de naixement");
            System.out.println("Introdueix el dia:");
            try {
                dia = teclat.nextInt();
            }
            catch (Exception e) {
                dia = 1;
            }

            System.out.println("Introdueix el mes:");
            try {
                mes = teclat.nextInt();
            }
            catch (Exception e) {
                mes = 1;
            }

            System.out.println("Introdueix l'any");
            try {
                any = teclat.nextInt();
            }
            catch (Exception e) {
                any = 1000;
            }

            JSONObject data = new JSONObject();
            data.put("dia", dia);
            data.put("mes", mes);
            data.put("any", any);

            JSONObject persona = new JSONObject();
            persona.put("nom", nom);
            persona.put("nif", dni);
            persona.put("especialitatVehicle", especialitatVehicle);
            persona.put("data", data);

            jsonArray.add(persona);

            teclat = new Scanner(System.in);

            System.out.println("Prem 'Q' per sortir");
            seleccio = teclat.nextLine().toLowerCase().charAt(0);

            if (seleccio == 'q') sortir = true;

        }
        while (!sortir);

        try (FileWriter file = new FileWriter(personesJsonPath, false)) {
            file.write(jsonArray.toJSONString());
            System.out.println("Fitxer creat. El trobaras a " + personesJsonPath);
        }
        catch (Exception e) {
            System.out.println("No s'ha pogut crear el fitxer...");
            System.out.println(e);
        }
    }

}
