package diario.departamentos.controllers;

import diario.departamentos.repository.DepartamentoRepository;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModalAdicionarController {

    @FXML
    private TextField nomeTf;

    @FXML
    private TextField campusTf;

    @FXML
    private Button adicionarBtn;

    @FXML
    private Button cancelarBtn;

    @FXML
    void adicionarDepartamento(ActionEvent event) throws SQLException {
        String nome = nomeTf.getText();
        Integer campus = Integer.parseInt(campusTf.getText());
        DepartamentoRepository.insere(campus, nome);      
        
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();
    }

}
