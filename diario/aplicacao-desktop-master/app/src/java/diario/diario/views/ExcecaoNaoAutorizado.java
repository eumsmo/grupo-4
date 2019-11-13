/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

/**
 * @author Aluno
 */
public class ExcecaoNaoAutorizado extends ExcecaoPadrao {

	public ExcecaoNaoAutorizado(String causa, String mensagem) {
		super(causa, mensagem);
	}

	public ExcecaoNaoAutorizado(String mensagem) {
		super(mensagem);
	}
}
