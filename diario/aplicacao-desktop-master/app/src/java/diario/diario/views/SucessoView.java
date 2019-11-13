/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

import java.io.PrintWriter;

/**
 * @author juan
 */
public class SucessoView {

	String mensagem, causa;

	public SucessoView(String mensagem, String causa) {
		this.mensagem = mensagem;
		this.causa = causa;
	}

	public SucessoView(String mensagem) {
		this.mensagem = mensagem;
		this.causa = null;
	}

	public SucessoView() {
		this("Operação bem sucedida!");
	}

	public void render(PrintWriter out) {
		out.print(gerar());
	}

	public String gerar() {
		String resposta = "<info>\n"
			+ "<sucesso>\n"
			+ "<mensagem>" + mensagem + "</mensagem>\n";
		if (causa != null) {
			resposta += "<causa>" + causa + "</causa>\n";
		}
		resposta += "</sucesso>\n"
			+ "</info>";
		return resposta;
	}
}
