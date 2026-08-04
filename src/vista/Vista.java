package vista;

import java.util.Scanner;
import modelo.Localidad;
import modelo.ResultadoCompra;

/**
 * Clase Vista. Su única responsabilidad es mostrar información en pantalla
 * y capturar las entradas del usuario. No contiene lógica de negocio ni
 * decide nada por sí misma: solo pide y muestra datos.
 */
public class Vista {

    private final Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    /** Muestra el menú principal y devuelve la opción elegida. */
    public int mostrarMenu() {
        System.out.println("\n===== Venta de Boletos - Mundial Femenino FIFA 2027 =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        return leerEntero();
    }

    public String solicitarTexto(String etiqueta) {
        System.out.print(etiqueta);
        return scanner.nextLine();
    }

    public int solicitarEntero(String etiqueta) {
        System.out.print(etiqueta);
        return leerEntero();
    }

    public double solicitarDecimal(String etiqueta) {
        System.out.print(etiqueta);
        return leerDecimal();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /** Muestra el resultado de una solicitud de compra de boletos. */
    public void mostrarResultadoCompra(ResultadoCompra resultado) {
        System.out.println("\n--- Resultado de la solicitud ---");
        System.out.println("Ticket generado: #" + resultado.getNumeroTicket());
        System.out.println("¿Apto para comprar?: " + (resultado.isTicketApto() ? "Sí" : "No"));
        if (resultado.getLocalidadAsignada() != null) {
            System.out.println("Localidad asignada: " + resultado.getLocalidadAsignada());
        }
        System.out.println(resultado.getMensaje());
        if (resultado.isExitosa()) {
            System.out.println("Boletos vendidos: " + resultado.getBoletosVendidos());
            System.out.printf("Monto cobrado: $%.2f%n", resultado.getMontoCobrado());
        }
    }

    /** Muestra la disponibilidad de todas las localidades. */
    public void mostrarDisponibilidadTotal(Localidad[] localidades) {
        System.out.println("\n--- Disponibilidad total ---");
        for (Localidad localidad : localidades) {
            System.out.printf("Localidad %-2d | Precio: $%-7.2f | Vendidos: %2d/%2d | Disponibles: %2d%n",
                    localidad.getNumeroLocalidad(), localidad.getPrecio(),
                    localidad.getVendidos(), localidad.getCapacidad(), localidad.getDisponibles());
        }
    }

    /** Muestra la disponibilidad de una localidad específica. */
    public void mostrarDisponibilidadIndividual(Localidad localidad) {
        if (localidad == null) {
            System.out.println("No existe una localidad con ese número. Use 1, 5 o 10.");
            return;
        }
        System.out.println("\n--- Disponibilidad de la localidad " + localidad.getNumeroLocalidad() + " ---");
        System.out.println("Boletos disponibles: " + localidad.getDisponibles() + "/" + localidad.getCapacidad());
    }

    /** Muestra el reporte total de dinero recaudado. */
    public void mostrarReporteCaja(double caja) {
        System.out.printf("%n--- Reporte de caja ---%nTotal recaudado: $%.2f%n", caja);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido, ingrese un número entero: ");
            }
        }
    }

    private double leerDecimal() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido, ingrese un número: ");
            }
        }
    }
}
