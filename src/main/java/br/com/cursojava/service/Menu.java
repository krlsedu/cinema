package br.com.cursojava.service;

import java.util.Scanner;

public class Menu {
    private final VendaIngersso vendaIngersso;
    private final DadoSessao dadoSessao;

    public Menu(DadoSessao dadoSessao) {
        this.dadoSessao = dadoSessao;
        this.vendaIngersso = new VendaIngersso(this.dadoSessao);
    }

    public void iniciaMenu() {
        boolean continua = true;
        do {

            System.out.println("O que você deseja fazer: 1 - vender ingresso; 2 - listar sessões; 3 - imprimir resumo de vendas; 99 - sair");
            Scanner scanner = new Scanner(System.in);
            int operacao = scanner.nextInt();
            switch (operacao) {
                case 1:
                    vendaIngersso.vende();
                    break;
                case 2:
                    dadoSessao.printSessoes();
                    break;
                case 3:
                    vendaIngersso.imprimeVendas();
                    break;
                case 99:
                    continua = false;
            }
        } while (continua);
    }
}
