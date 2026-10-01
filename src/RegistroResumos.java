public class RegistroResumos {
    private String[] temas;
    private String[] conteudos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo) {
        this.temas[this.proximaPosicao] = tema;
        this.conteudos[this.proximaPosicao] = conteudo;

        if (this.quantidadeResumos < this.temas.length) {
            this.quantidadeResumos++;
        }

        this.proximaPosicao = (this.proximaPosicao + 1) % this.temas.length;
    }

    public String[] pegaResumos() {
        String[] representacao = new String[this.quantidadeResumos];
        for (int i = 0; i < this.quantidadeResumos; i++) {
            representacao[i] = this.temas[i] + ": " + this.conteudos[i];
        }
        return representacao;
    }

    public String imprimeResumos() {
        String resultado = "- " + this.quantidadeResumos + " resumo(s) cadastrado(s)\n- ";

        for (int i = 0; i < this.quantidadeResumos; i++) {
            resultado += this.temas[i];
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
            if (this.temas[i] != null && this.temas[i].equalsIgnoreCase(tema)) {
                return true;
            }
        }
        return false;
    }

}