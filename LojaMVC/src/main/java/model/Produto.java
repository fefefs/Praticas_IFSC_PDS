
package model;

import java.sql.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Produto extends GenericDAO{
    
    private int id;
    private String descricao;
    private double valor;
    private int estoque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Produto(int id, String descricao, double valor, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }

    public Produto(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Produto(int id) {
        this.id = id;
    }
    
    public Produto() {
    }

    public Produto(String descricao, double valor, int estoque) {
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }
    
    

    private transient IntegerProperty idProperty;

    public IntegerProperty idProperty() {
        if (idProperty == null) {
            idProperty = new SimpleIntegerProperty(id);
        }
        return idProperty;
    }
    
    private transient StringProperty descricaoProperty;

    public StringProperty descricaoProperty() {
        if (descricaoProperty == null) {
            descricaoProperty = new SimpleStringProperty(descricao);
        }
        return descricaoProperty;
    }
    
    private transient DoubleProperty valorProperty;

    public DoubleProperty valorProperty() {
        if (valorProperty == null) {
            valorProperty = new SimpleDoubleProperty(valor);
        }
        return valorProperty;
    }
    
    private transient IntegerProperty estoqueProperty;

    public IntegerProperty estoqueProperty() {
        if (estoqueProperty == null) {
            estoqueProperty = new SimpleIntegerProperty(estoque);
        }
        return estoqueProperty;
    }
    
    
    
    
    
    
    
}
