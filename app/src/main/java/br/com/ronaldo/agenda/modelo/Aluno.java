package br.com.ronaldo.agenda.modelo;

import java.io.Serializable;

/**
 * Created by Ronaldo on 02/10/2017.
 */
//implementa serializable para poder ser colocado como putExtra na intent (assim vira um binário)
public class Aluno implements Serializable{
    private Long   id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private Double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString(){
        return  getId()+" - "+getNome()+"    - "+getEndereco()+"\n - "+getTelefone()+" - "+getSite()+" - "+getNota();
    }
}
