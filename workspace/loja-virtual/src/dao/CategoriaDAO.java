package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;

public class CategoriaDAO {

	private Connection con;

	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from  categoria";
		try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			stmt.execute();
			try (ResultSet result = stmt.getResultSet()){
				while (result.next()){
					String nome = result.getString("nome");
					Integer id = result.getInt("id");
					Categoria cat = new Categoria(nome);
					cat.setId(id);
					categorias.add(cat);
					
				}
			}
			
			
		}

		return categorias;
	}

}
