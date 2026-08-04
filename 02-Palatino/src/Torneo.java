public class Torneo {
    private String nombre;
    private Equipo e1, e2, e3;


   public Torneo(String nombre, Equipo e1, Equipo e2, Equipo e3, Equipo e4, Equipo e5) {
    this.nombre = nombre;

    equipos[0] = e1;
    equipos[1] = e2;
    equipos[2] = e3;
    equipos[3] = e4;
    equipos[4] = e5;
}
    }

    public String resumen() {

        int totalGoles = 0;

        for (Equipo e: equipos) {
            totalGoles += e.getGoles();
        }


        int totalGoles = e1.getGoles() + e2.getGoles() + e3.getGoles();
        int totalTirosEsquina = e1.getTirosEsquina() + e2.getTirosEsquina();
        int totalTarjetasAmarillas = e1.getTarjetasAmarillas() + e2.getTarjetasAmarillas();
        int totalTarjetasRojas = e1.getTarjetasRojas() + e2.getTarjetasRojas();

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo:   " + totalGoles + "\n";
        texto += "Total de tiros de esquina:   " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas:     " + totalTarjetasRojas;

        return texto;
    }

    public String listaEquipos() {
        return "1. " + e1.getNombre() + "\n"
             + "2. " + e2.getNombre();
    }

    public String estadisticasEquipo(int numero) {
        if (numero == 1) {
            return e1.resumen();
        }
        if (numero == 2) {
            return e2.resumen();
        }
        return "Numero de equipo invalido.";
    }

    public setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}
