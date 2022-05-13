package com.letscode.supermarket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Produto {
    private final TipoProduto tipo;
    private final String marca;
    private final String id;
    private final String nome;
    private BigDecimal precoCusto;
    private int quantidade;
    private LocalDateTime dataCompra;
    private BigDecimal precoVenda;
    private int estoque;
    private final Scanner scanner = new Scanner(System.in);

    //getters
    public TipoProduto getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    //setters
    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Produto() {
        this.tipo = recebeTipo();
        System.out.println("Marca:");
        this.marca = scanner.nextLine();
        System.out.println("código Identificador:");
        this.id = scanner.nextLine().replaceAll("\\s+", "");
        System.out.println("Nome do produto:");
        this.nome = scanner.nextLine();
        this.precoCusto = recebePrecoCusto();
        this.quantidade = recebeQuantidade();
        this.dataCompra = LocalDateTime.now() ;
        this.precoVenda = this.tipo.calcularPrecoVenda(this.precoCusto);
        this.estoque = this.quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "tipo=" + tipo +
                ", marca='" + marca + '\'' +
                ", id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", precoCusto=" + precoCusto +
                ", quantidade=" + quantidade +
                ", dataCompra=" + dataCompra +
                ", precoVenda=" + precoVenda +
                ", estoque=" + estoque +
                '}';
    }

    private int recebeQuantidade() {
        int qtd = 0;
        System.out.println("Digite a quantidade: ");
        do {
            String qtdString = scanner.nextLine();
            try {
                qtd = Integer.parseInt(qtdString);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido");
            }
            if(qtd <=0){
                System.out.println("A quantidade deve ser maior do que zero.");
            }
        }while(qtd <= 0);
        return qtd;
    }

    private TipoProduto recebeTipo() {
        System.out.println("Tipo do produto: (ALIMENTOS - BEBIDA - HIGIENE)");

        String tipo;
        do{
            tipo = this.scanner.nextLine().toUpperCase().replaceAll("\\s+","");
            if(tipo.equals("ALIMENTOS") == false
                    && tipo.equals("BEBIDA") == false
                    && tipo.equals("HIGIENE") == false){
                System.out.println("Digite um dos tipos válidos -> ALIMENTOS - BEBIDA - HIGIENE");
            }
        }while(!tipo.equals("ALIMENTOS") && !tipo.equals("BEBIDA") && !tipo.equals("HIGIENE"));
        return TipoProduto.valueOf(tipo);
    }

    private BigDecimal recebePrecoCusto(){
        boolean isValid = false;
        BigDecimal preco = null;

        System.out.println("Digite o preço: ");
        do {
            try {
                String precoString = scanner.nextLine().replace(",", ".");
                preco = new BigDecimal(precoString);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor decimal válido");
            }
        }while(isValid == false);
        return preco;
    }

}
