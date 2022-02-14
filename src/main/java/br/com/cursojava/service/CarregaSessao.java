package br.com.cursojava.service;

import br.com.cursojava.model.Sessao;
import br.com.cursojava.model.enums.TipoSessao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CarregaSessao extends CarregaArquivo{
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\sessoes.csv";

    private final List<Sessao> sessoes;
    private final DadoFilme dadoFilme;
    private final DadoSala dadoSala;

    public CarregaSessao(DadoFilme dadoFilme, DadoSala dadoSala) {
        this.dadoFilme = dadoFilme;
        this.dadoSala = dadoSala;
        sessoes = new ArrayList<>();
        lerDadosArquivo();
    }

    @Override
    public void lerDadosArquivo() {
        try {
            List<String> linhasArquivo = getLinhas(CAMINHO_ARQUIVO);

            for (int i = 0; i < linhasArquivo.size(); i++) {
                String linha = linhasArquivo.get(i);
                try {
                    String[] linhaSplit = linha.split(",");
                    var sessao = new Sessao();
                    sessao.setIdSessao(Integer.parseInt(linhaSplit[0]));
                    sessao.setSala(dadoSala.getSalaPorNumero(Integer.parseInt(linhaSplit[1])));
                    sessao.setFilme(dadoFilme.getFilmePorTitulo(linhaSplit[2]));
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    sessao.setDataSessao(df.parse(linhaSplit[3]));
                    sessao.setHora(Integer.parseInt(linhaSplit[4]));
                    sessao.setValorIngresso(Double.parseDouble(linhaSplit[5]));
                    sessao.setAberta("S".equals(linhaSplit[6]));
                    if ("3D".equals(linhaSplit[7])) {
                        sessao.setTipoSessao(TipoSessao.EM_3D);
                    }else {
                        sessao.setTipoSessao(TipoSessao.EM_2D);
                    }
                    sessoes.add(sessao);
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para uma sala\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
        System.out.println(sessoes);
    }
}
