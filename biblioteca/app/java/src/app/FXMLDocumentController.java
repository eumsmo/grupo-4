package app;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.sql.Date;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import app.DescartadoLista;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
  
   
   
    @FXML
    private Label label;
    @FXML
    private Button Descartar;
    @FXML
    private TableView<DescartadoLista> TabelaDescarte;

    @FXML
    private TableColumn<DescartadoLista ,String> ACERVO;
   
    @FXML
   private TableColumn<DescartadoLista,String> OPERADOR;
    @FXML
    private TableColumn<DescartadoLista, String > DATA;
    @FXML
    private TableColumn<DescartadoLista,String> MOTIVO;

   List<DescartadoLista> ListaDescartados;
private ObservableList<DescartadoLista> a =FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    List ListaD = null;
      Funções fun =new Funções();
        try {
             ListaD =fun.ExibeOqueJaFoiDescartado();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        ACERVO.setCellValueFactory(new PropertyValueFactory<>("ACERVO"));
        MOTIVO.setCellValueFactory(new PropertyValueFactory<>("MOTIVO"));
        OPERADOR.setCellValueFactory(new PropertyValueFactory<>("OPERADOR"));
        DATA.setCellValueFactory(new PropertyValueFactory<>("DATA"));
    
        TabelaDescarte.setItems(FXCollections.observableArrayList(ListaD));
       TabelaDescarte.getColumns().addAll(ACERVO,MOTIVO,OPERADOR,DATA);
        
       
    
      
    }
    
    
    }


    