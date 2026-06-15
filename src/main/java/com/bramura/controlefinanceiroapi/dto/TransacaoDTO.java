package com.bramura.controlefinanceiroapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransacaoDTO {

    @NotBlank(message = "O campo 'descricao' é obrigatório.")
    private String descricao;

    @NotNull(message = "O campo 'valor' é obrigatório.")
    private Double valor;

    @NotBlank(message = "O campo 'tipo' é obrigatório.")
    private String tipo;

    @NotBlank(message = "O campo 'categoria' é obrigatório.")
    private String categoria;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
