package com.show.web_ingressos.model;

public class Setor {
    private String nome;
    private double preco;
    private int capacidadeTotal;
    private int ingressosVendidos;

    public Setor(String nome, double preco, int capacidadeTotal) {
        this.nome = nome;
        this.preco = preco;
        this.capacidadeTotal = capacidadeTotal;
    }

    public boolean temDisponibilidade() { return ingressosVendidos < capacidadeTotal; }
    public void venderIngresso() { this.ingressosVendidos++; }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getRestante() { return capacidadeTotal - ingressosVendidos; }
}