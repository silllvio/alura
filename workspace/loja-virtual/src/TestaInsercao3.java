import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao3 {

	public static void main(String[] args) throws SQLException {
		// String nome = "Fritadeira";
		// String descricao = "Fritadeira elétrica";

		try (Connection connection = new ConnectionPool().getConnection()) {
			;
			connection.setAutoCommit(false);
			String sql = "insert into Produto (nome,descricao) values (?,?)";

			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona("Fritadeira", "Fritadeira elétrica", statement);
				adiciona("Blue Ray", "Aparelho de Blue Ray", statement);
				// connection.commit();

				adiciona("TV LCD", "TV de LCD UltraHD", statement);
				connection.commit();
				// statement.close();
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Roll Back");
			}
			// connection.close();
		}
	}

	public static void adiciona(String nome, String descricao, PreparedStatement statment) throws SQLException {

		if (nome.equals("Blue Ray")) {
			throw new IllegalArgumentException("Problema");
		}

		statment.setString(1, nome);
		statment.setString(2, descricao);
		boolean execute = statment.execute();
		System.out.println(execute);

		ResultSet keys = statment.getGeneratedKeys();
		while (keys.next()) {
			String id = keys.getString("id");
			System.out.println(id);

		}

	}
}
