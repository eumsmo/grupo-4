package diario.diario.diario;

import diario.diario.views.*;
import utils.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Juan
 */
@WebServlet(urlPatterns = {"/diario/diario/diario/deletar"})
public class Deletar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	/*
            ? especifico:String[conteudo,atividade] - String que filtra deletar entre conteudo e atividade
                especifico = "conteudo" - deleta apenas conteudo
                especifico = "atividade" - deleta apenas atividade
            ? conteudo:int - id do conteudo a ser deletado
            ? matricula:int - id da matricula a ser deletado
	 */

		PrintWriter out = response.getWriter();

		try {
			Connection conexao = ConnectionFactory.getDiario();
			DiarioRepository repositorio = new DiarioRepository(conexao);
			DiarioParametros p = new DiarioParametros(request);

			if (!(p.getFalta() == null && p.getNota() == null)) {
				repositorio.remover(p);
			} else {
				throw new ExcecaoParametroIncorreto("Nenhum parametro selecionado!", "Ao menos um dos parametros deve estar presente: 'matricula' ou 'conteudo'");
			}

			SucessoView view = new SucessoView("Atualizado com sucesso!");
			view.render(out);

		} catch (SQLException e) {
			response.setStatus(500);
			ErroView erro = new ErroView("Erro no banco de dados!", e.getMessage());
			erro.render(out);
			e.printStackTrace();
		} catch (ExcecaoNaoAutorizado e) {
			response.setStatus(403);
			ErroView erro = new ErroView(e.mensagem, e.causa);
			erro.render(out);
			e.printStackTrace();
		} catch (ExcecaoPadrao e) {
			response.setStatus(400);
			ErroView erro = new ErroView(e.mensagem, e.causa);
			erro.render(out);
			e.printStackTrace();
		}

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
