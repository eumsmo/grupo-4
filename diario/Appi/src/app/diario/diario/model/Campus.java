package app.diario.diario.model;

import javafx.scene.layout.HBox;

public class Campus {

    private int id;

    private String nome, uf, cidade;
     private HBox hbox;

    public Campus(int id, String nome, String uf, String cidade) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
