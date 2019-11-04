package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button adicionar;
    
    private void handleButtonAction(ActionEvent event){
        System.out.println("You clicked me!");
        adicionar.setText("button clicked");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adicionar.setOnAction(this::handleButtonAction);
    }    
}