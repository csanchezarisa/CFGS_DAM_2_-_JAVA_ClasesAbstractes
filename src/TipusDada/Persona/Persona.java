package TipusDada.Persona;

import TipusDada.DataClass;


public class Persona {

    private String nif;
    private String nom;
    private DataClass dataNaixement;
    private char especialitatVehicle;
    private boolean assignat;

    public Persona(String nom) {
        this.nom = nom;
    }

    public Persona(String nif, String nom, DataClass dataNaixement, char especialitatVehicle, boolean assignat) {
        this.nif = nif;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
        this.especialitatVehicle = especialitatVehicle;
        this.assignat = assignat;
    }
}
