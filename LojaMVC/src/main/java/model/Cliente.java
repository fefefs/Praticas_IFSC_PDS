
package model;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente extends GenericDAO {
    
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;
    private Date dataNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    private transient IntegerProperty idProperty;

    public IntegerProperty idProperty() {
        if (idProperty == null) {
            idProperty = new SimpleIntegerProperty(id);
        }
        return idProperty;
    }
    
    private transient StringProperty nomeProperty;

    public StringProperty nomeProperty() {
        if (nomeProperty == null) {
            nomeProperty = new SimpleStringProperty(nome);
        }
        return nomeProperty;
    }
    
    private transient StringProperty telProperty;

    public StringProperty telProperty() {
        if (telProperty == null) {
            telProperty = new SimpleStringProperty(telefone);
        }
        return telProperty;
    }
    
    private transient StringProperty enderecoProperty;
    
    public StringProperty enderecoProperty() {
        if (enderecoProperty == null) {
            enderecoProperty = new SimpleStringProperty(endereco);
        }
        return enderecoProperty;
    }
    
    private transient StringProperty loginProperty;

    public StringProperty loginProperty() {
        if (loginProperty == null) {
            loginProperty = new SimpleStringProperty(login);
        }
        return loginProperty;
    }

    private transient StringProperty senhaProperty;

    public StringProperty senhaProperty() {
        if (senhaProperty == null) {
            senhaProperty = new SimpleStringProperty(senha);
        }
        return senhaProperty;
    }
    
    private transient StringProperty dataNascProperty;
    
     public StringProperty dataNascProperty() {
        if (dataNascProperty == null) {
            dataNascProperty = new SimpleStringProperty(dataNascimento.toString());
        }
        return dataNascProperty;
    }
}
