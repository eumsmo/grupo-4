/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.conteudos;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author juanr
 */
public class ConteudosView {

	ArrayList<ConteudosModel> conteudos;

	public ConteudosView(ArrayList<ConteudosModel> conteudos) {
		this.conteudos = conteudos;
	}

	public void render(PrintWriter out) {
		out.print(gerar());
	}

	public String gerar() {
		String resultado = "<info>\n";

		for (ConteudosModel conteudo : conteudos) {

			String conteudoUnicoXML = "<conteudo>\n";
			conteudoUnicoXML += "<id>" + conteudo.getId() + "</id>\n";
			conteudoUnicoXML += "<id-etapas>" + conteudo.getIdEtapa() + "</id-etapas>\n";
			conteudoUnicoXML += "<id-disciplinas>" + conteudo.getIdDisciplina() + "</id-disciplinas>\n";
			conteudoUnicoXML += "<conteudos>" + conteudo.getConteudo() + "</conteudos>\n";
			conteudoUnicoXML += "<data>" + conteudo.getData() + "</data>\n";
			conteudoUnicoXML += "<valor>" + conteudo.getValor() + "</valor>\n";
			conteudoUnicoXML += "</conteudo>\n";
			resultado += conteudoUnicoXML;
		}

		return resultado + "</info>";
	}
}
