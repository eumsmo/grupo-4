package diario.diario.conteudos;
/*
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

/**
 * @author Juan
 */

/*public class Consulta extends HttpServlet {

	protected void processRequest{

		PrintWriter out = response.getWriter();

		try {
			DiarioAutenticador autenticador = new DiarioAutenticador(request, response);
			if (!(autenticador.cargoLogado() == DiarioCargos.ADMIN || autenticador.cargoLogado() == DiarioCargos.PROFESSOR || autenticador.cargoLogado() == DiarioCargos.ALUNO)) {
				throw new ExcecaoNaoAutorizado("Você não tem permissão para essa operação");
			}

			Connection conexao = ConnectionFactory.getDiario();
			ConteudosRepository repositorio = new ConteudosRepository(conexao);
			ConteudosParametros p = new ConteudosParametros(request);
			p.obrigatorios("disciplina");

			ArrayList<ConteudosModel> resultado;

			if (p.existe("tipo")) {
				resultado = repositorio.consulta(p, p.getTipo());
			} else {
				resultado = repositorio.consulta(p);
			}

			ConteudosView view = new ConteudosView(resultado);
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

	
	
	
}
*/