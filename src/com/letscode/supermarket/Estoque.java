package com.letscode.supermarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estoque {

    ArrayList<Produto> estoque = new ArrayList<>();


    public void cadastrarComprar() {
        //cadastrar o produto no estoque caso o estoque estiver vazio.
        Produto produtoNovo = new Produto();
        if(estoque.size() == 0){
            estoque.add(produtoNovo);
            return;
        }

        //se o produdo já existe no estoque, "setar" os novos valores da compra.
        for(Produto produtoEstoque : estoque){
            if (produtoNovo.getId().equals(produtoEstoque.getId())){
                produtoEstoque.setPrecoCusto(produtoNovo.getPrecoCusto());
                produtoEstoque.setQuantidade(produtoNovo.getQuantidade());
                produtoEstoque.setDataCompra(produtoNovo.getDataCompra());
                produtoEstoque.setPrecoVenda(produtoNovo.getPrecoVenda());
                produtoEstoque.setEstoque(produtoEstoque.getEstoque() + produtoNovo.getEstoque());
                return;
            }
        }

        //caso o produto não exista no estoque, cadastrar novo produto.
        estoque.add(produtoNovo);
    }

    public void imprimeEstoque(){
        List<String> tableLabels = Arrays.asList("TIPO","MARCA","IDENTIFICADOR","NOME","PREÇO DE CUSTO","QTD ULTIMA COMPRA","DATA DA COMPRA",
                "PREÇO DE VENDA", "ESTOQUE");
        List<String> atributos = List.of(AtributosProduto.TIPO.toString(),
                AtributosProduto.MARCA.toString(),
                AtributosProduto.ID.toString(),
                AtributosProduto.NOME.toString(),
                AtributosProduto.PRECO_CUSTO.toString(),
                AtributosProduto.QTD.toString(),
                AtributosProduto.DATA_COMPRA.toString(),
                AtributosProduto.PRECO_VENDA.toString(),
                AtributosProduto.ESTOQUE.toString()
        );
        SupermarketUtils.imprimirTabela(tableLabels, this.estoque, atributos);
    }
}
