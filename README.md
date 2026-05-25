import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class CadastroApp extends Application {

    // 1. Armazenamento em memória
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    // Classe Pessoa aninhada para manter tudo em um único arquivo
    public static class Pessoa {
        private String nome;
        private String cpf;
        private String email;
        private String telefone;

        public Pessoa(String nome, String cpf, String email, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s | CPF: %s | E-mail: %s | Telefone: %s", nome, cpf, email, telefone);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // 2. Criação dos campos de texto
        TextField txtNome = new TextField();
        TextField txtCpf = new TextField();
        TextField txtEmail = new TextField();
        TextField txtTelefone = new TextField();

        // 3. Criação dos botões
        Button btnSalvar = new Button("Salvar");
        Button btnCancelar = new Button("Cancelar");
        Button btnListar = new Button("Listar");

        // 4. Lógica de captura de eventos

        // Evento: Salvar
        btnSalvar.setOnAction(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();

            Pessoa novaPessoa = new Pessoa(nome, cpf, email, telefone);
            listaPessoas.add(novaPessoa);
            
            System.out.println(" Cadastro foi salvo com sucesso: " + nome);
            limparCampos(txtNome, txtCpf, txtEmail, txtTelefone);
        });

        // Evento: Cancelar (Limpar campos)
        btnCancelar.setOnAction(e -> {
            limparCampos(txtNome, txtCpf, txtEmail, txtTelefone);
            System.out.println(" Operação foi cancelada. Campos limpos.");
        });

        // Evento: Listar (Exibição no console)
        btnListar.setOnAction(e -> {
            System.out.println("\n--- LISTA DE PESSOAS CADASTRADAS ---");
            if (listaPessoas.isEmpty()) {
                System.out.println("Nenhum registro foi encontrado.");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p.toString());
                }
            }
            System.out.println("---------------------------------------");
        });

        // 5. Organização da Interface Gráfica (GridPane)
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(txtNome, 1, 0);
        
        grid.add(new Label("CPF:"), 0, 1);
        grid.add(txtCpf, 1, 1);
        
        grid.add(new Label("E-mail:"), 0, 2);
        grid.add(txtEmail, 1, 2);
        
        grid.add(new Label("Telefone:"), 0, 3);
        grid.add(txtTelefone, 1, 3);

        HBox boxBotoes = new HBox(10);
        boxBotoes.setAlignment(Pos.BOTTOM_RIGHT);
        boxBotoes.getChildren().addAll(btnSalvar, btnCancelar, btnListar);
        grid.add(boxBotoes, 1, 4);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Cadastro de Pessoas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void limparCampos(TextField nome, TextField cpf, TextField email, TextField tel) {
        nome.clear();
        cpf.clear();
        email.clear();
        tel.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
