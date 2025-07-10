
package model;

import dal.ConexaoBD;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoDAO extends GenericDAO{
    public void inserirCliente( Produto produto ) {
        String sql = "INSERT INTO Produto (descricao, valor, quantidade_estoque) VALUES ( ?, ?, ?)";
        
        try (Connection conn = ConexaoBD.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, valueOf(produto.getValor()));
            stmt.setString(3, valueOf(produto.getEstoque()));
            
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
            
        
            
        } catch (SQLException e ){
                System.out.println("Erro ao inserir Produto:" + e.getMessage());
                }
    }
    
    public ObservableList<Produto> listarClientes(Produto produto) throws SQLException{
        ObservableList<Produto> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Produto";
        
        try (Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("descricao");
                double telefone = rs.getDouble("valor");
                int nascimento = rs.getInt("quantidade_estoque");
                
                

                lista.add(produto);
                //System.out.println("ID:" + id + "| Nome: " + nome + "| tel: " + telefone + " | Endereço: " + endereco + " | Nascimento" + nascimento);
                    
            }
        } catch (SQLException e) {
                System.out.println("Erro ao listar produto: "+ e.getMessage());
                }
        return lista;
    }
    
   public void excluir(int id) throws SQLException {
        String delete = "DELETE FROM Produto WHERE ID = ?";
        delete(delete, id);
    }
   
   public ObservableList<Produto> selecionarProduto() throws SQLException {
        ObservableList<Produto> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Produto";
        PreparedStatement pstm = conectarDAO().prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getDouble("valor"));
            produto.setEstoque(rs.getInt("quantidade_estoque"));
            lista.add(produto);
        }

        rs.close();
        pstm.close();
        conectarDAO().close();

        return lista;
    }
}
