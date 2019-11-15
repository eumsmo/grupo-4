package app.diario.diario.controllers;

import app.diario.diario.repository.DepartamentoRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ModalRemoverController {

    private int id;
    private boolean status;

    @FXML
    private Button apagarBtn;

    @FXML
    private Label aviso;

    @FXML
    private ChoiceBox<?> campusCb;

    @FXML
    private Button cancelarBtn;

    @FXML
    void apagarDepartamento(ActionEvent event) {
        try {
            DepartamentoRepository.remove(this.id);

            Stage modal = (Stage) cancelarBtn.getScene().getWindow();
            status = true;
            modal.close();
        } catch (SQLException e) {
            aviso.setText("Não foi possível remover o departamento");
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        status = false;
        modal.close();
    }

    public boolean getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }
}
