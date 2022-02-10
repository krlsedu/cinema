package br.com.cursojava.model.enums;

public enum TipoIngresso {
    ESTUDANTE(50),
    PROMOCIONAL(40),
    SENIOR(50);

    private Integer desconto;

    TipoIngresso(Integer desconto) {
        this.desconto = desconto;
    }
}
