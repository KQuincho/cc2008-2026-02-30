package controlador;

import modelo.Comprador;
import modelo.Localidad;
import modelo.ResultadoCompra;
import modelo.SistemaVenta;
import vista.Vista;

/**
 * Clase Controlador. Recibe las acciones del usuario a través de la Vista,
 * invoca la lógica correspondiente en el Modelo (SistemaVenta) y le indica
 * a la Vista qué debe mostrar con los resultados obtenidos.
 */
public class Controlador {

    private final SistemaVenta sistemaVenta;
    private final Vista vista;

    public Controlador(SistemaVenta sistemaVenta, Vista vista) {
        this.sistemaVenta = sistemaVenta;
        this.vista = vista;
    }

    /** Ciclo principal del menú. */
    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarNuevoComprador();
                    break;
                case 2:
                    procesarNuevaSolicitud();
                    break;
                case 3:
                    consultarDisponibilidadTotal();
                    break;
                case 4:
                    consultarDisponibilidadIndividual();
                    break;
                case 5:
                    mostrarReporteCaja();
                    break;
                case 6:
                    continuar = false;
                    vista.mostrarMensaje("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida, intente de nuevo.");
            }
        }
    }

    private void registrarNuevoComprador() {
        String nombre = vista.solicitarTexto("Nombre del comprador: ");
        String email = vista.solicitarTexto("Email del comprador: ");
        int cantidadBoletos = vista.solicitarEntero("Cantidad de boletos a comprar: ");
        double presupuestoMaximo = vista.solicitarDecimal("Presupuesto máximo: $");

        Comprador comprador = new Comprador(nombre, email, cantidadBoletos, presupuestoMaximo);
        sistemaVenta.setCompradorActual(comprador);
        vista.mostrarMensaje("Comprador registrado correctamente como comprador activo.");
    }

    private void procesarNuevaSolicitud() {
        ResultadoCompra resultado = sistemaVenta.procesarCompra();
        vista.mostrarResultadoCompra(resultado);
    }

    private void consultarDisponibilidadTotal() {
        vista.mostrarDisponibilidadTotal(sistemaVenta.getLocalidades());
    }

    private void consultarDisponibilidadIndividual() {
        int numeroLocalidad = vista.solicitarEntero("Ingrese el número de localidad (1, 5 o 10): ");
        Localidad localidad = sistemaVenta.buscarLocalidad(numeroLocalidad);
        vista.mostrarDisponibilidadIndividual(localidad);
    }

    private void mostrarReporteCaja() {
        vista.mostrarReporteCaja(sistemaVenta.getCaja());
    }
}
