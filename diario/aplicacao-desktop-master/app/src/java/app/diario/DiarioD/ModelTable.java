package app.diario.diarioD;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class ModelTable {
    String Etapa,data,conteudo;
    Button Deletar,Editar,Faltas;
    boolean isCancela;

    public ModelTable(String Etapa, String data, String conteudo, Button deleta, Button edita, Button faltas) {
        this.Etapa = Etapa;
        this.data = data;
        this.conteudo = conteudo;
        this.Deletar = deleta;
        this.Editar = edita;
        this.Faltas = faltas;
        
        
        /*deleta.setOnMouseClicked((MouseEvent event) -> {
            DeletaMain mainDeleta = new DeletaMain();
            ControllerDeleta.setId(id);
            ControllerDeleta.setNome(nome);
            try {
                mainDeleta.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        edita.setOnMouseClicked((MouseEvent event) -> {
            EditarMain mainEditar = new EditarMain();
            ControllerEditar.setId(id);
            try {
                mainEditar.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });*/
    }

    public ModelTable(String idEtapas, String Data, String conteudos, TableColumn<ModelTable, Button> Editar, TableColumn<ModelTable, Button> Faltas, TableColumn<ModelTable, Button> Editar0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEtapa() {
        return Etapa;
    }

    public void setEtapa(String Etapa) {
        this.Etapa = Etapa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Button getDeletar() {
        return Deletar;
    }

    public void setDeletar(Button Deletar) {
        this.Deletar = Deletar;
    }

    public Button getEditar() {
        return Editar;
    }

    public void setEditar(Button Editar) {
        this.Editar = Editar;
    }

    public Button getFaltas() {
        return Faltas;
    }

    public void setFaltas(Button Faltas) {
        this.Faltas = Faltas;
    }

    public boolean isIsCancela() {
        return isCancela;
    }

    public void setIsCancela(boolean isCancela) {
        this.isCancela = isCancela;
    }

   

   
   
}