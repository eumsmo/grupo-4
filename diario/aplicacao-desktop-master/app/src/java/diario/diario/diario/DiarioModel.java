/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.diario;

/**
 * @author juanr
 */
public class DiarioModel {

	protected Integer idConteudo, idMatricula, falta;
	protected Double nota;

	public DiarioModel() {
		idConteudo = null;
		idMatricula = null;
		falta = null;
		nota = null;
	}

	public DiarioModel(int idConteudo, int idMatricula) {
		this.idConteudo = idConteudo;
		this.idMatricula = idMatricula;
		this.falta = null;
		this.nota = null;
	}

	public DiarioModel(int idConteudo, int idMatricula, int falta) {
		this.idConteudo = idConteudo;
		this.idMatricula = idMatricula;
		this.falta = falta;
		this.nota = null;
	}

	public DiarioModel(int idConteudo, int idMatricula, int falta, Double nota) {
		this.idConteudo = idConteudo;
		this.idMatricula = idMatricula;
		this.falta = falta;
		this.nota = nota;
	}

	public DiarioModel(int idConteudo, int idMatricula, Double nota) {
		this.idConteudo = idConteudo;
		this.idMatricula = idMatricula;
		this.nota = nota;
		this.falta = null;
	}

	/* GETTERS E SETTERS*/
	public Integer getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(int idConteudo) {
		this.idConteudo = idConteudo;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Integer getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getTipo() {
		return nota == 0.0 ? "conteudo" : "atividade";
	}
}
