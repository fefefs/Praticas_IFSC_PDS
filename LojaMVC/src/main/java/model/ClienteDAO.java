
package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ClienteDAO extends GenericDAO{
    
    public void inserirCliente( Cliente cliente ) {
        String sql = "INSERT INTO Cliente (nome, telefone, endereco, data_nascimento) VALUES ( ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBD.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setDate(4, cliente.getDataNascimento());
            
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
            
        
            
        } catch (SQLException e ){
                System.out.println("Erro ao inserir cliente:" + e.getMessage());
                }
    }
    
    public ObservableList<Cliente> listarClientes(Cliente cliente) throws SQLException{
        ObservableList<Cliente> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Cliente";
        
        try (Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                Date nascimento = rs.getDate("data_nascimento");
                
                

                lista.add(cliente);
                //System.out.println("ID:" + id + "| Nome: " + nome + "| tel: " + telefone + " | Endereço: " + endereco + " | Nascimento" + nascimento);
                    
            }
        } catch (SQLException e) {
                System.out.println("Erro ao listar clientes: "+ e.getMessage());
                }
        return lista;
    }
    
   public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM USUARIOS WHERE ID = ?";
        delete(delete, id);
    }
   
   public ObservableList<Cliente> selecionarClientes() throws SQLException {
        ObservableList<Cliente> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Clientes";
        PreparedStatement pstm = conectarDAO().prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("fone"));
            cliente.setLogin(rs.getString("login"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setDataNascimento(rs.getDate("data_nascimento"));
            lista.add(cliente);
        }

        rs.close();
        pstm.close();
        conectarDAO().close();

        return lista;
    }
    
}

















