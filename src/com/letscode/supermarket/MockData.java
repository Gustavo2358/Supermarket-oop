package com.letscode.supermarket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//TODO classe para debug, apagar depois
public class MockData {
    public static final Produto nescau = new Produto(TipoProduto.ALIMENTOS,
            "Nestle",
            "abc123",
            "Nescau",
            BigDecimal.valueOf(4.00),
            50,
            LocalDateTime.now(),
            TipoProduto.ALIMENTOS.calcularPrecoVenda(BigDecimal.valueOf(4.00)),
            50);

    public static final Produto donPerrengue = new Produto(TipoProduto.BEBIDA,
                "La Madre",
                "wer123",
                "don perrengue",
                BigDecimal.valueOf(10),
                20,
                LocalDateTime.now(),
                TipoProduto.BEBIDA.calcularPrecoVenda(BigDecimal.valueOf(10.00)),
                20);

    public static final Produto softButt = new Produto(TipoProduto.HIGIENE,
                "Neve",
                "asd234",
                "Soft Butt",
                BigDecimal.valueOf(12),
                200,
                LocalDateTime.now(),
                TipoProduto.HIGIENE.calcularPrecoVenda(BigDecimal.valueOf(12.00)),
                200);
}
