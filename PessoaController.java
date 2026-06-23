package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pessoa;
import view.CadastroView;

public class PessoaController {

    private CadastroView view;
    // ObservableList é necessária para que a TableView atualize visualmente em tempo real
    private ObservableList<Pessoa> listaPessoas;

    public PessoaController(CadastroView view) {
        this.view = view;
        this.listaPessoas = FXCollections.observableArrayList();

        // Vincula a lista interna à tabela da View
        this.view.getTabela().setItems(listaPessoas);

        // Inicializa os ouvintes de eventos (ActionHandlers)
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Evento Salvar
        view.getBtnSalvar().setOnAction(e -> {
            String nome = view.getTxtNome().getText();
            String cpf = view.getTxtCpf().getText();
            String email = view.getTxtEmail().getText();
            String telefone = view.getTxtTelefone().getText();

            // Instancia o Model usando os dados da View
            Pessoa novaPessoa = new Pessoa(nome, cpf, email, telefone);
            listaPessoas.add(novaPessoa);

            System.out.println("Pessoa salva com sucesso!");
            limparCampos();
        });

        // Evento Cancelar
        view.getBtnCancelar().setOnAction(e -> {
            limparCampos();
            System.out.println("Operação cancelada. Campos limpos.");
        });

        // Evento Listar (Imprime no console mantendo o comportamento anterior)
        view.getBtnListar().setOnAction(e -> {
            System.out.println("--- Lista de Pessoas Cadastradas ---");
            if (listaPessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada ainda.");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p.toString());
                }
            }
            System.out.println("------------------------------------");
        });
    }

    private void limparCampos() {
        view.getTxtNome().clear();
        view.getTxtCpf().clear();
        view.getTxtEmail().clear();
        view.getTxtTelefone().clear();
    }
}