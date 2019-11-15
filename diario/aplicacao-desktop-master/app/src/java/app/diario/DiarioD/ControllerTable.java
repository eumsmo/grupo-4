/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.diario.DiarioD;

/*
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

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
public class ControllerTable implements Initializable{
   
  
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
    private TableView<?> table;
 
 
    // public static ObservableList<ConteudosModel> oblist = FXCollections.observableArrayList();
    
    public List<ConteudosModel>  ExibeConteudos() throws SQLException{
        return null;
        
       /*DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       List<ConteudosModel> ListaC;
        try (Connection conecxao = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root","123456")) {
            ConteudosModel modelo =new ConteudosModel();
            ConteudosRepository consultar = new ConteudosRepository(conecxao);
            ListaC = consultar.consulta(modelo);
          
        }    
       return  ListaC;*//*
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*  List ListaC=null;
        try {
             ListaC = ExibeConteudos();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTable.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       Etapa.setCellValueFactory(new PropertyValueFactory<>("IdEtapa"));
       Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
       Conteudo.setCellValueFactory(new PropertyValueFactory<>("Conteudo"));
       Table.setItems(FXCollections.observableArrayList(ListaC));
       Table.getColumns().addAll(Etapa,Data,Conteudo);
        
      *//* 
    }
    public static void hey(ActionEvent event) {
        System.out.println("AAAA");}
}

        /*  List ListaC=null;
        try {
             ListaC = ExibeConteudos();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTable.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       Etapa.setCellValueFactory(new PropertyValueFactory<>("IdEtapa"));
       Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
       Conteudo.setCellValueFactory(new PropertyValueFactory<>("Conteudo"));
       Table.setItems(FXCollections.observableArrayList(ListaC));
       Table.getColumns().addAll(Etapa,Data,Conteudo);
        
     
    }
}*/