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
public class Auxiliar {

    private Integer id;
    private String name;
    private int dtNascimento;
    private String sobre;

    public Auxiliar(Integer id, String name, int dtNascimento, String sobre) {
        this.id = id;
        this.name = name;
        this.dtNascimento = dtNascimento;
        this.sobre = sobre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(int dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    @Override
    public String toString() {
        return id + ",'" + name + "','" + dtNascimento + "','" + sobre + "'";
    }

}
