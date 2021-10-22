package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProdutoController;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoController produtos = new ProdutoController();

        do {
            int opcao = menu(scanner);
            switch (opcao) {
            case 0:
                System.out.println("Aplicação finalizada.");
                break;

            case 1:
                System.out.println("\n----- Cadastro de produto -----");
                create(produtos, scanner);
                break;

            case 2:
                System.out.println("\n----- Edição de produto -----");
                update(produtos, scanner);
                break;

            case 3:
                System.out.println("\n----- Exclusão de produto -----");
                delete(produtos, scanner);
                break;

            case 4:
                System.out.println("\n----- Lista de produtos -----");
                read(produtos);
                break;
            }

        } while (voltarAoMenu(scanner));
    }

    /**
     * Exibe o menu e lê uma opção
     * 
     * @param scanner entrada de dados
     * @return opção escolhida
     */
    private static int menu(Scanner scanner) {
        int opcao = 0;
        boolean opcaoInvalida = false;

        do {
            System.out.println("----- Menu Produtos -----\n");
            System.out.printf("\t1. Cadastrar \n\t2. Editar \n\t3. Excluir \n\t4. Listar \n\t0. Sair\n");
            System.out.print("\nEscolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            opcaoInvalida = opcao < 0 || opcao > 4;

            if (opcaoInvalida) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoInvalida);

        return opcao;
    }

    private static boolean voltarAoMenu(Scanner scanner) {
        char resposta = ' ';

        System.out.println("\nDeseja voltar ao menu? (S\\N)");
        resposta = scanner.nextLine().toUpperCase().charAt(0);
        System.out.println();

        return resposta == 'S';
    }

    /**
     * Cria um novo objeto da classe Produto
     * 
     * @param produtos controller de ProdutoController
     * @param scanner  entrada de dados
     */
    private static void create(ProdutoController produtos, Scanner scanner) {
        Produto item = new Produto();
        System.out.print("\nNome: ");
        item.nome = scanner.nextLine();
        System.out.print("Categoria: ");
        item.categoria.nome = scanner.nextLine();
        System.out.print("Descrição categoria: ");
        item.categoria.descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        item.quantidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Preço: R$");
        item.preco = Double.parseDouble(scanner.nextLine());
        produtos.create(item);
        System.out.println("\nProduto criado com sucesso!");
    }

    /**
     * Lista todos os objetos de Produto
     * 
     * @param produtos controller de ProdutoController
     */
    public static void read(ProdutoController produtos) {
        ArrayList<Produto> item = produtos.read();
        for (Produto p : item) {
            System.out.println(p);
        }
    }

    /**
     * Altera um objeto de Produto de acordo com o id informado
     * 
     * @param produtos controller de ProdutoController
     * @param scanner  entrada de dados
     */
    public static void update(ProdutoController produtos, Scanner scanner) {
        System.out.print("\nID do produto a ser alterado: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = produtos.indexOf(id);

        if (index >= 0) {
            Produto item = produtos.read().get(index);
            System.out.print("Nome: ");
            item.nome = scanner.nextLine();
            System.out.print("Categoria: ");
            item.categoria.nome = scanner.nextLine();
            System.out.print("Descrição categoria: ");
            item.categoria.descricao = scanner.nextLine();
            System.out.print("Quantidade: ");
            item.quantidade = Integer.parseInt(scanner.nextLine());
            System.out.print("Preço: R$");
            item.preco = Double.parseDouble(scanner.nextLine());
            produtos.update(item);
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    /**
     * Busca produto pelo id e exclui caso exista.
     * 
     * @param produtos controller de ProdutoController
     * @param scanner  entrada de dados
     */
    public static void delete(ProdutoController produtos, Scanner scanner) {
        System.out.print("\nID do produto a ser excluido: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = produtos.indexOf(id);
        if (index >= 0) {
            Produto produto = produtos.read().get(index);
            produtos.delete(produto);
            System.out.println("\nProduto excluído com sucesso!");
        } else {
            System.out.println("ID não encontrado!");
        }
    }
}
