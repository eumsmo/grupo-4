package diario.departamentos.controllers;

import diario.departamentos.repository.DepartamentoRepository;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ModalConfirmacaoController {
    
    private static int id;
    
    @FXML
    private Button apagarBtn;

    @FXML
    private Button cancelarBtn;

    @FXML
    void apagarDepartamento(ActionEvent event) throws SQLException, IOException {
        DepartamentoRepository.remove(this.id);
        
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();
    }

    public static void setId(int id) {
        ModalConfirmacaoController.id=id;
    }
}
