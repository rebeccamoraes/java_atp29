package model;

public class Categoria extends Base {
    public String nome;
    public String descricao;

    /**
     * Cria id
     */
    public Categoria() {
        //seta id
        super();
    }

    /**
     * Inicializa os atributos e cria o id
     * @param nome
     * @param descricao
     */
    public Categoria(String nome, String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        String texto = "Categoria: " + this.nome + " - " + this.descricao;
        return texto;
    }
}
