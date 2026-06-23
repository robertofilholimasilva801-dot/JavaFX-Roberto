package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Pessoa;

public class CadastroView {

    private Scene scene;

    // Componentes que o Controller precisará acessar
    private TextField txtNome, txtCpf, txtEmail, txtTelefone;
    private Button btnSalvar, btnCancelar, btnListar;
    private TableView<Pessoa> tabela;

    public CadastroView() {
        criarInterface();
    }

    private void criarInterface() {
        // Campos de texto
        txtNome = new TextField();
        txtCpf = new TextField();
        txtEmail = new TextField();
        txtTelefone = new TextField();

        // Formulário
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(15));
        grid.add(new Label("Nome:"), 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(new Label("CPF:"), 0, 1);
        grid.add(txtCpf, 1, 1);
        grid.add(new Label("E-mail:"), 0, 2);
        grid.add(txtEmail, 1, 2);
        grid.add(new Label("Telefone:"), 0, 3);
        grid.add(txtTelefone, 1, 3);

        // Botões
        btnSalvar = new Button("Salvar");
        btnCancelar = new Button("Cancelar");
        btnListar = new Button("Listar");

        HBox boxBotoes = new HBox(10);
        boxBotoes.getChildren().addAll(btnSalvar, btnCancelar, btnListar);

        // Tabela (Requisito do Trabalho)
        tabela = new TableView<>();

        TableColumn<Pessoa, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Pessoa, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());

        TableColumn<Pessoa, String> colEmail = new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<Pessoa, String> colTel = new TableColumn<>("Telefone");
        colTel.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());

        tabela.getColumns().addAll(colNome, colCpf, colEmail, colTel);
        tabela.setPrefHeight(200);

        // Layout Principal
        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setPadding(new Insets(15));
        layoutPrincipal.getChildren().addAll(grid, boxBotoes, tabela);

        // Instancia a Scene externa
        scene = new Scene(layoutPrincipal, 450, 450);
    }

    // Getters para o Controller manipular a View
    public Scene getScene() { return scene; }
    public TextField getTxtNome() { return txtNome; }
    public TextField getTxtCpf() { return txtCpf; }
    public TextField getTxtEmail() { return txtEmail; }
    public TextField getTxtTelefone() { return txtTelefone; }
    public Button getBtnSalvar() { return btnSalvar; }
    public Button getBtnCancelar() { return btnCancelar; }
    public Button getBtnListar() { return btnListar; }
    public TableView<Pessoa> getTabela() { return tabela; }
}