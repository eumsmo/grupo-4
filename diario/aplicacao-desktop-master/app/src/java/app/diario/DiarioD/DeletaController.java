/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.diario.DiarioD;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author User
 */
public class DeletaController implements Initializable {
     @FXML
    private Button deleteLabelCancelar;

    @FXML
    private Button deleteLabelConfirmar;
    
    @FXML
    private Label text;
    
    static String id,nome;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        ControllerDeleta.nome = nome;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ControllerDeleta.id = id;
    }
  

    @FXML
    void confirma(ActionEvent event) {
        ControllerTable controle = new ControllerTable();
        controle.deleta(getId());
                
        fecha();
    }

    @FXML
    void cancela(ActionEvent event) {
        fecha();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText("Você realmente deseja DELETAR o curso: "+ControllerDeleta.getNome());
    }  
    
    public void fecha(){
        DeletaMain.getStage().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
