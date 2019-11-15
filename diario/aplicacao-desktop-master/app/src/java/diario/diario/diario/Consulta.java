package diario.diario.diario;
/*
import diario.diario.views.DiarioView;
import diario.diario.views.ErroView;
import diario.diario.views.ExcecaoNaoAutorizado;
import diario.diario.views.ExcecaoPadrao;
import utils.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Consulta extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	/*
            [tipo:String[conteudo,atividade]] - String que filtra consulta entre conteudo e atividade
                tipo = "conteudo" - mostra apenas conteudo
                tipo = "atividade" - mostra apenas atividade
            conteudo:int - id do conteudo a ser consultado
            [matricula:int] - id da matricula a ser consultado
	 *//*

		PrintWriter out = response.getWriter();

		try {
			Connection conexao = ConnectionFactory.getDiario();
			DiarioRepository repositorio = new DiarioRepository(conexao);
			DiarioParametros p = new DiarioParametros(request);

			ArrayList<DiarioModel> resultado;
			resultado = repositorio.consulta(p);
			DiarioView view = new DiarioView(resultado);
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

	
}
*/