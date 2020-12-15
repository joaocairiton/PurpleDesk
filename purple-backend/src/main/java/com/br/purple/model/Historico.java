package com.br.purple.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "his_id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private OrdemServico ordemId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pes_id_func")
    private Pessoa funcionario;

    @NotNull
    @Column(name = "his_data")
    private Date dataFechamentoHistorico;

    @NotNull
    @Pattern(regexp = "ABERTO|EXECUTANDO|REALIZADO")
    @Column(name = "his_status")
    private String statusHistorico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdemServico getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(OrdemServico ordemId) {
        this.ordemId = ordemId;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataFechamentoHistorico() {
        return dataFechamentoHistorico;
    }

    public void setDataFechamentoHistorico(Date dataFechamentoHistorico) {
        this.dataFechamentoHistorico = dataFechamentoHistorico;
    }

    public String getStatusHistorico() {
        return statusHistorico;
    }

    public void setStatusHistorico(String statusHistorico) {
        this.statusHistorico = statusHistorico;
    }
}
