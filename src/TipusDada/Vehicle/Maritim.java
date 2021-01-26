package TipusDada.Vehicle;

import TipusDada.DataClass;

public class Maritim extends Vehicle {

    private int eslora;
    private int manega;
    private int anyFlotacio;
    private DataClass dataConstruccio;

    public Maritim(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant, int eslora, int manega, int anyFlotacio, DataClass dataConstruccio) {
        super(consumMinim, carregaActual, capacitatMaxima, consum, tipusVehicle, identificador, velocitatMitja, identificadorTripulant);
        this.eslora = eslora;
        this.manega = manega;
        this.anyFlotacio = anyFlotacio;
        this.dataConstruccio = dataConstruccio;
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();
        System.out.println("\t- Eslora: " + eslora);
        System.out.println("\t- Manega: " + manega);
        System.out.println("\t- Any de Flotació: " + anyFlotacio);
        System.out.println("\t- Data construcció: " + dataConstruccio.getDate());
        System.out.println("\t- Consum Calculat: " + this.calcularConsum());
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getManega() {
        return manega;
    }

    public void setManega(int manega) {
        this.manega = manega;
    }

    public int getAnyFlotacio() {
        return anyFlotacio;
    }

    public void setAnyFlotacio(int anyFlotacio) {
        this.anyFlotacio = anyFlotacio;
    }

    public DataClass getDataClassConstrucció() {
        return dataConstruccio;
    }

    public void setDataClassConstrucció(DataClass DataClassConstrucció) {
        this.dataConstruccio = DataClassConstrucció;
    }

    @Override
    public double calcularConsum() {
        return consumMinim + ((carregaActual / capacitatMaxima) * consum) + (eslora + manega + anyFlotacio) - (dataConstruccio.getDia()) + dataConstruccio.getMes() + dataConstruccio.getAny();
    }
}
