package com.br.purple.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "laboratorio_sala")
public class LaboratorioSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_id")
    private Long id;

    @NotNull
    @Column(name = "lab_nome")
    private String labNome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabNome() {
        return labNome;
    }

    public void setLabNome(String labNome) {
        this.labNome = labNome;
    }
}
