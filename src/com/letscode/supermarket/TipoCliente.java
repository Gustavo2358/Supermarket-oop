package com.letscode.supermarket;

enum TipoCliente {
    PF(0, "Pessoa Física"),
    PJ(0.05, "Pessoa Jurídica"),
    VIP(0.15, "VIP");

    private final double desconto;
    private final String descricao;

    TipoCliente(double desconto, String descricao) {
        this.desconto = desconto;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double valorDescontar(double totalCompra) { return this.desconto * totalCompra;}
}

