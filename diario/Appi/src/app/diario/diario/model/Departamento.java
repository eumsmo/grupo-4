package app.diario.diario.model;

import app.diario.diario.controllers.ModalRemoverController;
import app.diario.diario.controllers.ModalEditarController;
import app.diario.diario.controllers.TableController;
import app.diario.diario.repository.DepartamentoRepository;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.layout.Pane;

public class Departamento {

    private int id, idCampi;
    private String nome, nomeCampi, ufCampi, cidadeCampi;
    private Button btns[];
    private HBox hbox;

    public Departamento() {
        this(0, 0, "", "", "", "");
    }

    public Departamento(int id, int idCampi, String nome, String nomeCampi, String ufCampi, String cidadeCampi) {
        this.id = id;
        this.idCampi = idCampi;
        this.nome = nome;
        this.nomeCampi = nomeCampi;
        this.ufCampi = ufCampi;
        this.cidadeCampi = cidadeCampi;
        btns = new Button[2];
        hbox = new HBox();
        btns[0] = new Button("EDITAR");
        btns[1] = new Button("DELETAR");
        btns[0].getStyleClass().add("editar");
        btns[1].getStyleClass().add("deletar");
        hbox.getChildren().add(0, btns[0]);
        hbox.getChildren().add(1, btns[1]);
        btnSetup(this.id);
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox vbox) {
        this.hbox = vbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCampi() {
        return idCampi;
    }

    public void setIdCampi(int idCampi) {
        this.idCampi = idCampi;
    }

    public Button[] getBtns() {
        return btns;
    }

    public void setBtns(Button[] btns) {
        this.btns = btns;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCampi() {
        return this.nomeCampi;
    }

    public void setNomeCampi(String nomeCampi) {
        this.nomeCampi = nomeCampi;
    }

    public String getUfCampi() {
        return ufCampi;
    }

    public void setUfCampi(String ufCampi) {
        this.ufCampi = ufCampi;
    }

    public String getCidadeCampi() {
        return cidadeCampi;
    }

    public void setCidadeCampi(String cidadeCampi) {
        this.cidadeCampi = cidadeCampi;
    }

    public void btnSetup(int id) {
        btns[0].setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    editarDepto(event);
                } catch (SQLException ex) {
                    System.err.println(ex);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
        btns[1].setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    removerDepto(event);
                } catch (SQLException ex) {
                    System.err.println(ex);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
    }

    private void editarDepto(Event event) throws SQLException, IOException {
        Stage modalEditar = new Stage();
        FXMLLoader modalEditarFXMLLoader = new FXMLLoader(getClass().getResource("/app/diario/departamentos/ModalEditar.fxml"));

        Parent modalEditarParent = (Parent) modalEditarFXMLLoader.load();
        ModalEditarController modalEditarController = modalEditarFXMLLoader.<ModalEditarController>getController();
        modalEditarController.setData(this.id, this.idCampi, this.nome);

        modalEditar.setScene(new Scene(modalEditarParent));
        modalEditar.initOwner(((Node) event.getSource()).getScene().getWindow());
        modalEditar.initModality(Modality.APPLICATION_MODAL);
        modalEditar.showAndWait();
        boolean status = modalEditarController.getStatus();

        Stage table = (Stage) btns[1].getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane tabelaDepartamentosRoot = fxmlLoader.load(getClass().getResource("/app/diario/departamentos/TabelaDepartamentos.fxml").openStream());
        TableController tableController = (TableController) fxmlLoader.getController();

        if (status) {
            tableController.setAviso("Departamento editado com sucesso", 1);
        }

        Scene scene = new Scene(tabelaDepartamentosRoot);
        scene.getStylesheets().add("/app/diario/departamentos/EstiloDepartamentos.css");
        table.setScene(scene);
    }

    private void removerDepto(Event event) throws SQLException, IOException {
        Stage modalRemover = new Stage();
        FXMLLoader modalRemoverFXMLLoader = new FXMLLoader(getClass().getResource("/app/diario/departamentos/ModalRemover.fxml"));

        Parent modalRemoverParent = (Parent) modalRemoverFXMLLoader.load();
        ModalRemoverController modalRemoverController = modalRemoverFXMLLoader.<ModalRemoverController>getController();
        modalRemoverController.setId(this.id);

        modalRemover.setScene(new Scene(modalRemoverParent));
        modalRemover.initOwner(((Node) event.getSource()).getScene().getWindow());
        modalRemover.initModality(Modality.APPLICATION_MODAL);
        modalRemover.showAndWait();
        boolean status = modalRemoverController.getStatus();

        Stage table = (Stage) btns[1].getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane tabelaDepartamentosRoot = fxmlLoader.load(getClass().getResource("/app/diario/departamentos/TabelaDepartamentos.fxml").openStream());
        TableController tableController = (TableController) fxmlLoader.getController();

        if (status) {
            tableController.setAviso("Departamento removido com sucesso", 1);
        }

        Scene scene = new Scene(tabelaDepartamentosRoot);
        scene.getStylesheets().add("/app/diario/departamentos/EstiloDepartamentos.css");
        table.setScene(scene);
    }
}
