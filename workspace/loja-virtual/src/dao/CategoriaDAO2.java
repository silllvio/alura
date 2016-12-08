package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria2;
import modelo.Produto;

public class CategoriaDAO2 {

	private final Connection con;
	

	public CategoriaDAO2(Connection con) {
		this.con = con;
	}

	public List<Categoria2> getLista() throws SQLException {
		System.out.println("Query lista Categorias");
		List<Categoria2> categorias = new ArrayList<>();
		String sql = "select * from Categoria";
		try (PreparedStatement statment = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
			statment.execute();
			try (ResultSet result = statment.getResultSet()) {
				while (result.next()) {
					Integer id = result.getInt("id");
					String nome = result.getString("nome");
					Categoria2 cat = new Categoria2();
					cat.setId(id);

					cat.setNome(nome);
					categorias.add(cat);

				}
			}

		}
		return categorias;
	}

	public List<Categoria2> getListaComCat() throws SQLException {
		Categoria2 ultima = null;
		System.out.println("Query lista Categorias");
		List<Categoria2> categorias = new ArrayList<>();
		String sql = "SELECT 	c.id c_id,  "
					+ "	c.nome c_nome,  	p.id  p_id, 	p.nome p_nome,	p.descricao p_descricao  FROM PRODUTO P  JOIN CATEGORIA C ON C.ID = P.CATEGORIA_ID order by c.id"; 
		try (PreparedStatement statment = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
			statment.execute();
			try (ResultSet result = statment.getResultSet()) {
				while (result.next()) {
					Integer c_id = result.getInt("c_id");
					String  c_nome = result.getString("c_nome");

					if (ultima == null || !ultima.getNome().equals(c_nome)) {
						Categoria2 cat = new Categoria2();
						cat.setNome(c_nome);
						categorias.add(cat);
						cat.setId(c_id);

						ultima = cat;
					}
					
					Integer p_id = result.getInt("p_id");
					String p_nome = result.getString("p_nome");
					Produto produto = new Produto(p_nome,null);
					produto.setId(p_id);
					ultima.adiciona(produto);
				}
			}

		}

		return categorias;
	}
}