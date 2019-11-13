/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.diario.DiarioD;

import diario.diario.conteudos.ConteudosModel;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import a
/**
 *
 * @author User
 */
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControllerTable implements Initializable{
   
    @FXML
    private TableView<ConteudosModel> table;
  
    @FXML
    private TableColumn<ConteudosModel, String> Etapa;
    @FXML
    private TableColumn<ConteudosModel, String> Data;
  
    @FXML
    private TableColumn<ConteudosModel, String> Conteudo;
    @FXML
    private TableColumn<ConteudosModel, Button> Deletar;
    @FXML
    private TableColumn<ConteudosModel, Button> Editar;
    @FXML
    private TableColumn<ConteudosModel, Button> Faltas;
 
 
     public static ObservableList<ConteudosModel> oblist = FXCollections.observableArrayList();
    
    public List<ConteudosModel>  ExibeConteudos() throws SQLException{
        
       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       Connection conecxao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root","123456"); 
       PreparedStatement st = conecxao.prepareStatement("SELECT * FROM `conteudos` WHERE `idDisciplinas` = 1");//Precisa colocar id da disciplina como parametro; 
       ResultSet rs = st.executeQuery();
       List<ConteudosModel> Conteudoslinked = new LinkedList();
       ConteudosRepository consultar = new ConteudosRepository(conecxao);
       List ListaC = consultar.consulta((app.diario.DiarioD.ConteudosModel) Conteudoslinked);    
       st.close();
       conecxao.close();    
       return  ListaC;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            oblist=(ObservableList<ConteudosModel>) ExibeConteudos();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTable.class.getName()).log(Level.SEVERE, null, ex);
        }
      table.refresh();
      Conteudo.setCellValueFactory(new PropertyValueFactory<>("idDepto"));
      Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
      Etapa.setCellValueFactory(new PropertyValueFactory<>("Etapa"));
      Faltas.setCellValueFactory(new PropertyValueFactory<>("Faltas"));
      Deletar.setCellValueFactory(new PropertyValueFactory<>("Deletar"));
      Editar.setCellValueFactory(new PropertyValueFactory<>("Editar"));
      table.setItems(oblist);
    }
}
