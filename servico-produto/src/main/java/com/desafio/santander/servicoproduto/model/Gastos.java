package com.desafio.santander.servicoproduto.model;

import javax.persistence.*;

@Entity
@Table(name = "gastos")
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private float valor;

    @Column(name = "data")
    private String data;

    public Gastos() {
        super();
    }

    public Gastos( String descricao, float valor, String data) {
        super();
        setCategoria("Nenhuma");
        this.descricao = descricao;
        this.valor = valor;
        setData(data);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
