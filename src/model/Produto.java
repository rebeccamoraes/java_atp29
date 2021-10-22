package model;

public class Produto extends Base {
    public String nome;
    public Categoria categoria;
    public double preco;
    public int quantidade;

    /** Construtor genérico para inicializar id */
    public Produto() {
        super();
        this.categoria = new Categoria();
    }

    /**
     * Construtor para inicializar os atributos e id
     * 
     * @param nome       nome do produto
     * @param categoria  categoria do produto
     * @param preco      preço do produto
     * @param quantidade quantidade do produto
     */
    public Produto(String nome, Categoria categoria, double preco, int quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nID: " + this.getId() + "\nNome: " + this.nome + this.categoria
                + String.format("\nPreço: R$%.2f", this.preco) + "\nQuantidade: " + this.quantidade;
    }
}
