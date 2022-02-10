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
}
