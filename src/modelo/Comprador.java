package modelo;

/**
 * Representa al comprador que participa en el proceso de compra de boletos.
 * Clase Modelo: solo almacena datos y los expone mediante getters.
 */
public class Comprador {

    private String nombreComprador;
    private String emailComprador;
    private int cantidadBoletos;
    private double presupuestoMaximo;

    public Comprador(String nombreComprador, String emailComprador,
                      int cantidadBoletos, double presupuestoMaximo) {
        this.nombreComprador = nombreComprador;
        this.emailComprador = emailComprador;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public String getEmailComprador() {
        return emailComprador;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
}
