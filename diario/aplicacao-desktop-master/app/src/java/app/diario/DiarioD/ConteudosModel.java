/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.diario.DiarioD;

import java.sql.Date;
import java.util.Calendar;
import javafx.scene.control.Button;

/**
 * @author juanr
 */
public class ConteudosModel {

	Integer id = null, idEtapa = null, idDisciplina = null;
	String conteudo = null;
        Button Deletar,Editar,Faltas;
	String data = null;
	Double valor = null;

	public ConteudosModel() {
	}

    public ConteudosModel(Button Deletar, Button Editar, Button Faltas) {
        this.Deletar = Deletar;
        this.Editar = Editar;
        this.Faltas = Faltas;
    }

	public ConteudosModel(int id, int idEtapa, int idDisciplina, String conteudo,String data, Double valor) {
		this.id = id;
		this.idEtapa = idEtapa;
		this.idDisciplina = idDisciplina;
		this.conteudo = conteudo;
		this.valor = valor;
		//setData(data);
	}

	public ConteudosModel(int idEtapa, int idDisciplina, String conteudo, String data, Double valor) {
		this.idEtapa = idEtapa;
		this.idDisciplina = idDisciplina;
		this.conteudo = conteudo;
		this.valor = valor;
		//setData(data);
	}

	public ConteudosModel(int idEtapa, int idDisciplina, String conteudo,String data) {
		this.idEtapa = idEtapa;
		this.idDisciplina = idDisciplina;
		this.conteudo = conteudo;
		//setData(data);
		valor = null;
	}

	/* Getters e Setters */
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.add(Calendar.DATE, 1);
		//this.data = new Date(c.getTimeInMillis());
	}

}
