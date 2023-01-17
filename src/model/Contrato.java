package model;

public class Contrato {
    private int id;
    private String data;
    private String hora;
    private int id_func;
    private int id_clie;
    private int id_car;

    public Contrato() {
    }

    public Contrato(String data, String hora, int id_func, int id_clie, int id_car) {
        this.data = data;
        this.hora = hora;
        this.id_func = id_func;
        this.id_clie = id_clie;
        this.id_car = id_car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getId_clie() {
        return id_clie;
    }

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }
}
