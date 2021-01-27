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

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();
        System.out.println("\t- Número de cavalls: " + numeroCavalls);
        System.out.println("\t- Número d'averies: " + numeroAveries);
        System.out.println("\t- Cost d'averies: " + costAveries);
        System.out.println("\t- Consum Calculat: " + this.calcularConsum());
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }

    @Override
    public double calcularConsum() {
        return consumMinim + ((carregaActual / capacitatMaxima) * consum) + (numeroAveries * costAveries);
    }
}
