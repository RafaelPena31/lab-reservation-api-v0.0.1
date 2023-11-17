package com.agendamento0.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Reserva")
public class ModelReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String email;
    public Date data;

    @ManyToOne
    @JoinColumn(name = "laboratorio_ID", nullable = false)
    public ModelLaboratorio laboratorio;

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ModelLaboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(ModelLaboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
