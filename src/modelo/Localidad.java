package modelo;

/**
 * Representa una localidad de venta (1, 5 o 10) con su precio y capacidad.
 * Clase Modelo: administra su propio estado de venta (encapsulamiento).
 */
public class Localidad {

    private int numeroLocalidad;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(int numeroLocalidad, double precio, int capacidad) {
        this.numeroLocalidad = numeroLocalidad;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    /** Indica si la localidad todavía tiene al menos un espacio disponible. */
    public boolean hayEspacio() {
        return vendidos < capacidad;
    }

    /** Cantidad de boletos que aún se pueden vender en esta localidad. */
    public int getDisponibles() {
        return capacidad - vendidos;
    }

    /**
     * Vende boletos en esta localidad. Si la cantidad deseada excede el
     * espacio disponible, vende únicamente la mayor cantidad posible.
     * @param cantidadDeseada boletos que el comprador quiere adquirir.
     * @return la cantidad de boletos realmente vendidos.
     */
    public int venderBoletos(int cantidadDeseada) {
        int disponibles = getDisponibles();
        int cantidadAVender = Math.min(cantidadDeseada, disponibles);
        vendidos += cantidadAVender;
        return cantidadAVender;
    }

    public int getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getVendidos() {
        return vendidos;
    }
}
