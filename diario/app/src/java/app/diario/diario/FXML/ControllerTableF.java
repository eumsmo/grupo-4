/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.diario.diario.FXML;

import app.diario.diarioD.ModelTable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class ControllerTableF implements Initializable{
  @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> Etapa;
    @FXML
    private TableColumn<ModelTable, String> Data;

    @FXML
    private TableColumn<ModelTable, String> Conteudo;
    @FXML
    private TableColumn<ModelTable, Button> Deletar;
    @FXML
    private TableColumn<ModelTable, Button> Editar;
    @FXML
    private TableColumn<ModelTable, Button> Faltas;


     public static ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    public List<ModelTable>  ExibeConteudos() throws SQLException{

       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root","");
             PreparedStatement st = conexao.prepareStatement("SELECT * FROM `conteudos` WHERE `idDisciplinas` = 1")) {
            ResultSet rs = st.executeQuery();
            //  List<DescartadoLista> descartes = new LinkedList();
            List ListaD = null;
            while ( rs.next()) {
                String IdC = rs.getString("id");
                String Data = rs.getString("datas");
                String idDisciplinas = rs.getString("idDisciplinas");
                String conteudos = rs.getString("conteudos");
                String idEtapas = rs.getString("idEtapas");




                ModelTable Aux= new ModelTable(idEtapas,Data,conteudos,Editar,Faltas,Editar);
                oblist.add(Aux);

                //  System.out.println(""+IdA +" :Acervos  moivos "+motivos+"\n");
                // descartes.add(new DescartadoLista(IdA,motivos));

            }
        }
   return      oblist;


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        table.refresh();
      //  col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Conteudo.setCellValueFactory(new PropertyValueFactory<>("idDepto"));
        Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        Etapa.setCellValueFactory(new PropertyValueFactory<>("Etapa"));
        Faltas.setCellValueFactory(new PropertyValueFactory<>("Faltas"));
        Deletar.setCellValueFactory(new PropertyValueFactory<>("Deletar"));
        Editar.setCellValueFactory(new PropertyValueFactory<>("Editar"));

        table.setItems(oblist);
    }
     private void sobre(ActionEvent event) throws IOException{
        Parent sobre = FXMLLoader.load(getClass().getResource("ModalDadosD.fxml"));

         Stage modalAdicionar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ModalDadosD.fxml"));
        modalAdicionar.setScene(new Scene(root));
        modalAdicionar.initOwner(((Node)event.getSource()).getScene().getWindow());
        modalAdicionar.initModality(Modality.APPLICATION_MODAL);
        modalAdicionar.showAndWait();
       // loadTableData();
    }   
}