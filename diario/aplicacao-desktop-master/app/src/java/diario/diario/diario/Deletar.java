package diario.diario.diario;
/*
import diario.diario.views.*;
import utils.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/diario/diario/diario/deletar"})
public class Deletar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	/*
            ? especifico:String[conteudo,atividade] - String que filtra deletar entre conteudo e atividade
                especifico = "conteudo" - deleta apenas conteudo
                especifico = "atividade" - deleta apenas atividade
            ? conteudo:int - id do conteudo a ser deletado
            ? matricula:int - id da matricula a ser deletado
	 

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

	

}
*/