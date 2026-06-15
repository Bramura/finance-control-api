package com.bramura.controlefinanceiroapi.controller;

import com.bramura.controlefinanceiroapi.model.Transacao;
import com.bramura.controlefinanceiroapi.dto.TransacaoDTO;
import com.bramura.controlefinanceiroapi.dto.SaldoDTO;
import com.bramura.controlefinanceiroapi.dto.ApiResponse;
import com.bramura.controlefinanceiroapi.dto.ResumoDTO;
import com.bramura.controlefinanceiroapi.service.TransacaoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
    this.service = service;
}

    // LISTAR TODAS AS TRANSAÇÕES
    @GetMapping("/")
    public ResponseEntity<List<Transacao>> listar() {
        return ResponseEntity.ok(service.listarTransacao());
    }

    // BUSCAR POR ID    
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // CRIAR
    @PostMapping("/")
    public ResponseEntity<Transacao> criar(@Valid @RequestBody TransacaoDTO dto) {  
        
        Transacao transacaoCriada = service.criarTransacao(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoCriada);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @Valid @RequestBody TransacaoDTO dto) {
        
        return ResponseEntity.ok(service.atualizarTransacao(id, dto));
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        
        service.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Transacao>> buscarPorCategoria(
        @PathVariable String categoria) {

        return ResponseEntity.ok(
            service.buscarPorCategoria(categoria)
        );
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> buscarPorTipo(
        @PathVariable String tipo) {

        return ResponseEntity.ok(
            service.buscarPorTipo(tipo)
        );
    }

    @GetMapping("/saldo")
    public ResponseEntity<ApiResponse<SaldoDTO>> calcularSaldo() {

        SaldoDTO saldo = service.calcularSaldo();

        ApiResponse<SaldoDTO> resposta = new ApiResponse<>("Saldo calculado com sucesso",saldo);

        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/resumo")
    public ResponseEntity<ApiResponse<ResumoDTO>> obterResumo() {

        ResumoDTO resumo = service.calcularResumo();

        ApiResponse<ResumoDTO> resposta = new ApiResponse<>("Resumo calculado com sucesso",resumo);

        return ResponseEntity.ok(resposta);
    }
    
}