package diario.diario.conteudos;
/*
import app.diario.DiarioD.DbConnector;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import diario.diario.views.ErroView;
import diario.diario.views.ExcecaoNaoAutorizado;
import diario.diario.views.ExcecaoPadrao;
import diario.diario.views.SucessoView;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.ConnectionFactory;


public class Inserir implements Initializable {

    @FXML
    private TextField nomeInput;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Label idDeptoLabel;

    @FXML
    private TextField idInput;

    @FXML
    private Label idLabel;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField idDeptoInput;

    @FXML
    private TextField horasInput;

    @FXML
    private Label modalidadeLabel;

    @FXML
    private TextField modalidadeInput;

    @FXML
    private Label horasLabel;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label labelError;

    

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   /* public void fecha() {
        InsereMain.getStage().close();
    }

    public static boolean isNum(String strNum) {
        boolean ret = true;
        try {

            Double.parseDouble(strNum);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }


	
			/*DiarioAutenticador autenticador = new DiarioAutenticador(request, response);
			if (!(autenticador.cargoLogado() == DiarioCargos.ADMIN || autenticador.cargoLogado() == DiarioCargos.PROFESSOR)) {
				throw new ExcecaoNaoAutorizado("Você não tem permissão para essa operação");
			}

			Connection conexao = ConnectionFactory.getDiario();
			ConteudosRepository repositorio = new ConteudosRepository(conexao);
			//ConteudosParametros p = new ConteudosParametros(request);
			//p.obrigatorios("etapa", "disciplina", "conteudo", "data");

			//repositorio.insere();

			SucessoView view;
			if (p.existe("valor") && p.getValor() > 0.0) {
				view = new SucessoView("Atividade adicionada com sucesso!");
			} else {
				view = new SucessoView("Conteudo adicionado com sucesso!");
			}
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