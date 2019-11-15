package app.diario.diario.controllers;

import app.diario.diario.model.Campus;
import app.diario.diario.repository.DepartamentoRepository;
import app.diario.diario.utils.Validacao;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ModalAdicionarController implements Initializable {

    private ObservableList<Campus> campusObservableList;
    private ObservableList<String> choiceBoxObservableList;

    private String mensagem;

    private int idCampi;

    private boolean status;

    @FXML
    private Label aviso;

    @FXML
    private TextField nomeTf;

    @FXML
    private ChoiceBox<String> campusCb;

    @FXML
    private Button adicionarBtn;

    @FXML
    private Button cancelarBtn;

    @FXML
    void adicionarDepartamento(ActionEvent event) {
        try {
            if (nomeTf.getText().isEmpty() || campusCb.getValue() == null) {
                setAviso("Por favor, verifique o preenchimento dos campos abaixo.");
            } else {
                String nome = nomeTf.getText();
                String campus = campusCb.getValue();

                for (Campus c : campusObservableList) {
                    if ((c.getNome() + " - " + c.getCidade() + " - " + c.getUf()).equals(campus)) {
                        idCampi = c.getId();
                    }
                }

                if (!Validacao.validaNome(nome)) {
                    setAviso("Nome inválido(Excede 255 caracteres).");
                } else {
                    DepartamentoRepository.insere(idCampi, nome);
                    Stage modal = (Stage) cancelarBtn.getScene().getWindow();
                    status = true;
                    modal.close();
                }
            }
        } catch (SQLException e) {
            status = false;
            setAviso("Não foi possível adicionar o departamento.");
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();
    }

    public void setChoiceBox() throws SQLException {
        campusObservableList = FXCollections.observableArrayList(DepartamentoRepository.consultaCampi());
        choiceBoxObservableList = FXCollections.observableArrayList();
        for (Campus c : campusObservableList) {
            choiceBoxObservableList.add(c.getNome() + " - " + c.getCidade() + " - " + c.getUf());
        }
        campusCb.setItems(choiceBoxObservableList);
    }

    public void setAviso(String aviso) {
        this.aviso.setText(aviso);
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aviso.getStylesheets().add("/app/diario/departamentos/Departamentos.css");
        aviso.getStyleClass().add("aviso-erro");
        try {
            setChoiceBox();
        } catch (SQLException ex) {
            setAviso("Houve um erro ao carregar os campi");
        }
    }
}
