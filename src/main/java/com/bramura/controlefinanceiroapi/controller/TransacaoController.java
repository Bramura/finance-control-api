package com.bramura.controlefinanceiroapi.controller;

import com.bramura.controlefinanceiroapi.model.TipoTransacao;
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
    public ResponseEntity<ApiResponse<List<Transacao>>> listar() {

        List<Transacao> transacoes = service.listarTransacao();

        ApiResponse<List<Transacao>> resposta = new ApiResponse<>("Transações listadas com sucesso", transacoes);

        return ResponseEntity.ok(resposta);
    }

    // BUSCAR POR ID    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Transacao>> buscarPorId(@PathVariable Long id) {
        
        Transacao transacao = service.buscarPorId(id);

        ApiResponse<Transacao> resposta = new ApiResponse<>("Transação encontrada com sucesso", transacao);

        return ResponseEntity.ok(resposta);
    }

    // CRIAR
    @PostMapping("/")
    public ResponseEntity<ApiResponse<Transacao>> criar(@Valid @RequestBody TransacaoDTO dto) {  
        
        Transacao transacaoCriada = service.criarTransacao(dto);

        ApiResponse<Transacao> resposta = new ApiResponse<>("Transação criada com sucesso", transacaoCriada);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Transacao>> atualizar(@PathVariable Long id, @Valid @RequestBody TransacaoDTO dto) {
        
        Transacao transacaoAtualizada = service.atualizarTransacao(id, dto);

        ApiResponse<Transacao> resposta = new ApiResponse<>("Transação atualizada com sucesso", transacaoAtualizada);
        
        return ResponseEntity.ok(resposta);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletar(@PathVariable Long id) {
        
        service.deletarTransacao(id);

        ApiResponse<String> resposta = new ApiResponse<>("Transação removida com sucesso", null);

        return ResponseEntity.ok(resposta);
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
        @PathVariable TipoTransacao tipo) {

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