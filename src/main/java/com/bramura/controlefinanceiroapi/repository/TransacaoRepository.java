package com.bramura.controlefinanceiroapi.repository;

import com.bramura.controlefinanceiroapi.model.Transacao;
import com.bramura.controlefinanceiroapi.model.TipoTransacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByCategoria(String categoria);

    List<Transacao> findByTipo(TipoTransacao tipo);
}
