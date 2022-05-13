package com.letscode.supermarket;

import java.util.ArrayList;

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
        estoque.forEach(a -> System.out.println(a.toString()));
    }
}
