package com.br.purple.repository;

import com.br.purple.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository  extends JpaRepository<Historico, Long> {
}
