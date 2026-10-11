import java.util.Arrays;
/**
 * Representação de um registro de resumos de estudo. Armazena até uma quantidade limitada
 * de resumos. Ao adicionar um resumo com o registro cheio, o primeiro cadastrado é
 * substituído, depois o segundo, e assim sucessivamente.
 *
 * @author Adriel Isaías
 */
public class RegistroResumos {
    /**
     * Resumos armazenados, num array com tamanho máximo definido na criação do registro.
     */
    private Resumo[] resumos;
    /**
     * Quantidade de resumos armazenados no momento, no formato int.
     */
    private int quantidadeResumos;
    /**
     * Posição do array onde será gravado o próximo resumo, no formato int.
     */
    private int proximaPosicao;

    /**
     * Construtor de RegistroResumos.
     * O registro inicia vazio, com capacidade para o número de resumos recebido.
     * @param numeroDeResumos quantidade máxima de resumos, formato int
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um resumo na próxima posição livre. Se o registro já estiver cheio,
     * substitui o resumo mais antigo.
     * @param tema tema do resumo, formato String
     * @param conteudo conteúdo do resumo, formato String
     */
    public void adiciona(String tema, String conteudo) {
        this.resumos[this.proximaPosicao] = new Resumo(tema, conteudo);

        if (this.quantidadeResumos < this.resumos.length) {
            this.quantidadeResumos++;
        }

        this.proximaPosicao = (this.proximaPosicao + 1) % this.resumos.length;
    }

    /**
     * Retorna a representação em String de cada resumo armazenado.
     * @return String[] com um elemento no formato "tema: conteúdo" para cada resumo
     */
    public String[] pegaResumos() {
        String[] representacao = new String[this.quantidadeResumos];
        for (int i = 0; i < this.quantidadeResumos; i++) {
            representacao[i] = this.resumos[i].toString();
        }
        return representacao;
    }

    /**
     * Gera um texto com a quantidade de resumos cadastrados e os seus temas, separados por " | ".
     * @return String com a quantidade e os temas dos resumos
     */
    public String imprimeResumos() {
        String resultado = "- " + this.quantidadeResumos + " resumo(s) cadastrado(s)\n- ";

        for (int i = 0; i < this.quantidadeResumos; i++) {
            resultado += this.resumos[i].getTema();
            if (i < this.quantidadeResumos - 1) {
                resultado += " | ";
            }
        }
        return resultado;
    }

    /**
     * Conta quantos resumos estão armazenados no momento.
     * @return int quantidade de resumos armazenados
     */
    public int conta() {
        return this.quantidadeResumos;

    }

    /**
     * Verifica se existe um resumo com o tema recebido, sem diferenciar maiúsculas de minúsculas.
     * @param tema tema a procurar, formato String
     * @return true se existir um resumo com esse tema, false caso contrário
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < this.quantidadeResumos; i++) {
            if (this.resumos[i] != null && this.resumos[i].getTema().equalsIgnoreCase(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca os resumos cujo conteúdo contém a chave recebida, sem diferenciar
     * maiúsculas de minúsculas.
     * @param chaveDeBusca texto a procurar no conteúdo dos resumos, formato String
     * @return String[] com os temas dos resumos encontrados, em ordem alfabética
     */
    public String[] busca(String chaveDeBusca) {
        int qtnCorrespondentes = 0;
        for (int i = 0; i < quantidadeResumos; i++) {
           if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
               qtnCorrespondentes++;
           }
        }
        String[] temasCorrespondentes = new String[qtnCorrespondentes];
        int posicao = 0;
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                temasCorrespondentes[posicao] = resumos[i].getTema();
                posicao++;
            }
        }
        Arrays.sort(temasCorrespondentes);

        return temasCorrespondentes;
        }
}