package modelo;

import java.util.Random;

/**
 * Clase Modelo principal. Contiene la lógica de negocio del sistema de
 * venta de boletos: agrega las localidades (composición) y al comprador
 * actual (agregación), y aplica el algoritmo de asignación y las
 * validaciones de compra descritas en el enunciado.
 */
public class SistemaVenta {

    private Localidad[] localidades;
    private Comprador compradorActual;
    private double caja;

    private static final Random RANDOM = new Random();

    public SistemaVenta(Localidad[] localidades) {
        this.localidades = localidades;
        this.compradorActual = null;
        this.caja = 0.0;
    }

    /** Opción 1 del menú: reemplaza al comprador activo. */
    public void setCompradorActual(Comprador comprador) {
        this.compradorActual = comprador;
    }

    public Comprador getCompradorActual() {
        return compradorActual;
    }

    /**
     * Opción 2 del menú: ejecuta el algoritmo completo de una solicitud de
     * boletos para el comprador actual (generación de ticket, validación
     * de rango, asignación de localidad y las 3 validaciones de compra).
     */
    public ResultadoCompra procesarCompra() {
        if (compradorActual == null) {
            return new ResultadoCompra(false,
                    "No hay un comprador activo. Registre uno primero (opción 1).",
                    0, false, null, 0, 0.0);
        }

        // 1-3. Generar ticket y validar si es apto para comprar
        Ticket ticket = new Ticket();
        ticket.generarTicket();
        ticket.generarRango();
        boolean apto = ticket.validarTicket();

        if (!apto) {
            return new ResultadoCompra(false,
                    "El ticket #" + ticket.getNumeroTicket() + " no fue apto para comprar boletos.",
                    ticket.getNumeroTicket(), false, null, 0, 0.0);
        }

        // 5. Selección aleatoria de la localidad entre las 3 disponibles
        Localidad localidadAsignada = localidades[RANDOM.nextInt(localidades.length)];

        // 6.a Validar espacio
        if (!localidadAsignada.hayEspacio()) {
            return new ResultadoCompra(false,
                    "La localidad " + localidadAsignada.getNumeroLocalidad()
                            + " ya no tiene espacio disponible.",
                    ticket.getNumeroTicket(), true, localidadAsignada.getNumeroLocalidad(), 0, 0.0);
        }

        // 6.c Validar presupuesto vs. precio (se hace antes de vender)
        if (localidadAsignada.getPrecio() > compradorActual.getPresupuestoMaximo()) {
            return new ResultadoCompra(false,
                    "El presupuesto máximo ($" + compradorActual.getPresupuestoMaximo()
                            + ") no alcanza para la localidad " + localidadAsignada.getNumeroLocalidad()
                            + " ($" + localidadAsignada.getPrecio() + ").",
                    ticket.getNumeroTicket(), true, localidadAsignada.getNumeroLocalidad(), 0, 0.0);
        }

        // 6.b Validar disponibilidad de los boletos deseados y vender
        // (venderBoletos ajusta automáticamente a la mayor cantidad posible)
        int cantidadDeseada = compradorActual.getCantidadBoletos();
        int cantidadVendida = localidadAsignada.venderBoletos(cantidadDeseada);
        double montoCobrado = cantidadVendida * localidadAsignada.getPrecio();
        caja += montoCobrado;

        String mensaje = (cantidadVendida < cantidadDeseada)
                ? "Compra parcial: solo había espacio para " + cantidadVendida + " boleto(s)."
                : "Compra realizada con éxito.";

        return new ResultadoCompra(true, mensaje, ticket.getNumeroTicket(), true,
                localidadAsignada.getNumeroLocalidad(), cantidadVendida, montoCobrado);
    }

    /** Opción 3 del menú: todas las localidades con su estado de venta. */
    public Localidad[] getLocalidades() {
        return localidades;
    }

    /** Opción 4 del menú: busca una localidad puntual por su número. */
    public Localidad buscarLocalidad(int numeroLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNumeroLocalidad() == numeroLocalidad) {
                return localidad;
            }
        }
        return null;
    }

    /** Opción 5 del menú: total recaudado por la venta de boletos. */
    public double getCaja() {
        return caja;
    }
}
