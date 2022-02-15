package br.com.cursojava.model.enums;

public enum TipoIngresso {
    ESTUDANTE(50),
    PROMOCIONAL(40),
    SENIOR(50),
    NORMAL(0);

    private Integer desconto;

    TipoIngresso(Integer desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "TipoIngresso{" +
                "desconto=" + desconto +
                '}';
    }

    public Integer getDesconto() {
        return desconto;
    }
}
