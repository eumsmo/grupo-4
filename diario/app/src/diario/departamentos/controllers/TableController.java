package diario.departamentos.controllers;

import diario.departamentos.model.Departamento;
import diario.departamentos.repository.DepartamentoRepository;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.event.EventListenerList;


public class TableController implements Initializable{
    private ObservableList<Departamento> tabelaDeptos;
    
    @FXML
    private Button adicionar;
    
    @FXML
    private TableView<Departamento> tabela;

    @FXML
    private TableColumn<Departamento, String> col_nome;

    @FXML
    private TableColumn<Departamento, Integer> col_campus;

    @FXML
    private TableColumn<Departamento, HBox> col_acoes;
    
    @FXML
    void modalAdicionar(ActionEvent event) throws IOException, SQLException {
        Stage modalAdicionar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/diario/departamentos/ModalAdicionar.fxml"));
        modalAdicionar.setScene(new Scene(root));
        modalAdicionar.initOwner(((Node)event.getSource()).getScene().getWindow());
        modalAdicionar.initModality(Modality.APPLICATION_MODAL);
        modalAdicionar.showAndWait();
        loadTableData();
    }
    
    private void initTable(){
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_campus.setCellValueFactory(new PropertyValueFactory<>("idCampi"));
        col_acoes.setCellValueFactory(new PropertyValueFactory<>("hbox"));
    }

    @FXML
    public void loadTableData() throws SQLException{
        tabelaDeptos =  FXCollections.observableArrayList(DepartamentoRepository.consulta());
        
        
        tabela.setItems(tabelaDeptos);
        tabela.setOnMouseClicked(e ->{
            events();
        });
        
    }
    
    private void events(){
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabelaDeptos = FXCollections.observableArrayList();
        
        initTable();
        try {
            loadTableData();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}