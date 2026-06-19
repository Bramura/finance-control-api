package com.bramura.controlefinanceiroapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", "Erro de validação");
        resposta.put("erros", erros);

        return resposta;
    }

    @ExceptionHandler(TransacaoNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String, String> handleTransacaoNaoEncontrada(TransacaoNaoEncontradaException ex) {

        Map<String, String> erro = new HashMap<>();

        erro.put("erro", ex.getMessage());

        return erro;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String, String> handleEnumInvalido(HttpMessageNotReadableException ex) {

        Map<String, String> erro = new HashMap<>();

        erro.put("erro", "Tipo inválido. Valores permitidos: RECEITA ou DESPESA.");

        return erro;
    }
}
