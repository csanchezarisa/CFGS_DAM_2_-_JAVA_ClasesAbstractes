package TipusDada.Vehicle;

public class Aeri extends Vehicle {

    private int numeroMotors;
    private int tempsFuncionament;

    public Aeri(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant, int numeroMotors, int tempsFuncionament) {
        super(consumMinim, carregaActual, capacitatMaxima, consum, tipusVehicle, identificador, velocitatMitja, identificadorTripulant);
        this.numeroMotors = numeroMotors;
        this.tempsFuncionament = tempsFuncionament;
    }

    public int getNumeroMotors() {
        return numeroMotors;
    }

    public void setNumeroMotors(int numeroMotors) {
        this.numeroMotors = numeroMotors;
    }

    public int getTempsFuncionament() {
        return tempsFuncionament;
    }

    public void setTempsFuncionament(int tempsFuncionament) {
        this.tempsFuncionament = tempsFuncionament;
    }
}
