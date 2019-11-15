package diario.diario.conteudos;
/*
import diario.diario.views.ErroView;
import diario.diario.views.ExcecaoNaoAutorizado;
import diario.diario.views.ExcecaoPadrao;
import diario.diario.views.SucessoView;
import utils.ConnectionFactory;
import utils.autenticador.DiarioAutenticador;
import utils.autenticador.DiarioCargos;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Juan
 

public class Deletar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	/*
            ? id:int - id do conteudo/atividade
            ? etapa:int - id da etapa
            ? disciplina:int - id da disciplina

	 

		PrintWriter out = response.getWriter();

		try {
			DiarioAutenticador autenticador = new DiarioAutenticador(request, response);
			if (!(autenticador.cargoLogado() == DiarioCargos.ADMIN || autenticador.cargoLogado() == DiarioCargos.PROFESSOR)) {
				throw new ExcecaoNaoAutorizado("Você não tem permissão para essa operação");
			}
			Connection conexao = ConnectionFactory.getDiario();
			ConteudosRepository repositorio = new ConteudosRepository(conexao);
			ConteudosParametros p = new ConteudosParametros(request);
			p.setParametros(request);

			repositorio.remover(p);

			SucessoView view = new SucessoView("Deletado com sucesso!");
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

	
	

}*/
