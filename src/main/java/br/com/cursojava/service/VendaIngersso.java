package br.com.cursojava.service;

import br.com.cursojava.VendaException;
import br.com.cursojava.model.Ingresso;
import br.com.cursojava.model.Sessao;
import br.com.cursojava.model.enums.TipoIngresso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendaIngersso {
    private final DadoSessao dadoSessao;
    private final List<Ingresso> ingressos;

    public VendaIngersso(DadoSessao dadoSessao) {
        this.dadoSessao = dadoSessao;
        ingressos = new ArrayList<>();
    }

    public void vende() {
        System.out.println("Informe o código da sessão:");
        Scanner scanner = new Scanner(System.in);
        int idSessao = scanner.nextInt();
        Ingresso ingresso = new Ingresso();
        Sessao sessao = dadoSessao.getSessaoPorId(idSessao);
        if (sessao == null) {
            System.out.println("Sessão inválida");
        } else {
            try {

                ingresso.setSessao(sessao);

                System.out.println("Informe o tipo de Ingresso: N - normal, E - Estudante, S - Senior, P - Promocional");
                scanner = new Scanner(System.in);
                String opcao = scanner.nextLine();
                switch (opcao.toUpperCase()) {
                    case "N":
                        ingresso.setTipoIngresso(TipoIngresso.NORMAL);
                        break;
                    case "E":
                        ingresso.setTipoIngresso(TipoIngresso.ESTUDANTE);
                        break;
                    case "S":
                        ingresso.setTipoIngresso(TipoIngresso.SENIOR);
                        break;
                    case "P":
                        ingresso.setTipoIngresso(TipoIngresso.PROMOCIONAL);
                        break;
                    default:
                        System.out.println("tipo de ingresso inválido! considerando Normal");
                        ingresso.setTipoIngresso(TipoIngresso.NORMAL);
                        break;
                }

                validaVenda(ingresso, sessao);

                ingressos.add(ingresso);
            } catch (VendaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validaVenda(Ingresso ingresso, Sessao sessao) throws VendaException {
        if (!sessao.getAberta()) {
            throw new VendaException("Não é possível vender ingressos para sessões fechadas");
        }

        if (sessao.getIngressosVendidos() < sessao.getSala().getCapacidade()) {
            sessao.setIngressosVendidos(sessao.getIngressosVendidos() + 1);
            Double valorIngresso = sessao.getValorIngresso();
            valorIngresso -= valorIngresso * (ingresso.getTipoIngresso().getDesconto() / 100D);
            ingresso.setPreco(valorIngresso);
        } else {
            throw new VendaException("Não há mais lugares disponíveis!");
        }
    }

    public void imprimeVendas() {
        Double totalVendas = 0D;
        for (Ingresso ingresso : ingressos) {
            totalVendas += ingresso.getPreco();
        }
        System.out.printf("Resumo das vendas:\n Total de ingressos vendidos: %d \n Valor total: R$ %,.2f\n", ingressos.size(), totalVendas);
    }
}
