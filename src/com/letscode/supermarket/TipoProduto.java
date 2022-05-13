package com.letscode.supermarket;

import java.math.BigDecimal;

enum TipoProduto {
    ALIMENTOS(BigDecimal.valueOf(1.2)),
    BEBIDA(BigDecimal.valueOf(2.3)),
    HIGIENE(BigDecimal.valueOf(1.5));

    private final BigDecimal markup;

    TipoProduto(BigDecimal markup) {
        this.markup = markup;
    }

    public BigDecimal calcularPrecoVenda(BigDecimal precoCusto){
        return this.markup.multiply(precoCusto);
    }
}
