package diario.aluno.model;

import diario.aluno.controllers.TableController;
import diario.aluno.repository.DepartamentoRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;

public class Departamento {
    
    private int id, idCampi;
    private String nome;
    private Button btns[];
    private HBox hbox;
    
    public Departamento() {
        this(0, 0, "");
    }
    
    public Departamento(int idCampi, String nome) {
        this(0, idCampi, nome);
    }
    
    public Departamento(int id, int idCampi, String nome) {
        this.id = id;
        this.idCampi = idCampi;
        this.nome = nome;
        btns = new Button[3];
        hbox = new HBox();
        btns[0] = new Button("INFO");
        btns[1] = new Button("EDITAR");
        btns[2] = new Button("DELETAR");
        hbox.getChildren().add(0, btns[0]);
        btns[0].getStyleClass().add("info");
        btns[1].getStyleClass().add("editar");
        btns[2].getStyleClass().add("deletar");
        hbox.getChildren().add(1, btns[1]);
        hbox.getChildren().add(2, btns[2]);
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox vbox) {
        this.hbox = vbox;
    }

    public int getId() {
        return id;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCampi() {
        return idCampi;
    }

    public void setIdCampi(int idCampi) {
        this.idCampi = idCampi;
    }

    public Button[] getBtns() {
        return btns;
    }

    public void setBtns(Button[] btns) {
        this.btns = btns;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}