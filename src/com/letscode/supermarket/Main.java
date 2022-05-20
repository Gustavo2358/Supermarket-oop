package com.letscode.supermarket;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

        //TODO dodos fake, apagar depois
        estoque.getEstoque().add(MockData.nescau);
        estoque.getEstoque().add(MockData.donPerrengue);
        estoque.getEstoque().add(MockData.softButt);

        boolean finalizar;
        do{
            finalizar = menu(sc, estoque);
        }while(!finalizar);
    }

    public static boolean menu(Scanner sc, Estoque estoque){
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Cadastrar/Comprar produtos");
        System.out.println("2 - Imprimir estoque");
        System.out.println("3 - Listar os produto pelo Tipo");
        System.out.println("4 - Pesquisar um produto pelo código");
        System.out.println("5 - Pesquisar um produto pelo nome");
        System.out.println("6 - Efetuar venda");
        System.out.println("7 - Relatório de vendas analítico");
        System.out.println("8 - Relatório de vendas consolidado");
        System.out.println("9 - Sair");

        //ask input while input is not within the right range
        int opcao = 0;
        final int opcaoMaxima = 9;
        do {
            try {
                opcao = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException exception){
                System.out.printf("Opção inválida. Digite um número entre 1 e %d.%n", opcaoMaxima);
            }
            if(opcao < 1 || opcao > opcaoMaxima){
                System.out.printf("Digite um número entre 1 e %d (incluso).%n", opcaoMaxima);
            }
        }while(opcao < 1 || opcao > opcaoMaxima);

        switch (opcao) {
            case 1:
                estoque.cadastrarComprar();
                break;
            case 2:
                imprimeEstoque(estoque, sc);
                break;
            case 3:
                getProdutoPeloTipo(estoque, sc);
                break;
            case 4:
                getProdutoPeloCodigo(sc, estoque);
                break;
            case 5:
                getProdutoPeloNome(sc, estoque);
                break;
            case 6:
//                venda(sc);
                break;
            case 7:
//                imprimirVendas();
                break;
            case 8:
//                relatorioSintetico();
                break;
            case 9:
                return true;
        }
        return false;
    }

    private static void getProdutoPeloNome(Scanner sc, Estoque estoque) {
        Stream<Produto> produtoStream;
        System.out.println("Digite o nome:");
        String nome = sc.nextLine().toUpperCase(Locale.ROOT);
        if (estoque.getEstoque().stream().noneMatch(e -> e.getNome().toUpperCase(Locale.ROOT).contains(nome.toUpperCase(Locale.ROOT)))){
            System.out.println("Produto não encontrado.");
            System.out.println("Aperte qualquer tecla para retornar ao menu principal.");
            sc.nextLine();
        }else {
            produtoStream = estoque.getEstoque().stream()
                    .filter(e -> e.getNome().toUpperCase(Locale.ROOT).contains(nome.toUpperCase(Locale.ROOT)));
            estoque.imprimeEstoque(produtoStream);
        }
        System.out.println("Pressione enter para voltar ao menu principal.");
        sc.nextLine();
    }

    private static void getProdutoPeloCodigo(Scanner sc, Estoque estoque) {
        Stream<Produto> produtoStream;
        System.out.println("Digite o código:");
        String id = sc.nextLine();
        if (estoque.getEstoque().stream().noneMatch(e -> e.getId().equals(id))){
            System.out.println("Produto não encontrado.");
            System.out.println("Pressione enter para voltar ao menu principal.");
            sc.nextLine();
        }else {
            produtoStream = estoque.getEstoque().stream()
                    .filter(e -> e.getId().equals(id));
            estoque.imprimeEstoque(produtoStream);
        }
        System.out.println("Pressione enter para voltar ao menu principal.");
        sc.nextLine();
    }

    private static void imprimeEstoque(Estoque estoque, Scanner sc) {
        Stream<Produto> produtoStream;
        produtoStream = estoque.getEstoque().stream();
        estoque.imprimeEstoque(produtoStream);
        System.out.println("Pressione enter para voltar ao menu principal.");
        sc.nextLine();
    }

    private static void getProdutoPeloTipo(Estoque estoque, Scanner sc) {
        Stream<Produto> produtoStream;
        System.out.println("Digite o tipo desejado: (ALIMENTOS - BEBIDA - HIGIENE)");
        TipoProduto tipo = SupermarketUtils.recebeTipoProduto();
        produtoStream = estoque.getEstoque().stream()
                .filter(e -> e.getTipo() == tipo);
        estoque.imprimeEstoque(produtoStream);
        System.out.println("Pressione enter para voltar ao menu principal.");
        sc.nextLine();
    }

}

