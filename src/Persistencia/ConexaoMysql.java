package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
	
	private String ip;
	private String porta;
	private String login;
	private String senha;
	private String nomeBD;
	
	private Connection conexao;
	
	public ConexaoMysql(String ip, String porta, String login, String senha, String nomeBD) {
		this.ip = ip;
		this.porta = porta;
		this.login = login;
		this.senha = senha;
		this.nomeBD = nomeBD;
	}
	
	public Connection getConexao() {
		return conexao;
	}
	
	public void abrirConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String endereco = "jdbc:mysql://"+this.ip+":"+this.porta+"/"+this.nomeBD;
			this.conexao= DriverManager.getConnection(endereco, this.login, this.senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fecharConexao() {
		try {
			if (!this.conexao.isClosed()) {
				this.conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
