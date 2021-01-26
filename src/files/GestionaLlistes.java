package files;

import TipusDada.DataClass;
import TipusDada.Vehicle.Aeri;
import TipusDada.Vehicle.Maritim;
import TipusDada.Vehicle.Terrestre;
import TipusDada.Vehicle.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import TipusDada.Persona.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionaLlistes {

    private static String vehiclesJsonPath = GestionaLlistes.class.getResource("vehicles.json").getPath();
    private static String personesJsonPath = GestionaLlistes.class.getResource("people.json").getPath();

    /** Crea un arraylist de persones
     * @return ArrayList de persones */
    public static ArrayList<Persona> getPersonas() throws IOException, ParseException {

        // Lectura del fitxer i parse a JSON
        Object obj = new JSONParser().parse(new FileReader(personesJsonPath));
        JSONArray jsonArray = (JSONArray) obj;

        // Creació de l'arraylist de Persones
        ArrayList<Persona> personas = new ArrayList<>();

        // Recorre l'array JSON llegit, amb el contingut de les persones.
        // Va creant persones i afegint-les a l'arraylist
        for (Object object:
             jsonArray) {

            // Es converteix d'Objecte a JSONObject
            JSONObject personaJson = (JSONObject) object;

            // Pasa a JSON el camp data, per poder recuperar els valors
            JSONObject dataJson = (JSONObject) personaJson.get("data");

            // Amb les dades del dataJson, es crea un objecte del tipus DataClass
            DataClass data = new DataClass(
                    Integer.parseInt(dataJson.get("dia").toString()),
                    Integer.parseInt(dataJson.get("mes").toString()),
                    Integer.parseInt(dataJson.get("any").toString())
            );

            // Crea la persona i l'afegeix a l'ArrayList
            personas.add(new Persona(
                    (String) personaJson.get("nif").toString(),
                    personaJson.get("nom").toString(),
                    data,
                    personaJson.get("especialitatVehicle").toString().charAt(0),
                    false
                    ));
        }

        return personas;

    }

    /** Llegeix el fitxer JSON de vehicles i en retorna un ArrayList d'objectes
     * @return ArrayList de vehicles */
    public static ArrayList<Vehicle> getVehicles() throws IOException, ParseException {

        // Lectura del fitxer i parse a JSON
        Object obj = new JSONParser().parse(new FileReader(vehiclesJsonPath));
        JSONObject jsonObject = (JSONObject) obj;

        // Creació de l'arraylist de Vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // S'obtenen els vehicles Marítims i es passen a JSONArray
        JSONArray jsonArray = (JSONArray) jsonObject.get("maritims");

        // Es recorre l'array amb els vehicles marítims
        for (Object object:
             jsonArray) {

            // Es passa l'element a tipus JSON
            JSONObject vehicleJSON = (JSONObject) object;

            // Es recupera la data de l'element i es passa a JSON per poder tractar-la
            JSONObject dataJson =  (JSONObject) vehicleJSON.get("data");

            // Amb les dades recuperades es crea una data del tipus personalitzada
            DataClass data = new DataClass(
                    Integer.parseInt(dataJson.get("dia").toString()),
                    Integer.parseInt(dataJson.get("mes").toString()),
                    Integer.parseInt(dataJson.get("any").toString())
            );

            // Es crea un vehicle del tipus Marítim i s'afageix a l'ArrayList de vehicles
            vehicles.add(new Maritim(
                    Double.parseDouble(vehicleJSON.get("consumMinim").toString()),
                    Double.parseDouble(vehicleJSON.get("carregaActual").toString()),
                    Double.parseDouble(vehicleJSON.get("capacitatMaxima").toString()),
                    Double.parseDouble(vehicleJSON.get("consum").toString()),
                    vehicleJSON.get("tipusVehicle").toString().charAt(0),
                    vehicleJSON.get("identificador").toString(),
                    Double.parseDouble(vehicleJSON.get("velocitatMitja").toString()),
                    "",
                    Integer.parseInt(vehicleJSON.get("eslora").toString()),
                    Integer.parseInt(vehicleJSON.get("manega").toString()),
                    Integer.parseInt(vehicleJSON.get("anyFlotacio").toString()),
                    data
            ));
        }

        // Es recuperen els vehicles terrestres i es pasen a JSONArray
        jsonArray = (JSONArray) jsonObject.get("terrestres");

        for (Object object:
                jsonArray) {

            // Es passa l'element a tipus JSON per poder treballar amb ell
            JSONObject vehicleJSON = (JSONObject) object;

            // Es crea un vehicle del tipus Terrestre i s'afegeix a la llista
            vehicles.add(new Terrestre(
                    Double.parseDouble(vehicleJSON.get("consumMinim").toString()),
                    Double.parseDouble(vehicleJSON.get("carregaActual").toString()),
                    Double.parseDouble(vehicleJSON.get("capacitatMaxima").toString()),
                    Double.parseDouble(vehicleJSON.get("consum").toString()),
                    vehicleJSON.get("tipusVehicle").toString().charAt(0),
                    vehicleJSON.get("identificador").toString(),
                    Double.parseDouble(vehicleJSON.get("velocitatMitja").toString()),
                    "",
                    Integer.parseInt(vehicleJSON.get("numeroCavalls").toString()),
                    Integer.parseInt(vehicleJSON.get("numeroAveries").toString()),
                    Integer.parseInt(vehicleJSON.get("costAveries").toString())
            ));

        }

        // Es recuperen els vehicles aeris i es passen a JSONArray
        jsonArray = (JSONArray) jsonObject.get("aeris");

        for (Object object:
             jsonArray) {

            // Es passa l'element a tipus JSON per poder treballar amb ell
            JSONObject vehicleJSON = (JSONObject) object;

            // Es crea un vehicle de la clase Aeri i s'afageix al llistat de vehicles
            vehicles.add(new Aeri(
                    Double.parseDouble(vehicleJSON.get("consumMinim").toString()),
                    Double.parseDouble(vehicleJSON.get("carregaActual").toString()),
                    Double.parseDouble(vehicleJSON.get("capacitatMaxima").toString()),
                    Double.parseDouble(vehicleJSON.get("consum").toString()),
                    vehicleJSON.get("tipusVehicle").toString().charAt(0),
                    vehicleJSON.get("identificador").toString(),
                    Double.parseDouble(vehicleJSON.get("velocitatMitja").toString()),
                    "",
                    Integer.parseInt(vehicleJSON.get("numeroMotors").toString()),
                    Integer.parseInt(vehicleJSON.get("tempsFuncionament").toString())
            ));
        }

        // Es retorna el llistat de vehicles
        return vehicles;
    }

    public static void mostrarInformacioVehicles(ArrayList<Vehicle> vehicles) throws InterruptedException {
        for (Vehicle vehicle:
             vehicles) {
            vehicle.mostrarInformacio();
            Thread.sleep(1000);
        }
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

            System.out.println("Prem 'Q' per sortir, una altre tecla per continuar");
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

    /** Permet crear el fitxer json de vehicles */
    public static void crearVehicles() {

        boolean sortir = false;
        JSONObject vehicles = new JSONObject();
        JSONArray maritims = new JSONArray();
        JSONArray aeris = new JSONArray();
        JSONArray terrestre = new JSONArray();

        do {
            char seleccio;
            Scanner teclat = new Scanner(System.in);

            System.out.println("Quin tipus de vehicle vols crear?");
            System.out.println(" M - Martítim");
            System.out.println(" A - Aeri");
            System.out.println(" T - Terrestre");
            System.out.println(" Q - Sortir");

            try {
                seleccio = teclat.next().toLowerCase().charAt(0);
            }
            catch (Exception e) {
                seleccio = 'q';
            }

            switch (seleccio) {
                case 'm':
                    maritims.add(crearMaritim());
                    break;

                case 'a':
                    aeris.add(crearAeri());
                    break;

                case 't':
                    terrestre.add(crearTerrestre());
                    break;

                case 'q':
                    sortir = true;
                    break;
            }

        }
        while (!sortir);

        vehicles.put("maritims", maritims);
        vehicles.put("aeris", aeris);
        vehicles.put("terrestres", terrestre);

        try (FileWriter file = new FileWriter(vehiclesJsonPath, false)) {
            file.write(vehicles.toJSONString());
            System.out.println("Fitxer creat. El trobaras a " + vehiclesJsonPath);
        }
        catch (Exception e) {
            System.out.println("No s'ha pogut crear el fitxer...");
            System.out.println(e);
        }

    }

    /** Permet crear JSON amb estructura de vehicle marítim */
    private static JSONObject crearMaritim() {
        JSONObject jsonObject = new JSONObject();

        double consumMinim;
        double carregaActual;
        double capacitatMaxima;
        double consum;
        String tipusVehicle = "m";
        String identificador;
        double velocitatMitja;
        int eslora;
        int manega;
        int anyFlotacio;
        int dia;
        int mes;
        int any;

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix l'identificador del vehicle");
        try {
            identificador = teclat.next();
        }
        catch (Exception e) {
            identificador = "Prova";
        }

        System.out.println("Introdueix el consum mínim");
        try {
            consumMinim = teclat.nextDouble();
        }
        catch (Exception e) {
            consumMinim = 10;
        }

        System.out.println("Introdueix el consum:");
        try {
            consum = teclat.nextDouble();
        }
        catch (Exception e) {
            consum = 10;
        }

        System.out.println("Introdueix la càrrega actual:");
        try {
            carregaActual = teclat.nextDouble();
        }
        catch (Exception e) {
            carregaActual = 10;
        }

        System.out.println("Introdueix la capacitat màxima:");
        try {
            capacitatMaxima = teclat.nextDouble();
        }
        catch (Exception e) {
            capacitatMaxima = 10;
        }

        System.out.println("Introdueix la velocitat mitja:");
        try {
            velocitatMitja = teclat.nextDouble();
        }
        catch (Exception e) {
            velocitatMitja = 10;
        }

        System.out.println("Introdueix l'eslora:");
        try {
            eslora = teclat.nextInt();
        }
        catch (Exception e) {
            eslora = 10;
        }

        System.out.println("Introdueix la mànega");
        try {
            manega = teclat.nextInt();
        }
        catch (Exception e) {
            manega = 10;
        }

        System.out.println("Any de flotació:");
        try {
            anyFlotacio = teclat.nextInt();
        }
        catch (Exception e) {
            anyFlotacio = 1000;
        }

        System.out.println("Creant la data...");
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

        System.out.println("Introdueix l'any:");
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

        jsonObject.put("identificador", identificador);
        jsonObject.put("tipusVehicle", tipusVehicle);
        jsonObject.put("consumMinim", consumMinim);
        jsonObject.put("carregaActual", carregaActual);
        jsonObject.put("capacitatMaxima", capacitatMaxima);
        jsonObject.put("consum", consum);
        jsonObject.put("velocitatMitja", velocitatMitja);
        jsonObject.put("identificadorTripulant", "");
        jsonObject.put("eslora", eslora);
        jsonObject.put("manega", manega);
        jsonObject.put("anyFlotacio", anyFlotacio);
        jsonObject.put("data", data);

        return jsonObject;
    }

    /** Permet crear JSON amb estructura de vehicle aeri */
    private static JSONObject crearAeri() {
        JSONObject jsonObject = new JSONObject();

        double consumMinim;
        double carregaActual;
        double capacitatMaxima;
        double consum;
        String tipusVehicle = "a";
        String identificador;
        double velocitatMitja;
        int numeroMotors;
        int tempsFuncionament;

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix l'identificador del vehicle");
        try {
            identificador = teclat.next();
        }
        catch (Exception e) {
            identificador = "Prova";
        }

        System.out.println("Introdueix el consum mínim");
        try {
            consumMinim = teclat.nextDouble();
        }
        catch (Exception e) {
            consumMinim = 10;
        }

        System.out.println("Introdueix el consum:");
        try {
            consum = teclat.nextDouble();
        }
        catch (Exception e) {
            consum = 10;
        }

        System.out.println("Introdueix la càrrega actual:");
        try {
            carregaActual = teclat.nextDouble();
        }
        catch (Exception e) {
            carregaActual = 10;
        }

        System.out.println("Introdueix la capacitat màxima:");
        try {
            capacitatMaxima = teclat.nextDouble();
        }
        catch (Exception e) {
            capacitatMaxima = 10;
        }

        System.out.println("Introdueix la velocitat mitja:");
        try {
            velocitatMitja = teclat.nextDouble();
        }
        catch (Exception e) {
            velocitatMitja = 10;
        }

        System.out.println("Introdueix el número de motors:");
        try {
            numeroMotors = teclat.nextInt();
        }
        catch (Exception e) {
            numeroMotors = 10;
        }

        System.out.println("Introdueix el temps de funcionament:");
        try {
            tempsFuncionament = teclat.nextInt();
        }
        catch (Exception e) {
            tempsFuncionament = 10;
        }

        jsonObject.put("identificador", identificador);
        jsonObject.put("tipusVehicle", tipusVehicle);
        jsonObject.put("consumMinim", consumMinim);
        jsonObject.put("carregaActual", carregaActual);
        jsonObject.put("capacitatMaxima", capacitatMaxima);
        jsonObject.put("consum", consum);
        jsonObject.put("velocitatMitja", velocitatMitja);
        jsonObject.put("identificadorTripulant", "");
        jsonObject.put("numeroMotors", numeroMotors);
        jsonObject.put("tempsFuncionament", tempsFuncionament);

        return jsonObject;
    }

    /** Permet crear JSON amb estructura de vehicle terrestre */
    private static JSONObject crearTerrestre() {
        JSONObject jsonObject = new JSONObject();

        double consumMinim;
        double carregaActual;
        double capacitatMaxima;
        double consum;
        String tipusVehicle = "t";
        String identificador;
        double velocitatMitja;
        int numeroCavalls;
        int numeroAveries;
        int costAveries;

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix l'identificador del vehicle");
        try {
            identificador = teclat.next();
        }
        catch (Exception e) {
            identificador = "Prova";
        }

        System.out.println("Introdueix el consum mínim");
        try {
            consumMinim = teclat.nextDouble();
        }
        catch (Exception e) {
            consumMinim = 10;
        }

        System.out.println("Introdueix el consum:");
        try {
            consum = teclat.nextDouble();
        }
        catch (Exception e) {
            consum = 10;
        }

        System.out.println("Introdueix la càrrega actual:");
        try {
            carregaActual = teclat.nextDouble();
        }
        catch (Exception e) {
            carregaActual = 10;
        }

        System.out.println("Introdueix la capacitat màxima:");
        try {
            capacitatMaxima = teclat.nextDouble();
        }
        catch (Exception e) {
            capacitatMaxima = 10;
        }

        System.out.println("Introdueix la velocitat mitja:");
        try {
            velocitatMitja = teclat.nextDouble();
        }
        catch (Exception e) {
            velocitatMitja = 10;
        }

        System.out.println("Introdueix el número de cavalls:");
        try {
            numeroCavalls = teclat.nextInt();
        }
        catch (Exception e) {
            numeroCavalls = 10;
        }

        System.out.println("Introdueix el número d'averies:");
        try {
            numeroAveries = teclat.nextInt();
        }
        catch (Exception e) {
            numeroAveries = 10;
        }

        System.out.println("Introdueix el cost de les averíes");
        try {
            costAveries = teclat.nextInt();
        }
        catch (Exception e) {
            costAveries = 10;
        }

        jsonObject.put("identificador", identificador);
        jsonObject.put("tipusVehicle", tipusVehicle);
        jsonObject.put("consumMinim", consumMinim);
        jsonObject.put("carregaActual", carregaActual);
        jsonObject.put("capacitatMaxima", capacitatMaxima);
        jsonObject.put("consum", consum);
        jsonObject.put("velocitatMitja", velocitatMitja);
        jsonObject.put("identificadorTripulant", "");
        jsonObject.put("numeroCavalls", numeroCavalls);
        jsonObject.put("numeroAveries", numeroAveries);
        jsonObject.put("costAveries", costAveries);

        return jsonObject;
    }

}
