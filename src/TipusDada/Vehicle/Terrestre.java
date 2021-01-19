package TipusDada.Vehicle;

public class Terrestre extends Vehicle {

    private int numeroCavalls;
    private int numeroAveries;
    private int costAveries;

    public Terrestre(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant, int numeroCavalls, int numeroAveries, int costAveries) {
        super(consumMinim, carregaActual, capacitatMaxima, consum, tipusVehicle, identificador, velocitatMitja, identificadorTripulant);
        this.numeroCavalls = numeroCavalls;
        this.numeroAveries = numeroAveries;
        this.costAveries = costAveries;
    }

    public int getNumeroCavalls() {
        return numeroCavalls;
    }

    public void setNumeroCavalls(int numeroCavalls) {
        this.numeroCavalls = numeroCavalls;
    }

    public int getNumeroAveries() {
        return numeroAveries;
    }

    public void setNumeroAveries(int numeroAveries) {
        this.numeroAveries = numeroAveries;
    }

    public int getCostAveries() {
        return costAveries;
    }

    public void setCostAveries(int costAveries) {
        this.costAveries = costAveries;
    }
}
