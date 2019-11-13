/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.diario.DiarioD;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author User
 */
public class ControllerTable implements Initializable{
   
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
 
 /*   @FXML
    private void Insere(javafx.event.ActionEvent event) {
       InsereMain insere = new InsereMain();
        try {
            insere.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ControllerTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
     public static ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    
    public List<ModelTable>  ExibeConteudos() throws SQLException{
        
       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root",""); 
       PreparedStatement st = conexao.prepareStatement("SELECT * FROM `conteudos` WHERE `idDisciplinas` = 1");
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
   st.close();
   conexao.close();
   return      oblist;

      
    }
    
    
    
   //  @Override
 /*   public void initialize(URL location, ResourceBundle resources) {
        consultarBD();
        criaTabela();
    }
    public void refresh(){
        consultarBD();
        criaTabela();
    }
    */
    
    
   
    /*
    public void deleta(String id){
         try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement stmt = connection.prepareStatement("delete " +
                    "from cursos where id="+id);
            stmt.execute();
            stmt.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }*/
    
  /*  static public void consultarBD(){
        try {
            Connection con = DbConnector.getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("select * from cursos");
            oblist = FXCollections.observableArrayList();
            
            while(rs.next()){
                oblist.add(new ModelTable(rs.getString("id"),verificaDepto(rs.getString("id-depto")),rs.getString("nome"),rs.getString("horas-total"),rs.getString("modalidade"),new Button("EDITAR"),new Button("DELETAR")));
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    public void criaTabela(){
        
      /*  table.refresh();
      //  col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Conteudo.setCellValueFactory(new PropertyValueFactory<>("idDepto"));
        Data.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Etapa.setCellValueFactory(new PropertyValueFactory<>("horas"));
        Faltas.setCellValueFactory(new PropertyValueFactory<>("modalidade"));
        Deletar.setCellValueFactory(new PropertyValueFactory<>("edita"));
        Editar.setCellValueFactory(new PropertyValueFactory<>("deleta"));
        
        table.setItems(oblist);/*/
    }
   /* public static String verificaDepto(String id) throws SQLException {
        ResultSet resultadoBusca;
        Connection con = DbConnector.getConnection();
        int Iid = Integer.parseUnsignedInt(id);
        // cria um preparedStatement
        String sql = "SELECT `nome` FROM `departamentos` WHERE `id` = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, Iid);
        resultadoBusca =  stmt.executeQuery();
        resultadoBusca.next();
        return resultadoBusca.getString("nome");
    }
*/
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
}
