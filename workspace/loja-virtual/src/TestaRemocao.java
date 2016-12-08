import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new  ConnectionPool().getConnection();
		Statement statement = connection.createStatement();
		
		statement.execute("delete from produto where id > 3");
		int updateCount = statement.getUpdateCount();
		
		System.out.println(updateCount);
		
		statement.close();
		connection.close();
		
		
		
	}

}
