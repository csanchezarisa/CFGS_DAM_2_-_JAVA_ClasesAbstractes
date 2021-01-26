package TipusDada;

public class DataClass {

    private int dia;
    private int mes;
    private int any;

    public DataClass(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getDate() {
        return dia + "/" + mes + "/" + any;
    }
}
