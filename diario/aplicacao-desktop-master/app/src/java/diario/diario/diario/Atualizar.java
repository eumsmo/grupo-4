package diario.diario.diario;
/*
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


public class Atualizar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	/*
            conteudo:int - id do conteudo a ser alterado
            matricula:int - id da matricula a ser alterado
            ? falta:int - quantidade de faltas do aluno
            ? nota:Double - nota do aluno
	 *//*

		PrintWriter out = response.getWriter();

		try {
			Connection conexao = ConnectionFactory.getDiario();
			DiarioRepository repositorio = new DiarioRepository(conexao);
			DiarioParametros p = new DiarioParametros(request);
			p.obrigatorios("conteudo", "matricula");

			DiarioModel filtro = new DiarioModel(p.getIdConteudo(), p.getIdMatricula());

			if (!(p.getFalta() == null && p.getNota() == null)) {
				repositorio.atualizar(p, filtro);
			} else {
				throw new ExcecaoParametroIncorreto("Nenhuma alteração detectada!", "Nenhum parametro de modificação recebido");
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