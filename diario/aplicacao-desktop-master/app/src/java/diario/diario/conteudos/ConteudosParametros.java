/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.conteudos;

import diario.diario.views.ExcecaoPadrao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * @author juanr
 */
public class ConteudosParametros extends ConteudosModel {

	protected String tipo;
	protected HttpServletRequest request;

	public ConteudosParametros() {

	}

	public ConteudosParametros(HttpServletRequest request) throws ExcecaoPadrao {
		setParametros(request);
	}

	/* UTIL */
	public static boolean existe(HttpServletRequest req, String parametro) {
		return req.getParameter(parametro) != null;
	}

	public void setParametros(HttpServletRequest request) throws ExcecaoPadrao {
		this.request = request;

		if (existe(request, "id")) {
			setId(request.getParameter("id"));
		}
		if (existe(request, "etapa")) {
			setIdEtapa(request.getParameter("etapa"));
		}
		if (existe(request, "disciplina")) {
			setIdDisciplina(request.getParameter("disciplina"));
		}
		if (existe(request, "conteudo")) {
			setConteudo(request.getParameter("conteudo"));
		}
		if (existe(request, "valor")) {
			setValor(request.getParameter("valor"));
		}
		if (existe(request, "data")) {
			setData(request.getParameter("data"));
		}
		if (existe(request, "tipo")) {
			setTipo(request.getParameter("tipo"));
		}
	}

	public boolean existe(HttpServletRequest request, String... parametros) {
		for (String parametro : parametros) {
			if (!existe(request, parametro)) {
				return false;
			}
		}
		return true;
	}

	public boolean existe(String... parametros) {
		for (String parametro : parametros) {
			if (!existe(request, parametro)) {
				return false;
			}
		}
		return true;
	}

	public void obrigatorios(HttpServletRequest request, String... parametros) throws ExcecaoPadrao {
		for (String parametro : parametros) {
			if (!existe(request, parametro)) {
				throw new ExcecaoPadrao("Erro com '" + parametro + "'", "O parametro '" + parametro + "' é obrigatório!");
			}
		}
	}

	public void obrigatorios(String... parametros) throws ExcecaoPadrao {
		for (String parametro : parametros) {
			if (!existe(request, parametro)) {
				throw new ExcecaoPadrao("Erro com '" + parametro + "'", "O parametro '" + parametro + "' é obrigatório!");
			}
		}
	}

	/* ERROS */
	public ExcecaoPadrao erroDecimal(String parametro) {
		return new ExcecaoPadrao(parametro + " deve ser decimal!", "O parametro " + parametro + " não está no formato correto");
	}

	public ExcecaoPadrao erroInteiro(String parametro) {
		return new ExcecaoPadrao(parametro + " deve ser inteiro!", "O parametro " + parametro + " não está no formato correto");
	}

	public ExcecaoPadrao erroData(String parametro) {
		return new ExcecaoPadrao(parametro + " deve ser uma data!", "O parametro " + parametro + " não está no formato correto");
	}

	public ExcecaoPadrao erroStringVazia(String parametro) {
		return new ExcecaoPadrao(parametro + " não pode estar vazio!", "O parametro " + parametro + " não pode estar vazio");
	}

	/* Getters e Setters */
	public void setId(String id) throws ExcecaoPadrao {
		try {
			this.id = Integer.valueOf(id);
		} catch (NumberFormatException e) {
			throw erroInteiro("conteudo");
		}
	}

	public void setIdEtapa(String idEtapa) throws ExcecaoPadrao {
		try {
			this.idEtapa = Integer.valueOf(idEtapa);
		} catch (NumberFormatException e) {
			throw erroInteiro("etapa");
		}
	}

	public void setIdDisciplina(String idDisciplina) throws ExcecaoPadrao {
		try {
			this.idDisciplina = Integer.valueOf(idDisciplina);
		} catch (NumberFormatException e) {
			throw erroInteiro("disciplina");
		}
	}

	@Override
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setData(String data) throws ExcecaoPadrao {
		try {
			this.data = Date.valueOf(data);
		} catch (Exception e) {
			throw erroData("data");
		}
	}

	public void setValor(String valor) throws ExcecaoPadrao {
		try {
			this.valor = Double.valueOf(valor);
		} catch (NumberFormatException e) {
			throw erroDecimal("valor");
		}
		if (this.valor < 0) {
			throw new ExcecaoPadrao("O valor não pode ser negativo!", "O campo valor aceita apenas numeros positivos");
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws ExcecaoPadrao {
		if (!("conteudo".equals(tipo) || "atividade".equals(tipo))) {
			throw new ExcecaoPadrao("'tipo' não esta formatado corretamente", "O 'tipo' pode ser 'conteudo' ou 'atividade'");
		}

		this.tipo = tipo;
	}

}
