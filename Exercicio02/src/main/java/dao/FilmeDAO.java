package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Filme;

public class FilmeDAO extends DAO {
	 public boolean insert(Filme filme) {
			boolean status = false;
			try {  
				Statement st = conexao.createStatement();
				String sql = "INSERT INTO filmes (codigo, nome, avaliacao, genero) "
					       + "VALUES ("+filme.getCodigo()+ ", '" + filme.getNome() + "', '"  
					       + filme.getAvaliacao() + "', '" + filme.getGenero() + "');";
				st.executeUpdate(sql);
				st.close();
				status = true;
			} catch (SQLException u) {  
				throw new RuntimeException(u);
			}
			return status;
	}
	 
	public boolean delete(int codigo) {
			boolean status = false;
			try {  
				Statement st = conexao.createStatement();
				String sql = "DELETE FROM filmes WHERE codigo = " + codigo;				
				st.executeUpdate(sql);
				st.close();
				status = true;
			} catch (SQLException u) {  
				throw new RuntimeException(u);
			}
			return status;
	}
	
	public boolean update(Filme filme) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE filmes SET nome = '" + filme.getNome() + "', avaliacao = '"  
				       + filme.getAvaliacao() + "', genero = '" + filme.getGenero() + "'"
					   + " WHERE codigo = " + filme.getCodigo();			
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	 public List<Filme> listar() {
	        List<Filme> filmes = new ArrayList<>();
	        try {
	            Statement st = conexao.createStatement();
	            String sql = "SELECT * FROM filmes;";
	            ResultSet rs = st.executeQuery(sql);

	            while (rs.next()) {
	                int codigo = rs.getInt("codigo");
	                String nome = rs.getString("nome");
	                Float avaliacao = rs.getFloat("avaliacao");
	                String genero = rs.getString("genero");

	                Filme filme = new Filme(codigo, nome, genero, avaliacao);
	                filmes.add(filme);
	            }

	            rs.close();
	            st.close();
	        } catch (SQLException u) {
	            throw new RuntimeException(u);
	        }
	        return filmes;
    }
}
