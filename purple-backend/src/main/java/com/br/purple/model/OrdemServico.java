package com.br.purple.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordem_id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tps_id")
    private TipoServico descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "lab_id")
    private LaboratorioSala labNome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pes_id_func")
    private Pessoa funcionario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pes_id_cli")
    private Pessoa cliente;

    @NotNull
    @Column(name = "ordem_data_emissao")
    private Date dataEmissao;


    @Column(name = "ordem_data_fechamento")
    private Date dataFechamento;

    @NotNull
    @Pattern(regexp = "Aberto|Executando|Fechado|Cancelado")
    @Column(name = "ordem_status")
    private String status;


    @Column(name = "ordem_descricao")
    private String descricaoServ;

    @NotNull
    @Column(name = "ordem_local")
    private String local;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoServico getDescricao() {
        return descricao;
    }

    public void setDescricao(TipoServico descricao) {
        this.descricao = descricao;
    }

    public LaboratorioSala getLabNome() {
        return labNome;
    }

    public void setLabNome(LaboratorioSala labNome) {
        this.labNome = labNome;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoServ() {
        return descricaoServ;
    }

    public void setDescricaoServ(String descricaoServ) {
        this.descricaoServ = descricaoServ;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
