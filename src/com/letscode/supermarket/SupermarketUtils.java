package com.letscode.supermarket;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SupermarketUtils {
    public static void imprimirTabela(List<String> tableLabels, Stream<? extends TablePrintable> entradas, List<String> atributos){
        //cabeçalho
        final int CELL_SIZE = tableLabels.stream()
                .map (String::length)
                .max (Integer::compare)
                .get() + 1; //Mais um para o espaço adicional no início da célula

//        //outra forma
//        final int CELL_SIZE = tableLabels.stream()
//                .max (Comparator.comparingInt(String::length))
//                .get()
//                .length() + 1; //Mais um para o espaço adicional no início da célula



        String hyphens = "+" + "-".repeat(CELL_SIZE);
        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");
        String  cellFormat = "| %-"+ (CELL_SIZE - 1) +"s";
        for (String tableLabel : tableLabels) {
            System.out.printf( cellFormat, tableLabel);
        }
        System.out.println("|");

        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");

        //imprimir entradas
        entradas.forEach(entrada -> System.out.println(entrada.toTable(atributos, cellFormat)));

        //linha final
        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");
    }


    public static TipoProduto recebeTipoProduto(){
        Scanner sc = new Scanner(System.in);
        String tipo;
        do{
            tipo = sc.nextLine().toUpperCase().replaceAll("\\s+","");
            if(!tipo.equals("ALIMENTOS") && !tipo.equals("BEBIDA") && !tipo.equals("HIGIENE")){
                System.out.println("Digite um dos tipos válidos -> ALIMENTOS - BEBIDA - HIGIENE");
            }
        }while(!tipo.equals("ALIMENTOS") && !tipo.equals("BEBIDA") && !tipo.equals("HIGIENE"));
        return TipoProduto.valueOf(tipo);

    }

}
