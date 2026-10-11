/**
 * Representação de registro de tempo online de uma disciplina qualquer. Controla quantas horas
 * online o aluno já usou na disciplina e quantas eram esperadas.
 * @author Adriel Isaías
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina, no formato String.
     */
    private String nomeDisciplina;
    /**
     * Horas online já usadas na disciplina, no formato int.
     */
    private int tempoOnlineUsado;
    /**
     * Horas online esperadas para a disciplina, no formato int.
     */
    private int tempoOnlineEsperado;
    /**
     * Construtor de RegistroTempoOnline com tempo esperado padrão.
     * O tempo online usado inicia em 0 e o esperado em 120 horas.
     * @param nomeDisciplina nome da disciplina, formato String.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = 120;
        
    }
    /**
     * Construtor de RegistroTempoOnline com tempo esperado definido.
     * O tempo online usado inicia em 0 (igual o outro).
     * @param nomeDisciplina nome da disciplina, formato String.
     * @param tempoOnlineEsperado horas online esperadas para a disciplina, formato int.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;

    }
    /**
     * Soma o tempo recebido ao tempo online já usado. Mesmo após atingir a meta,
     * ainda é possível adicionar mais tempo.
     * @param tempo horas online a adicionar, formato int.
     */
    public void adicionaTempoOnline(int tempo) {
        tempoOnlineUsado += tempo;

    }
    /**
     * Verifica se o tempo online usado já atingiu o tempo esperado.
     * @return true se o tempo usado for maior ou igual ao esperado, false caso contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineUsado >= tempoOnlineEsperado) {
            return true;
        }
        return  false;

    }
    /**
     * Gera a representação em String do registro.
     * @return String no formato "nomeDisciplina usado/esperado".
     */
    @Override 
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;

    }

}