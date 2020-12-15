package com.br.purple.repository;

import com.br.purple.model.ListarPessoa;
import com.br.purple.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "select pes_id as id, pes_nome as nome from pessoa where pes_perfil = ?1", nativeQuery = true)
    List<ListarPessoa> listaPessoaPorPerfil(String perfil);

    @Query(value = "select id, nome, perfil from Pessoa where login = ?1 and senha = ?2 ", nativeQuery = false)
    Object[] findFiltroUsuario(String login, String senha);
}
