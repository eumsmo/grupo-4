        package app;

        import diario.descartes.controllers.TableController;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;


        public class MainApp extends Application {

            @Override
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("/diario/descartes/TabelaDescartes.fxml"));

                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("resources/styles.css").toExternalForm());
                TableController t = new TableController();
                
                stage.setTitle("Conteúdos");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }

        }