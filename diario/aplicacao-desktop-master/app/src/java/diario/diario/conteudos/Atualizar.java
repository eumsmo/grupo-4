package diario.diario.conteudos;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Juan
 */

public class Atualizar e {

	
	/*
            id :int - id do conteudo/atividade a ser alterado
            ? etapa:int - id da etapa
            ? disciplina:int - id da disciplina
            ? conteudo:String - nome do conteudo/atividade
            ? valor:Double - valor maximo da atividade
	 */
		PrintWriter out = response.getWriter();

		try {
			DiarioAutenticador autenticador = new DiarioAutenticador(request, response);
			if (!(autenticador.cargoLogado() == DiarioCargos.ADMIN || autenticador.cargoLogado() == DiarioCargos.PROFESSOR)) {
				throw new ExcecaoNaoAutorizado("Você não tem permissão para essa operação");
			}

			Connection conexao = ConnectionFactory.getDiario();
			ConteudosRepository repositorio = new ConteudosRepository(conexao);
			ConteudosParametros p = new ConteudosParametros(request);
			p.obrigatorios("id");

			repositorio.atualizar(p);

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
			Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
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
