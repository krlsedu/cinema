package br.com.cursojava.model;

import br.com.cursojava.model.enums.TipoIngresso;

public class Ingresso {
    private TipoIngresso tipoIngresso;
    private Sessao sessao;
    private Double preco;

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
