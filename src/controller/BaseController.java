package controller;

import java.util.ArrayList;

public class BaseController<T> {
    private ArrayList<T> lista;

    public BaseController() {
        this.lista = new ArrayList<T>();
    }

    /**
     * Adiciona um item à lista
     * 
     * @param item objeto a ser adicionado
     */
    public void create(T item) {
        this.lista.add(item);
    }

    /**
     * Retorna a lista
     * 
     * @return itens do ArrayList
     */
    public ArrayList<T> read() {
        return this.lista;
    }

    /**
     * Verifica se o ArrayList contém um item com o mesmo id do item recebido. Se
     * sim, o item presente no ArrayList é excluído e o item recebido é adicionado.
     * 
     * @param item objeto a ser verificado e adicionado
     */
    public void update(T item) {
        if (this.lista.contains(item)) {
            this.delete(item);
            this.create(item);
        }
    }

    /**
     * Remove o objeto recebido do ArrayList
     * 
     * @param item objeto a ser removido
     */
    public void delete(T item) {
        this.lista.remove(item);
    }
}
