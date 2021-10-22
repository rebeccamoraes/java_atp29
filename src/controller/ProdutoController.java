package controller;

import java.util.ArrayList;

import model.Produto;

public class ProdutoController extends BaseController<Produto> {
    public int indexOf(int id) {
        ArrayList<Produto> produtos = this.read();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId() == id)
                return i;
        }
        return -1;
    }
}
