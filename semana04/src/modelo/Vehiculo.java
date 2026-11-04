package modelo;

public abstract class Vehiculo {

    protected String marca;
    protected String modelo;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMax = velocidadMax;
    }

    // Metodo abstracto: sin cuerpo, cada subclase DEBE implementarlo
    public abstract String describir();

    public String infoBase() {
        return marca + " " + modelo;
    }
}
