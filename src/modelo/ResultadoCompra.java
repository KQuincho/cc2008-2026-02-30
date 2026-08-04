package modelo;

/**
 * Objeto simple (DTO) que resume el resultado de una solicitud de compra.
 * Permite que el Modelo devuelva información sin depender de System.out,
 * manteniendo la separación de responsabilidades del patrón MVC: la Vista
 * es la única responsable de mostrar datos en pantalla.
 */
public class ResultadoCompra {

    private final boolean exitosa;
    private final String mensaje;
    private final int numeroTicket;
    private final boolean ticketApto;
    private final Integer localidadAsignada; // null si no se llegó a asignar
    private final int boletosVendidos;
    private final double montoCobrado;

    public ResultadoCompra(boolean exitosa, String mensaje, int numeroTicket,
                            boolean ticketApto, Integer localidadAsignada,
                            int boletosVendidos, double montoCobrado) {
        this.exitosa = exitosa;
        this.mensaje = mensaje;
        this.numeroTicket = numeroTicket;
        this.ticketApto = ticketApto;
        this.localidadAsignada = localidadAsignada;
        this.boletosVendidos = boletosVendidos;
        this.montoCobrado = montoCobrado;
    }

    public boolean isExitosa() {
        return exitosa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public boolean isTicketApto() {
        return ticketApto;
    }

    public Integer getLocalidadAsignada() {
        return localidadAsignada;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public double getMontoCobrado() {
        return montoCobrado;
    }
}
