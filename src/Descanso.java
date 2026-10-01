public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;

    }

    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;

    }

    public String getStatusGeral() {
        if (numeroSemanas == 0) {
            return "cansado";
        }

        int mediaHorasPorSemana = horasDescanso / numeroSemanas;

        if (mediaHorasPorSemana >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }

}