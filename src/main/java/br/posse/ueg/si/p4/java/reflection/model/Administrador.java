/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.posse.ueg.si.p4.java.reflection.model;

/**
 *
 * @author willi
 */
public class Administrador {

    private Integer id;
    private String nome;
    private int idade;
    private String telefoneFixo;

    public Administrador(Integer id, String nome, int idade, String telefoneFixo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.telefoneFixo = telefoneFixo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    @Override
    public String toString() {
        return "" + id + "," + "'" + nome + "'," + "" + idade + "," + telefoneFixo;
    }

}
