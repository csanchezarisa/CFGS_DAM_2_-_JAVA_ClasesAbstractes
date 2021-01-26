package files;

import TipusDada.DataClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import TipusDada.Persona.*;

import javax.swing.text.Style;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionaLlistes {

    private static String vehiclesJsonPath = GestionaLlistes.class.getResource("vehicles.json").getPath();
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

    public static void crearVehicles() {

        boolean sortir = false;
        JSONArray vehicles = new JSONArray();
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
                    terrestre.add(crearAeri());
                    break;

                case 'q':
                    sortir = true;
                    break;
            }

        }
        while (!sortir);

        vehicles.add(0, maritims);
        vehicles.add(1, terrestre);
        vehicles.add(2, aeris);

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
