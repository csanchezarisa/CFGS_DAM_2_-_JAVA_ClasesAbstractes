package TipusDada.Vehicle;

public abstract class Vehicle {

    protected double consumMinim;
    protected double carregaActual;
    protected double capacitatMaxima;
    protected double consum;
    protected char tipusVehicle;
    protected String identificador;
    protected double velocitatMitja;
    protected String identificadorTripulant;

    public Vehicle(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant) {
        this.consumMinim = consumMinim;
        this.carregaActual = carregaActual;
        this.capacitatMaxima = capacitatMaxima;
        this.consum = consum;
        this.tipusVehicle = tipusVehicle;
        this.identificador = identificador;
        this.velocitatMitja = velocitatMitja;
        this.identificadorTripulant = identificadorTripulant;
    }

    /** Mostra la informació del vehicle */
    public void mostrarInformacio() {
        System.out.println("\t### INFORMACIÓ DEL VEHICLE " + identificador + " ###");
        System.out.println("\t- Consum Mínim: " + consumMinim);
        System.out.println("\t- Càrrega Actual: " + carregaActual);
        System.out.println("\t- Capacitat màxima: " + capacitatMaxima);
        System.out.println("\t- Consum en KM: " + consum);
        System.out.println("\t- Tipus de vehicle: " + this.getClass());
        System.out.println("\t- Tipus de vehicle (anotació): " + tipusVehicle);
        System.out.println("\t- Identificador: " + identificador);
        System.out.println("\t- Velocitat Mitja: " + velocitatMitja);
        System.out.println("\t- Identificador tripulant: " + identificadorTripulant);
    }

    public double getConsumMinim() {
        return consumMinim;
    }

    public void setConsumMinim(double consumMinim) {
        this.consumMinim = consumMinim;
    }

    public double getCarregaActual() {
        return carregaActual;
    }

    public void setCarregaActual(double carregaActual) {
        this.carregaActual = carregaActual;
    }

    public double getCapacitatMaxima() {
        return capacitatMaxima;
    }

    public void setCapacitatMaxima(double capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
    }

    public double getConsum() {
        return consum;
    }

    public void setConsum(double consum) {
        this.consum = consum;
    }

    public char getTipusVehicle() {
        return tipusVehicle;
    }

    public void setTipusVehicle(char tipusVehicle) {
        this.tipusVehicle = tipusVehicle;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getVelocitatMitja() {
        return velocitatMitja;
    }

    public void setVelocitatMitja(double velocitatMitja) {
        this.velocitatMitja = velocitatMitja;
    }

    public String getIdentificadorTripulant() {
        return identificadorTripulant;
    }

    public void setIdentificadorTripulant(String identificadorTripulant) {
        this.identificadorTripulant = identificadorTripulant;
    }

    public abstract double calcularConsum();

}
