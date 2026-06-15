package com.bramura.controlefinanceiroapi.service;

import com.bramura.controlefinanceiroapi.ControlefinanceiroapiApplication;
import com.bramura.controlefinanceiroapi.dto.TransacaoDTO;
import com.bramura.controlefinanceiroapi.dto.SaldoDTO;
import com.bramura.controlefinanceiroapi.dto.ResumoDTO;
import com.bramura.controlefinanceiroapi.exception.TransacaoNaoEncontradaException;
import com.bramura.controlefinanceiroapi.model.Transacao;
import com.bramura.controlefinanceiroapi.repository.TransacaoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository, ControlefinanceiroapiApplication controlefinanceiroapiApplication) {
    this.repository = repository;
}

    // LISTAR
    public List<Transacao> listarTransacao() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Transacao buscarPorId(Long id) {
        
        return repository.findById(id)
                .orElseThrow(() -> new TransacaoNaoEncontradaException("Transação não encontrada"));
    }

    // CRIAR
    public Transacao criarTransacao(TransacaoDTO dto) {

        Transacao transacao = new Transacao();

        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setTipo(dto.getTipo());
        transacao.setCategoria(dto.getCategoria());

        return repository.save(transacao);
    }

    // ATUALIZAR
    public Transacao atualizarTransacao(Long id, TransacaoDTO dto) {
        
        Transacao transacao = buscarPorId(id);

        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setTipo(dto.getTipo());
        transacao.setCategoria(dto.getCategoria());

        return repository.save(transacao);
    }

    // DELETAR
    public void deletarTransacao(Long id) {

        buscarPorId(id);

        repository.deleteById(id);
    }

    public List<Transacao> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public List<Transacao> buscarPorTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public SaldoDTO calcularSaldo() {

        List<Transacao> transacoes = repository.findAll();

        double totalReceitas = 0;
        double totalDespesas = 0;

        for (Transacao transacao : transacoes) {

            if ("receita".equalsIgnoreCase(transacao.getTipo())) {
                totalReceitas += transacao.getValor();
            }

            if ("despesa".equalsIgnoreCase(transacao.getTipo())) {
                totalDespesas += transacao.getValor();
            }
        }

        double saldo = totalReceitas - totalDespesas;

        return new SaldoDTO(totalReceitas, totalDespesas, saldo);
    }

    public ResumoDTO calcularResumo() {
        
        List<Transacao> transacoes = repository.findAll();

        long quantidadeReceitas = 0;
        long quantidadeDespesas = 0;
        
        double totalReceitas = 0;
        double totalDespesas = 0;

        for (Transacao transacao : transacoes) {

            if ("receita".equalsIgnoreCase(transacao.getTipo())) {
                
                quantidadeReceitas++;
                totalReceitas += transacao.getValor();

            } else if ("despesa".equalsIgnoreCase(transacao.getTipo())) {
                
                quantidadeDespesas++;
                totalDespesas += transacao.getValor();
            }          
        }

        double saldo = totalReceitas - totalDespesas;

        return new ResumoDTO(quantidadeReceitas, quantidadeDespesas, totalReceitas, totalDespesas, saldo);
    }
}
