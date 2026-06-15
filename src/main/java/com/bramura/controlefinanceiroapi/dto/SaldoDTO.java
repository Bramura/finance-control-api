package com.bramura.controlefinanceiroapi.dto;

public class SaldoDTO {

    private Double totalReceitas;
    private Double totalDespesas;
    private Double saldo;

    public SaldoDTO(Double totalReceitas, Double totalDespesas, Double saldo) {
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldo = saldo;
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
