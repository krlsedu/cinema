package br.com.cursojava;

import br.com.cursojava.service.*;

public class Cinema {
    public static void main(String[] args) {
        var dadosAtor = new DadoAtor();
        var dadoGenero = new DadoGenero();
        var dadosSala = new DadoSala();
        var dadoFilme = new DadoFilme(dadosAtor, dadoGenero);
        var dadoSessao = new DadoSessao(dadoFilme, dadosSala);
    }
}
