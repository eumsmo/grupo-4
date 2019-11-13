/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

/**
 * @author juanr
 */
public class ExcecaoParametroIncorreto extends ExcecaoPadrao {

	public ExcecaoParametroIncorreto(String causa, String mensagem) {
		super(causa, mensagem);
	}

	public ExcecaoParametroIncorreto(String string) {
		super(string);
	}
}
