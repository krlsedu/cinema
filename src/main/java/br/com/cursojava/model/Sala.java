package br.com.cursojava.model;

public class Sala {
    private Integer idSala;
    private Integer capacidade;

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala=" + idSala +
                ", capacidade=" + capacidade +
                '}';
    }
}
