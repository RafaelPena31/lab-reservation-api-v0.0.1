package com.agendamento0.model;

import javax.persistence.*;

@Entity
@Table(name = "Laboratorio")
public class ModelLaboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String nome;
    public int qtdComputadores;

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdComputadores() {
        return qtdComputadores;
    }

    public void setQtdComputadores(int qtdComputadores) {
        this.qtdComputadores = qtdComputadores;
    }
}
