
package createadvancedstage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class CreateAdvancedStage extends Application {
    //variables for storing initial position of the stage at the beginning of drag
    private double initX;
    private double initY;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root,800, 800, Color.LIGHTGRAY));
      
         //create a button for initializing our new stage
        Button button = new Button("DESCARTAR");
        button.setStyle("-fx-font-size: 25;");
        button.setDefaultButton(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                // INITIALISATION OF THE STAGE/SCENE
                
                //create stage which has set stage style transparent
                final Stage stage = new Stage(StageStyle.TRANSPARENT);
                //create root node of scene, i.e. group
                Group rootGroup = new Group();
                //create scene with set width, height and color
                
                Scene scene = new Scene(rootGroup, 800, 800, Color.LIGHTGRAY);
                stage.setScene(scene);
                stage.centerOnScreen();
                
                stage.show();


                //when mouse button is pressed, save the initial position of screen
                rootGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        initX = me.getScreenX() - stage.getX();
                        initY = me.getScreenY() - stage.getY();
                    }
                });

                //when screen is dragged, translate it accordingly
                rootGroup.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        stage.setX(me.getScreenX() - initX);
                        stage.setY(me.getScreenY() - initY);
                    }
                });

                // CREATE MIN AND CLOSE BUTTONS
                //create button for closing application
                Button close = new Button("Close me");
                close.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        //in case we would like to close whole demo
                        //javafx.application.Platform.exit();

                        //however we want to close only this instance of stage
                        stage.close();
                    }
                });

                //create button for minimalising application
                Button min = new Button("Minimize me");
                min.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        stage.setIconified(true);
                     
                    }
                });


                // CREATE SIMPLE TEXT NODE
                Text text = new Text("Descartar Acervo"); //20, 110,
                GridPane grid = new GridPane(); 
                Label Acervo = new Label("Acervo"); 
                TextField CampoAcervo = new TextField();
                Label Data = new Label("data"); 
                TextField CampoData = new TextField();
                Label IdFuncionario = new Label("ID Funcionario"); 
                TextField CampoIdFuncionario = new TextField();
                Label Motivacao = new Label("Motivação"); 
                TextField CampoMotivacao = new TextField();
         
                text.setFill(Color.WHITESMOKE);
                text.setEffect(new Lighting());
                text.setBoundsType(TextBoundsType.VISUAL);
                text.setFont(Font.font(Font.getDefault().getFamily(), 50));

                // USE A LAYOUT VBOX FOR EASIER POSITIONING OF THE VISUAL NODES ON SCENE
                VBox vBox = new VBox();
                vBox.setSpacing(10);
                vBox.setPadding(new Insets(60, 0, 0, 20));
                vBox.setAlignment(Pos.TOP_CENTER);
                vBox.getChildren().addAll(text, min, close,Acervo,CampoAcervo,Data,CampoData,IdFuncionario,CampoIdFuncionario,Motivacao,CampoMotivacao);
                rootGroup.getChildren().addAll(vBox);
            }
        });
         
        root.getChildren().add(button);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
   

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
}

