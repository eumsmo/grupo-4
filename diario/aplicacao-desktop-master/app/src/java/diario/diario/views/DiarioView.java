/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.views;

import diario.diario.diario.DiarioModel;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author juanr
 */
public class DiarioView {

	ArrayList<DiarioModel> diarios;

	public DiarioView(ArrayList<DiarioModel> diarios) {
		this.diarios = diarios;
	}

	public void render(PrintWriter out) {
		out.print(gerar());
	}

	public String gerar() {
		String resultado = "<info>\n";

		for (DiarioModel diario : diarios) {
			String diarioUnicoXML = "<diario>\n";
			diarioUnicoXML += "<id-conteudos>" + diario.getIdConteudo() + "</id-conteudos>\n";
			diarioUnicoXML += "<id-matriculas>" + diario.getIdMatricula() + "</id-matriculas>\n";

			if (diario.getFalta() != null) {
				diarioUnicoXML += "<faltas>" + diario.getNota() + "</faltas>\n";
			}
			if (diario.getNota() != null) {
				diarioUnicoXML += "<nota>" + diario.getNota() + "</nota>\n";
			}

			diarioUnicoXML += "</diario>\n";
			resultado += diarioUnicoXML;
		}

		return resultado + "</info>";
	}
}
