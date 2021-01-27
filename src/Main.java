import TipusDada.Persona.*;
import TipusDada.Vehicle.*;
import files.GestionaLlistes;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        menuPrincipal();
    }


    /* .: 1. MENÚ PRINCIPAL :. */
    /** Mostra el menú principal i permet treballar amb ell */
    private static void menuPrincipal() throws InterruptedException {
        Scanner teclat = new Scanner(System.in);
        char seleccio;
        do {
            netejarPantalla();
            mostrarMenuPrincipal();
            seleccio = teclat.next().toLowerCase().charAt(0);

            switch (seleccio) {
                // Captura dades del JSON de vehicles
                case 'a':
                    vehicles = GestionaLlistes.getVehicles();

                    if (!vehicles.isEmpty())
                        System.out.println("S'han capturat correctament " + vehicles.size() + " vehicles");
                    else
                        System.out.println("No s'han pogut capturar els vehicles. Existeix el fitxer?");

                    stop();
                    break;

                // Captura dades del JSON de persones
                case 'b':
                    personas = GestionaLlistes.getPersonas();

                    if (!personas.isEmpty())
                        System.out.println("S'han capturat correctament " + personas.size() + " persones");
                    else
                        System.out.println("No s'han pogut capturar les persones. Existeix el fitxer?");

                    stop();
                    break;

                // Si hi ha vehicles i persones, assigna tripulants
                case 'c':
                    if (!vehicles.isEmpty() && !personas.isEmpty()) {
                        netejarPantalla();
                        vehicles = GestionaLlistes.assignarTripulants(vehicles, personas);
                    }
                    else {
                        System.out.println("Els llistats no estan inicialitzats! Inicialitza'ls primer..");
                        stop();
                    }
                    break;

                // Si hi ha vehicles, en mostra la informació
                case 'd':
                    // Si no s'ha inicialitzat la llista, mostra un error. Sino, mostra les informacions
                    if (!vehicles.isEmpty()) {
                        netejarPantalla();
                        GestionaLlistes.mostrarInformacioVehicles(vehicles);
                    }
                    else {
                        System.out.println("No hi ha cap vehicle inicialitzat! Inicialitza'n algún primer.");
                        stop();
                    }
                    break;

                // Permet crear el JSON de vehicles
                case 'e':
                    GestionaLlistes.crearVehicles();
                    stop();
                    break;

                // Permet crear el JSON de persones
                case 'f':
                    GestionaLlistes.crearPersonas();
                    stop();
                    break;

                // Surt
                case 'g':
                    System.out.println("Sortint...");
                    stop();
                    break;

                default:
                    System.out.println("Opció no trobada, prova-ho de nou");
                    stop();
            }

        }
        while (seleccio != 'g');
    }

    /** Mostra el menú principal */
    private static void mostrarMenuPrincipal() {
        System.out.println("### MENÚ PRINCIPAL ###");
        System.out.println("\tA - Capturar les dades dels vehicles");
        System.out.println("\tB - Capturar les dades del personal");
        System.out.println("\tC - Assignar personal disponible als vehicles");
        System.out.println("\tD - Mostrar les dades dels vehicles");
        System.out.println("\tE - Construir JSON vehicles");
        System.out.println("\tF - Construir JSON persones");
        System.out.println("\tG - Finalitzar");

    }


    /* .: 2. FUNCIONS PRÒPIES :. */
    /** Imprimeix 50 linies en blanc per "netejar" la pantalla */
    private static void netejarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void stop() throws InterruptedException {
        Thread.sleep(3000);
    }
}
