package br.com.tiago.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
    private String nomeProduto;
    private Long quantidade;
    private LocalDate dataUltimaVenda;

    public String getNomeProduto() {
        return nomeProduto;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", dataUltimaVenda=" + dataUltimaVenda +
                '}';
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    public RelatorioDeVendasVo(String nomeProduto, Long quantidade, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.dataUltimaVenda = dataUltimaVenda;
    }


}
