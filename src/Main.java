import controlador.Controlador;
import modelo.Localidad;
import modelo.SistemaVenta;
import vista.Vista;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Driver program. Crea las instancias iniciales (localidades) y arranca
 * el sistema. La instancia de Comprador se crea desde el Controlador
 * cuando el usuario elige la opción "Nuevo comprador" del menú.
 */
public class Main {

    public static void main(String[] args) {
        // Fuerza salida en UTF-8 para que tildes y "ñ" se vean bien en cualquier consola
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // Instancias de Localidad: 20 boletos en cada una de las 3 localidades
        Localidad localidad1 = new Localidad(1, 100.0, 20);
        Localidad localidad5 = new Localidad(5, 500.0, 20);
        Localidad localidad10 = new Localidad(10, 1000.0, 20);
        Localidad[] localidades = { localidad1, localidad5, localidad10 };

        SistemaVenta sistemaVenta = new SistemaVenta(localidades);
        Vista vista = new Vista();
        Controlador controlador = new Controlador(sistemaVenta, vista);

        controlador.iniciar();
    }
}
