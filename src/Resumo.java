/**
 * Representação de um resumo de estudo. Todo resumo tem um tema e um conteúdo.
 *
 * @author Adriel Isaías
 */
public class Resumo {
    /**
     * Tema do resumo, no formato String.
     */
    private String tema;
    /**
     * Conteúdo do resumo, no formato String.
     */
    private String conteudo;

    /**
     * Construtor de Resumo.
     * @param tema tema do resumo, formato String.
     * @param conteudo conteúdo do resumo, formato String.
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     * @return String tema do resumo.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     * @return String conteúdo do resumo.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Gera a representação em String do resumo.
     * @return String no formato "tema: conteúdo"
     */
    @Override
    public String toString() {
        return this.tema + ": " + this.conteudo;

    }
}