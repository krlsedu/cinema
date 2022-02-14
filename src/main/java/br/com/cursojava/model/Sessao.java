package br.com.cursojava.model;

import br.com.cursojava.model.enums.TipoSessao;

import java.util.Date;

public class Sessao {
    private Integer idSessao;
    private Sala sala;
    private Filme filme;
    private Date dataSessao;
    private Integer hora;
    private Double valorIngresso;
    private Boolean aberta;
    private TipoSessao tipoSessao;

    public Integer getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Integer idSessao) {
        this.idSessao = idSessao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(Date dataSessao) {
        this.dataSessao = dataSessao;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(Double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public Boolean getAberta() {
        return aberta;
    }

    public void setAberta(Boolean aberta) {
        this.aberta = aberta;
    }

    public TipoSessao getTipoSessao() {
        return tipoSessao;
    }

    public void setTipoSessao(TipoSessao tipoSessao) {
        this.tipoSessao = tipoSessao;
    }

    @Override
    public String toString() {
        return "Sessao{" +
                "idSessao=" + idSessao +
                ", sala=" + sala +
                ", filme=" + filme +
                ", dataSessao=" + dataSessao +
                ", hora=" + hora +
                ", valorIngresso=" + valorIngresso +
                ", aberta=" + aberta +
                ", tipoSessao=" + tipoSessao +
                '}';
    }
}
