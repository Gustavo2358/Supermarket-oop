package com.letscode.supermarket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SupermarketUtils {
    public static void imprimirTabela(List<String> tableLabels, ArrayList<? extends TablePrintable> entradas, List<String> atributos){
        //cabeçalho
//        final int CELL_SIZE = tableLabels.stream()
//                .map (name -> name.length())
//                .max (Integer::compare)
//                .get() + 1; //Mais um para o espaço adicional no início da célula

        //outra forma
        final int CELL_SIZE = tableLabels.stream()
                .max (Comparator.comparingInt(String::length))
                .get()
                .length() + 1; //Mais um para o espaço adicional no início da célula



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

        //produtos
        entradas.forEach(entrada -> System.out.println(entrada.toTable(atributos, cellFormat)));

        //linha final
        for (int k = 0; k < tableLabels.size(); k++) {
            System.out.print(hyphens);
        }
        System.out.println("+");

    }

}
