/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

import java.io.PrintWriter;

/**
 * @author Aluno
 */
public class ErroView {

	String mensagem, causa;

	public ErroView(ExcecaoPadrao erro) {
		this(erro.mensagem, erro.causa);
	}

	public ErroView(String mensagem, String causa) {
		this.mensagem = mensagem;
		this.causa = causa;
	}

	public ErroView(String mensagem) {
		this.mensagem = mensagem;
		this.causa = null;
	}

	public ErroView() {
		this("Ocorreu um erro!");
	}

	public void render(PrintWriter out) {
		out.print(gerar());
	}

	public String gerar() {
		String resposta = "<info>\n"
			+ "<erro>\n"
			+ "<mensagem>" + mensagem + "</mensagem>\n";
		if (causa != null) {
			resposta += "<causa>" + causa + "</causa>\n";
		}
		resposta += "</erro>"
			+ "</info>";
		return resposta;
	}
}
