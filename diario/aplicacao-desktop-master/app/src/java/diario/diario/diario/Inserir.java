package diario.diario.diario;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Inserir extends  {

	protected void processRequest() throws  {
	/*
            conteudo:int - id do conteudo a ser lançada a falta ou nota
            matricula:int - id da matricula a ser lançada a falta ou nota
            tipo:String[conteudo,atividade] - String que especifica se esta sendo lançado a um conteudo ou atividade,
                tipo = "conteudo" - permite que seja inserido a falta mas não a nota
                tipo = "atividade" - permite que seja inserido a nota
            falta:int - quantidade de faltas do aluno
            nota:Double - nota do aluno
	 */

		PrintWriter out = response.getWriter();

		try {
			Connection conexao = ConnectionFactory.getDiario();
			DiarioRepository repositorio = new DiarioRepository(conexao);
			//DiarioParametros p = new DiarioParametros(request);
			//p.obrigatorios("conteudo", "matricula", "tipo");

			/*if (p.getTipo().equals("atividade")) {
				p.obrigatorios("falta", "nota");
			} else {
				p.obrigatorios("falta");
			}*/

			if (repositorio.insere(p)) {
				SucessoView view;

				if (p.getTipo().equals("atividade")) {
					view = new SucessoView("Nota lançada com sucesso!");
				} else {
					view = new SucessoView("Falta lançada com sucesso!");
				}

				view.render(out);
			} else {
				ErroView view = new ErroView();
				view.render(out);
			}

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
			Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(Inserir.class.getName()).log(Level.SEVERE, null, ex);
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
