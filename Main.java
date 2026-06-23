import controller.PessoaController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.CadastroView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Pessoas - Arquitetura MVC");

        // Instancia a View
        CadastroView view = new CadastroView();

        // Instancia o Controller passando a View criada
        new PessoaController(view);

        // Define a cena e apresenta a janela
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}