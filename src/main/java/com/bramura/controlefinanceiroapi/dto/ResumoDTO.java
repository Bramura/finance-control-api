package com.bramura.controlefinanceiroapi.dto;

public class ResumoDTO {
    
    private Long quantidadeReceitas;
    private Long quantidadeDespesas;
    private Double totalReceitas;
    private Double totalDespesas;
    private Double saldo;

    public ResumoDTO(Long quantidadeReceitas, Long quantidadeDespesas, Double totalReceitas, Double totalDespesas, Double saldo) {
        
        this.quantidadeReceitas = quantidadeReceitas;
        this.quantidadeDespesas = quantidadeDespesas;
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldo = saldo;
    }

    public Long getQuantidadeReceitas() {
        return quantidadeReceitas;
    }

    public Long getQuantidadeDespesas() {
        return quantidadeDespesas;
    }

    public Double getTotalReceitas() {
        return totalReceitas;
    }

    public Double getTotalDespesas() {
        return totalDespesas;
    }

    public Double getSaldo() {
        return saldo;
    }
}
