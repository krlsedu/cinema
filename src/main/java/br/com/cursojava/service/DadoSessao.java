package br.com.cursojava.service;

import br.com.cursojava.model.Ator;
import br.com.cursojava.model.Sessao;
import br.com.cursojava.model.enums.TipoSessao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadoSessao extends CarregaArquivo {
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\sessoes.csv";

    private final List<Sessao> sessoes;

    private final DadoFilme dadoFilme;
    private final DadoSala dadoSala;

    public DadoSessao(DadoFilme dadoFilme, DadoSala dadoSala) {
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
                    } else {
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
    }

    public Sessao getSessaoPorId(Integer id) {
        for (Sessao sessao : sessoes) {
            if (sessao.getIdSessao().equals(id)) {
                return sessao;
            }
        }
        return null;
    }

    public List<Sessao> getSessoesPor(String valor) {
        List<Sessao> sessaoList = new ArrayList<>();
        for (Sessao sessao : sessoes) {
            if (sessao.getFilme().getTitulo().equalsIgnoreCase(valor) ||
                    sessao.getFilme().getGenero().getDescricao().equalsIgnoreCase(valor)) {
                sessaoList.add(sessao);
            } else {
                for (Ator ator : sessao.getFilme().getAtores()) {
                    if (ator.getNome().equalsIgnoreCase(valor)) {
                        sessaoList.add(sessao);
                    }
                }
            }
        }
        return sessaoList;
    }

    public void printSessoes() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Informe um ator, gênero ou filme para filtrar, caso queira listar todas sessões digite TODOS");
        Scanner scanner = new Scanner(System.in);
        String valor = scanner.nextLine();
        List<Sessao> sessaoList;
        if (valor.equalsIgnoreCase("TODOS")) {
            sessaoList = sessoes;
        } else {
            sessaoList = getSessoesPor(valor);
        }
        if (sessaoList.isEmpty()) {
            System.out.println("Não há sessões para listar com o filtro aplicado");
        }
        for (Sessao sessao : sessaoList) {
            System.out.printf("%d - Filme: %s\nDia: %s\nHorário: %dh\n", sessao.getIdSessao(),
                    sessao.getFilme().getTitulo(),
                    df.format(sessao.getDataSessao()),
                    sessao.getHora());
        }
    }
}
