package com.bramura.controlefinanceiroapi.dto;

public class ApiResponse<T> {

    private String mensagem;
    private T dados;

    public ApiResponse(String mensagem, T dados) {
        this.mensagem = mensagem;
        this.dados = dados;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public T getDados() {
        return dados;
    }
}
