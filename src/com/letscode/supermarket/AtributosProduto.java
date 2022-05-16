package com.letscode.supermarket;

public enum AtributosProduto {
    TIPO("TIPO"),
    MARCA("MARCA"),
    ID("ID"),
    NOME("NOME"),
    PRECO_CUSTO("PRECO_CUSTO"),
    QTD("QTD"),
    DATA_COMPRA("DATA_COMPRA"),
    PRECO_VENDA("PRECO_VENDA"),
    ESTOQUE("ESTOQUE");

    private final String estoque;

    AtributosProduto(String estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return estoque;
    }
}
