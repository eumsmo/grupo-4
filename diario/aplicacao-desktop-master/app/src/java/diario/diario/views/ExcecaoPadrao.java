/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

/**
 * @author juanr
 */
public class ExcecaoPadrao extends Exception {

	public String causa = null, mensagem = null;

	public ExcecaoPadrao(String causa, String mensagem) {
		this.causa = causa;
		this.mensagem = mensagem;
	}

	public ExcecaoPadrao(String string) {
		super(string);
		this.mensagem = string;
		this.causa = null;
	}

	@Override
	public String getMessage() {
		return this.mensagem;
	}

}
