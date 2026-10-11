import java.util.Arrays;
/**
 * Representação de uma disciplina cursada pelo aluno. Controla as horas de estudo, 
 * além das notas da disciplina, partindo delas calcla a média ponderada e a aprovação.
 */
public class Disciplina {
    /**
     * Nome da disciplina, no formato String.
     */
    private String nomeDisciplina;
     /**
     * Horas de estudo acumuladas na disciplina, no formato inteiro.
     */
    private int horasEstudo;
    /**
     * Pesos de cada nota, num array com o mesmo tamanho do array de notas.
     */
    private int[] pesos;
    /**
     * Notas da disciplina.
     */
    private double[] notas;
     /**
     * Construtor de Disciplina com o número padrão de notas.
     * A disciplina inicia com 4 notas, todas com o mesmo peso.
     * @param nomeDisciplina nome da disciplina, formato String.
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);

    }
    /**
     * Construtor de Disciplina com número de notas definido.
     * Todas as notas iniciam zeradas e têm o mesmo peso, então a média é aritmética.
     * @param nomeDisciplina nome da disciplina, formato String
     * @param numeroNotas quantidade de notas da disciplina, formato int
     */
    public Disciplina(String nomeDisciplina, int numeroNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];
        this.pesos = new int[numeroNotas];

        for (int i = 0; i < this.pesos.length; i++) {
        this.pesos[i] = 1;
        }
    }
     /**
     * Construtor de Disciplina com número de notas e pesos definidos, para o cálculo de uma média ponderada.
     * O array de pesos deve ter o mesmo tamanho do número de notas.
     * @param nomeDisciplina nome da disciplina, formato String.
     * @param numeroNotas quantidade de notas da disciplina, formato int.
     * @param pesos peso de cada nota, formato int[].
     */
    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numeroNotas];
        this.pesos = pesos;
    }
    /**
     * Soma as horas recebidas às horas de estudo já cadastradas.
     * @param horas horas de estudo a adicionar, formato int.
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }
    /**
     * Cadastra o valor de uma das notas. Se a nota já tinha sido cadastrada, o valor
     * anterior é substituído. Números de nota fora do intervalo de 1 até o total de notas
     * da disciplina são ignorados.
     * @param nota número da nota, começando em 1, formato int.
     * @param valorNota valor da nota, formato double.
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= this.notas.length) {
            this.notas[nota - 1] = valorNota;
        }
    }
    /**
     * Calcula a média ponderada das notas: soma de (peso x nota).
     * dividida pela soma dos pesos. Quando todos os pesos são iguais, é a média aritmética.
     * Notas não cadastradas contam como zero.
     * @return double média ponderada das notas.
     */
    public double calculaMedia() {
        double somaTotal = 0.0;
        int somaPesos = 0;
        for (int i = 0; i < this.notas.length; i++) {
            somaTotal += this.notas[i] * this.pesos[i];
            somaPesos += this.pesos[i];
        }
        return somaTotal / somaPesos;
    }
    /**
     * Verifica se o aluno foi aprovado, ou seja, se a média é igual ou acima de 7.0.
     * @return true se a média for maior ou igual a 7.0, false caso contrário.
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }
    /**
     * Gera a representação em String da disciplina.
     * @return String com nome, horas de estudo, média e as notas.
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
