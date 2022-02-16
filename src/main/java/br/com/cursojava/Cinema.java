package br.com.cursojava;

import br.com.cursojava.service.*;

public class Cinema {
    public static void main(String[] args) {
        var dadosAtor = new DadoAtor();
        var dadosGenero = new DadoGenero();
        var dadosSala = new DadoSala();
        var dadosFilme = new DadoFilme(dadosAtor, dadosGenero);
        var dadosSessao = new DadoSessao(dadosFilme, dadosSala);

        Menu menu = new Menu(dadosSessao);
        menu.iniciaMenu();
    }
}
