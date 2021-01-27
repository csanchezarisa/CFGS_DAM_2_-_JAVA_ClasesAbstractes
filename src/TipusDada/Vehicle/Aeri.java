package TipusDada.Vehicle;

public class Aeri extends Vehicle {

    private int numeroMotors;
    private int tempsFuncionament;

    public Aeri(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant, int numeroMotors, int tempsFuncionament) {
        super(consumMinim, carregaActual, capacitatMaxima, consum, tipusVehicle, identificador, velocitatMitja, identificadorTripulant);
        this.numeroMotors = numeroMotors;
        this.tempsFuncionament = tempsFuncionament;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();
        System.out.println("\t- Número de Motors: " + numeroMotors);
        System.out.println("\t- Temps de Funcionament: " + tempsFuncionament);
        System.out.println("\t- Consum Calculat: " + this.calcularConsum());
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }

    @Override
    public double calcularConsum() {
        return consumMinim + ((carregaActual / capacitatMaxima) * consum) + (numeroMotors * tempsFuncionament);
    }
}
