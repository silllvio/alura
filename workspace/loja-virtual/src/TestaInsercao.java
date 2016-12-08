import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		Connection connection = new  ConnectionPool().getConnection();
	
		String nome = "NoteBook";
		String descricao = "NoteBook i5";
		
		String sql =" insert into Produto (nome,descricao) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nome);
		statement.setString(2, descricao);
		boolean result = statement.execute();
		
//		Perigoso, sujeito a sql injection
//		Statement statement = connection.createStatement();
//		String nome = "NoteBook";
//		String descricao = "NoteBook i5";
//		
////		A própria API do java trabalha as  aspas simples;
//		boolean execute = statement.execute(
//				"insert into Produto (nome,descricao) values('"+nome+"','"+descricao+"')",
//				statement.RETURN_GENERATED_KEYS);

//		System.out.println(execute);

		ResultSet keys = statement.getGeneratedKeys();
		while (keys.next()) {
			String id = keys.getString("id");
//			 String nome = keys.getString("nome");
//			 String descricao = keys.getString("descricao");

			System.out.println(id);
			// System.out.println(nome);
			// System.out.println(descricao);
//
		}
//
		statement.close();
		connection.close();
	}

}
