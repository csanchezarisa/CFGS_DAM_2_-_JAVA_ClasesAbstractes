package TipusDada.Vehicle;

import TipusDada.Data;

public class Maritim extends Vehicle {

    private int eslora;
    private int manega;
    private int anyFlotacio;
    private Data dataConstrucció;

    public Maritim(double consumMinim, double carregaActual, double capacitatMaxima, double consum, char tipusVehicle, String identificador, double velocitatMitja, String identificadorTripulant, int eslora, int manega, int anyFlotacio, Data dataConstrucció) {
        super(consumMinim, carregaActual, capacitatMaxima, consum, tipusVehicle, identificador, velocitatMitja, identificadorTripulant);
        this.eslora = eslora;
        this.manega = manega;
        this.anyFlotacio = anyFlotacio;
        this.dataConstrucció = dataConstrucció;
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

    public Data getDataConstrucció() {
        return dataConstrucció;
    }

    public void setDataConstrucció(Data dataConstrucció) {
        this.dataConstrucció = dataConstrucció;
    }

    @Override
    public double calcularConsum() {
        return consumMinim + ((carregaActual / capacitatMaxima) * consum) + (eslora + manega + anyFlotacio) - (dataConstrucció.getDia()) + dataConstrucció.getMes() + dataConstrucció.getAny();
    }
}
