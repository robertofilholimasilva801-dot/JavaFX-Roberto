package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

    private final StringProperty nome = new SimpleStringProperty();
    private final StringProperty cpf = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty telefone = new SimpleStringProperty();

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email, String telefone) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
    }

    // Getters e Setters convencionais
    public String getNome() { return nome.get(); }
    public void setNome(String value) { nome.set(value); }
    public StringProperty nomeProperty() { return nome; }

    public String getCpf() { return cpf.get(); }
    public void setCpf(String value) { cpf.set(value); }
    public StringProperty cpfProperty() { return cpf; }

    public String getEmail() { return email.get(); }
    public void setEmail(String value) { email.set(value); }
    public StringProperty emailProperty() { return email; }

    public String getTelefone() { return telefone.get(); }
    public void setTelefone(String value) { telefone.set(value); }
    public StringProperty telefoneProperty() { return telefone; }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | CPF: " + getCpf() + " | E-mail: " + getEmail() + " | Tel: " + getTelefone();
    }
}