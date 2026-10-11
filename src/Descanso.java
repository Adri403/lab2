/**
 * Representação de Descanso. Todo aluno precisa ter um estado geral, que será calculado nessa classe.
 *
 * @author Adriel Isaías
 */
public class Descanso {
    /**
     * Horas de descanso do aluno, no formato int.
     */
    private int horasDescanso;
    /**
     * O numero de semanas de descanso, no formato int.
     */
    private int numeroSemanas;
    /**
     * Construtor de descanso.
     * Todo descanso inicia com 0 horas de descanso e 0 semanas.
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }
    /**
     * Recebe o valor das horas de descanso.
     * @param valor horas de descanso, formato int
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }
    /**
     * Recebe o valor do numero de semanas.
     * @param valor número de semanas, formato int
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }
    /**
     * Verifica a partir da divisão das horas de descanso pelo numero de semanas o estado do aluno.
     * @return String "descansado" se a média de horas por semana for 26 ou mais, "cansado" caso contrário.
     */
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