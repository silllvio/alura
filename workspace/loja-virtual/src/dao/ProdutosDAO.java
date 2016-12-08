package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Categoria2;
import modelo.Produto;

public class ProdutosDAO {

	private final Connection con;

	public ProdutosDAO(Connection con) {
		this.con = con;

	}

	public void salva(Produto prod) throws SQLException {
		String sql = "insert into produto (nome, descricao) values (?,?)";
		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, prod.getNome());
			statement.setString(2, prod.getDescricao());
			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				if (result.next()) {
					int id = result.getInt("id");
					prod.setId(id);

				}
			}
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			transResultEmProd(produtos, stmt);
		}

		return produtos;
	}

	private void transResultEmProd(List<Produto> produtos, PreparedStatement stmt) throws SQLException {
		try (ResultSet result = stmt.getResultSet()) {
			while (result.next()) {
				Integer id = result.getInt("id");
				String nome = result.getString("nome");
				String desc = result.getString("descricao");
				Produto prod = new Produto(nome, desc);
				prod.setId(id);
				produtos.add(prod);
			}

		}
	}

	public List<Produto> busca(Categoria2 categoria2) throws SQLException {
		System.out.println("Query busca categoria");
		List<Produto>produtos = new ArrayList<>();
		String sql = "select * from produto where categoria_id = ?";
		try(PreparedStatement statment = con.prepareStatement(sql)){
			statment.setLong(1, categoria2.getId());
			statment.execute();
			transResultEmProd(produtos, statment);
					
		}

		
		return produtos;
	}

}
