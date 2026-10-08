import java.util.Arrays;

public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo) {
        this.resumos[this.proximaPosicao] = new Resumo(tema, conteudo);

        if (this.quantidadeResumos < this.resumos.length) {
            this.quantidadeResumos++;
        }

        this.proximaPosicao = (this.proximaPosicao + 1) % this.resumos.length;
    }

    public String[] pegaResumos() {
        String[] representacao = new String[this.quantidadeResumos];
        for (int i = 0; i < this.quantidadeResumos; i++) {
            representacao[i] = this.resumos[i].toString();
        }
        return representacao;
    }

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

    public int conta() {
        return this.quantidadeResumos;

    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < this.quantidadeResumos; i++) {
            if (this.resumos[i] != null && this.resumos[i].getTema().equalsIgnoreCase(tema)) {
                return true;
            }
        }
        return false;
    }

    public String[] busca(String chaveDeBusca) {
        int qtnCorrespondentes = 0;
        for (int i = 0; i < quantidadeResumos; i++) {
           if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
               qtnCorrespondentes++;
           }
        }
        String[] temasCorrespondentes = new String[qtnCorrespondentes];
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                temasCorrespondentes[i] = resumos[i].getTema();
            }
        }
        Arrays.sort(temasCorrespondentes);

        return temasCorrespondentes;
        }
}
