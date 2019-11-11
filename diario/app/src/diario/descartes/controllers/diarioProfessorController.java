/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.descartes.controllers;

import diario.descartes.repository.DescartesRep;
import java.sql.Date;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class diarioProfessorController {

    @FXML
    private TableColumn Conteudo;
    @FXML
    private TableColumn EtapaConteudo;
    @FXML
    private TableColumn DataConteudo;
    @FXML
    private TableColumn Atividade;
    @FXML
    private TableColumn EtapaAtividade;
    @FXML
    private TableColumn DataAtividade;
    @FXML
    private Button AdicionarAtividade;

    @FXML
    private DatePicker Data;

    @FXML
    private Button Enviar;

    @FXML
    private Button cancelarBtn;

    @FXML			
    void EnviarDescarte(ActionEvent event) throws SQLException {
       /* String IDFuncionario = IdFuncionario.getText();
        String motivo = motivacao.getText();
        Date data= (Date) Data.getDayCellFactory();
        Integer NumeroAcervo = Integer.parseInt(NumeroDoAcervo.getText());
       // DepartamentoRepository.insere(IDFuncionario, NumeroAcervo);      
       
        DescartesRep.insereDescartesEremoveAcervo(motivo, IDFuncionario, NumeroAcervo, data);
      
        Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();*/
    }

    @FXML
    void cancelar(ActionEvent event) {
        /*Stage modal = (Stage) cancelarBtn.getScene().getWindow();
        modal.close();*/
    }

}
