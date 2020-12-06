package libertas.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private Connection conexao;
	
	public Conexao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//String url = "jdbc:mariadb://localhost:3306/poolibertas";
			String url = "jdbc:mariadb://35.198.32.208:3306/bdlibertas";
			conexao = DriverManager.getConnection(url, "root", "libertas");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desconecta() {
		try {
			conexao.close();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
}

