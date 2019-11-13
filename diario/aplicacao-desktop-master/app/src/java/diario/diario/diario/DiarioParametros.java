/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.diario;

import diario.diario.views.ExcecaoPadrao;



/**
 * @author juanr
 */
public class DiarioParametros extends DiarioModel {

	protected String tipo;
	

	

	

	public void obrigatorios(String... parametros) throws ExcecaoPadrao {
		for (String parametro : parametros) {
			
				throw new ExcecaoPadrao("Erro com '" + parametro + "'", "O parametro '" + parametro + "' é obrigatório!");
			
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

	/* GETTERS E SETTERS*/
	public void setIdConteudo(String idConteudo) throws ExcecaoPadrao {
		try {
			this.idConteudo = Integer.valueOf(idConteudo);
		} catch (Exception e) {
			throw erroInteiro("conteudo");
		}
	}

	public void setIdMatricula(String idMatricula) throws ExcecaoPadrao {
		try {
			this.idMatricula = Integer.valueOf(idMatricula);
		} catch (Exception e) {
			throw erroInteiro("matricula");
		}
	}

	public void setFalta(String falta) throws ExcecaoPadrao {
		try {
			this.falta = Integer.valueOf(falta);
		} catch (Exception e) {
			throw erroInteiro("falta");
		}
	}

	public void setNota(String nota) throws ExcecaoPadrao {
		try {
			this.nota = Double.valueOf(nota);
		} catch (Exception e) {
			throw erroDecimal("nota");
		}
	}

	@Override
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

