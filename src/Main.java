import TipusDada.Persona.*;
import TipusDada.Vehicle.*;
import files.GestionaLlistes;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Persona> personas;
    private static ArrayList<Vehicle> vehicles;

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        menuPrincipal();
    }


    /* .: 1. MENÚ PRINCIPAL :. */
    /** Mostra el menú principal i permet treballar amb ell */
    private static void menuPrincipal() throws InterruptedException, IOException, ParseException {
        Scanner teclat = new Scanner(System.in);
        char seleccio;
        do {
            netejarPantalla();
            mostrarMenuPrincipal();
            seleccio = teclat.next().toLowerCase().charAt(0);

            switch (seleccio) {
                case 'a':
                    vehicles = GestionaLlistes.getVehicles();
                    break;

                case 'b':
                    personas = GestionaLlistes.getPersonas();
                    break;

                case 'c':
                    break;

                case 'd':

                    break;

                case 'e':
                    GestionaLlistes.crearVehicles();
                    stop();
                    break;

                case 'f':
                    GestionaLlistes.crearPersonas();
                    stop();
                    break;

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
