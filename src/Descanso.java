/**
 * Representação de Descanso. Todo aluno precisa ter um estado geral, que será calculado nessa classe.
 *
 * @author Adriel Isaías
 */
public class Descanso {
    /**
     * Horas de descanso do aluno, no formato inteiro.
     */
    private int horasDescanso;
    /**
     * O numeros de semanas de estudo, no formato inteiro.
     */
    private int numeroSemanas;

    /**
     * Construtor de descanso.
     * Todo descanso inicia com os param nulos.
     * @param 'horasDescanso' formato int
     * @param 'numeroSemanas' formato int
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }

    /**
     * Recebe o valor das horas de descanso.
     * @return void
     */

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;

    }

    /**
     * Recebe o valor do numero de semanas.
     * @return void
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;

    }

    /**
     * Verifica a partir da divisão das horas de descanso pelo numero de semanas o estado do aluno. .
     * @return String
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