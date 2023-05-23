package br.edu.atitus.pooavancado.CadUsuario.Entities;

public class Produto {
    private int Id;
    private String Nome;
    private double ValorUnitario;

    public Produto(int id, String nome, double valorUnitario) {
        this.Id = id;
        this.Nome = nome;
        this.ValorUnitario = valorUnitario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.ValorUnitario = valorUnitario;
    }
}
