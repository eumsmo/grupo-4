package app.diario.diario.controllers;

import app.diario.diario.model.Campus;
import app.diario.diario.model.Departamento;
import app.diario.diario.repository.DepartamentoRepository;
import app.diario.diario.utils.Validacao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

public class ModalEditarController implements Initializable {

    private ObservableList<Campus> campusObservableList;
    private ObservableList<String> choiceBoxObservableList;
    private ObservableList<Departamento> deptoObservableList;

    private String nome;

    private int idCampi, id;
    private boolean status;

    private String mensagem;

    @FXML
    private Label aviso;

    @FXML
    private TextField nomeTf;

    @FXML
    private ChoiceBox<String> campusCb;

    @FXML
    private Button cancelarBtn;

    @FXML
    private Button editarBtn;

    @FXML
    void editarDepartamento(ActionEvent event) {
        try {
            System.out.println(campusCb.getValue());
            if (nomeTf.getText().isEmpty() || campusCb.getValue() == null) {
                setAviso("Por favor, verifique o preenchimento dos campos abaixo.");
            } else {
                System.out.println("1");
                String nome = nomeTf.getText();
                String campus = campusCb.getValue();

                for (Campus c : campusObservableList) {
                    if ((c.getNome() + " - " + c.getCidade() + " - " + c.getUf()).equals(campus)) {

                        idCampi = c.getId();
                        break;
                    }
                }

                if (!Validacao.validaNome(nome)) {
                    setAviso("Nome inválido(Excede 255 caracteres).");
                } else {
                    DepartamentoRepository.atualiza(id, idCampi, nome);
                    Stage modal = (Stage) cancelarBtn.getScene().getWindow();
                    status = true;
                    modal.close();
                }
            }
        } catch (SQLException e) {
            setAviso("Não foi possível editar o departamento.");
        }
    }

    ;

    @FXML
    void cancelar(ActionEvent event) {
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        status = false;
        modal.close();
    }

    public void setData(int i, int idc, String n) {
        id = i;
        idCampi = idc;
        nome = n;
    }

    public void setAviso(String aviso) {
        this.aviso.setText(aviso);
    }

    public void setChoiceBox() throws SQLException {
        campusObservableList = FXCollections.observableArrayList(DepartamentoRepository.consultaCampi());
        deptoObservableList = FXCollections.observableArrayList(DepartamentoRepository.consulta());
        choiceBoxObservableList = FXCollections.observableArrayList();
        for (Campus c : campusObservableList) {
            choiceBoxObservableList.add(c.getNome() + " - " + c.getCidade() + " - " + c.getUf());
            if (idCampi == c.getId()) {
                campusCb.setValue(c.getNome() + " - " + c.getCidade() + " - " + c.getUf());
            }
        }
        campusCb.setItems(choiceBoxObservableList);
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            this.nomeTf.setText(this.nome);
            try {
                setChoiceBox();
            } catch (SQLException ex) {
                setAviso("Houve um erro ao editar o departamento");
            }
        });
    }
}
