/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.diario.diario.FXML;

import app.diario.DiarioD.ConteudosModel;


import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DiarioProfessorController implements Initializable {

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
    private Label cpf;
    @FXML
    private TableView<ConteudosModel> Table;
 
 
     public static ObservableList<ConteudosModel> oblist = FXCollections.observableArrayList();
    
    public List<ConteudosModel>  ExibeConteudos() throws SQLException{
      
          
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root",""); 
       PreparedStatement st = conexao.prepareStatement("SELECT * FROM conteudos");
       ResultSet rs = st.executeQuery();
       //List<ConteudosModel> Cont = new LinkedList();
        List ListaD = null;
         while ( rs.next()) {
       int IdC = Integer.parseInt(rs.getString("id")); 
       int Etapa = Integer.parseInt (rs.getString("id-Etapas")); 
       int Disciplina =  Integer.parseInt(rs.getString("idDisciplinas"));  
       String Conteudos = rs.getString("Conteudos");
       String datas = rs.getString("datas");
      
   
    
    
        ConteudosModel Aux= new ConteudosModel(Etapa,Disciplina,Conteudos, datas);
          oblist.add(Aux);
         
       System.out.println(""+IdC+" :Acervos  moivos "+Conteudos+"\n");
      // descartes.add(new DescartadoLista(IdA,motivos));   
   
   }    
   st.close();
   conexao.close();
   return      oblist;
  
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          List ListaC=null;
        try {
            ListaC = ExibeConteudos();
        } catch (SQLException ex) {
            Logger.getLogger(DiarioProfessorController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
 
       Etapa.setCellValueFactory(new PropertyValueFactory<>("IdEtapa"));
       Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
       Conteudo.setCellValueFactory(new PropertyValueFactory<>("Conteudo"));
       Table.setItems(FXCollections.observableArrayList(ListaC));
       Table.getColumns().addAll(Etapa,Data,Conteudo);
     
        
       
        
      
    }


       
     
    
}