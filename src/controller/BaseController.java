package controller;

import java.util.ArrayList;

public class BaseController<T> {
    private ArrayList<T> lista;

    public BaseController() {
        this.lista = new ArrayList<T>();
    }

    /**
     * Adiciona um intem à lista
     * @param item objeto a ser adicionado
     */
    public void create(T item) {
        this.lista.add(item);
    }

    /**
     * Retorna a lista
     * @return itens do ArrayList
     */
    public ArrayList<T> read() {
        return this.lista;
    }

    //update

    //delete
}
