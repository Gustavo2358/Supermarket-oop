package com.letscode.supermarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

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
                estoque.imprimeEstoque();
                break;
            case 3:
//                System.out.println("Digite o tipo: (ALIMENTOS - BEBIDA - HIGIENE)");
//                TipoProduto tipo = recebeTipoProduto(sc);
//                imprimirEstoque(tipo, null, null);
                break;
            case 4:
//                System.out.println("Digite o código:");
//                String id = sc.nextLine();
//                imprimirEstoque(null, id, null);
                break;
            case 5:
//                System.out.println("Digite o nome ou parte dele: ");
//                String nome = sc.nextLine();
//                imprimirEstoque(null,null,nome);
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

}

