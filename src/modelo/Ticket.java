package modelo;

import java.util.Random;

/**
 * Representa el ticket aleatorio generado en cada solicitud de compra.
 * Clase Modelo: contiene la lógica pura del algoritmo de sorteo (sin
 * imprimir nada en pantalla ni leer datos del usuario).
 */
public class Ticket {

    private static final int RANGO_MIN = 1;
    private static final int RANGO_MAX = 15000;
    private static final Random RANDOM = new Random();

    private int numeroTicket;
    private int numeroA;
    private int numeroB;
    private boolean aptoCompra;

    /** Genera el número aleatorio del ticket (1 a 15,000). */
    public void generarTicket() {
        numeroTicket = RANDOM.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
    }

    /** Genera los dos números adicionales A y B (1 a 15,000). */
    public void generarRango() {
        numeroA = RANDOM.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
        numeroB = RANDOM.nextInt(RANGO_MAX - RANGO_MIN + 1) + RANGO_MIN;
    }

    /**
     * Valida si el número del ticket cae dentro del rango formado por A y B.
     * @return true si el ticket es apto para comprar boletos.
     */
    public boolean validarTicket() {
        int limiteInferior = Math.min(numeroA, numeroB);
        int limiteSuperior = Math.max(numeroA, numeroB);
        aptoCompra = numeroTicket >= limiteInferior && numeroTicket <= limiteSuperior;
        return aptoCompra;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }

    public boolean isAptoCompra() {
        return aptoCompra;
    }
}
