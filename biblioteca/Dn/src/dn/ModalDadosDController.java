/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dn;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ModalDadosDController implements Initializable {

   @FXML
    private Button Enviar;
    @FXML
    private TextField ACERVO;  
    @FXML
   private TextField OPERADOR;
    @FXML
    private DatePicker DATA;
    @FXML
    private TextField MOTIVO;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public  void EnviarDescarte(ActionEvent event) throws SQLException {
        String IDFuncionario = OPERADOR.getText();
        String motivo = OPERADOR.getText();
        Date data= (Date) DATA.getDayCellFactory();
         
        Integer NumeroAcervo = Integer.parseInt(ACERVO.getText());
       // DepartamentoRepository.insere(IDFuncionario, NumeroAcervo);      
       
        Funções fun = new Funções(); 
               fun.insereDescartesEremoveAcervo(NumeroAcervo,data,IDFuncionario,motivo);
      
     
    }
    
}
