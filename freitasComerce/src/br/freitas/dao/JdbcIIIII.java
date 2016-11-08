/**
 * 
 */
package br.freitas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Statement;

/**
 * @author Lucas Freitas
 *
 */
public class JdbcIIIII {
	private static Connection connection = null;
	private static JdbcIIIII jdbc;
	private static String usuario = "sa";
	private static String senha = "";
	private static String PathBase = "D:\\Users\\Lucas Freitas\\git\\ecommerce\\freitasComerce\\Banco\\dbecommerce";
	//D:\Users\Lucas Freitas\git\ecommerce\freitasComerce
	private static final String URL = "jdbc:hsqldb:file:" + PathBase
			+ ";shutdown=true;hsqldb.write_delay=false; ";
	private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private Statement stm = null;
	private static Connection conn = null;
	
	public JdbcIIIII() {
		try {
			// Registrando um driver
			Class.forName(DRIVER_CLASS);

			// Estabelecendo conexão
			connection = DriverManager.getConnection(URL, usuario, senha);	
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nao encontrado");
		} catch (SQLException e) {
			System.out.println("Erro ao obter a conexao");
		}
	}

	static Connection getConexao() {
		if (jdbc == null)
			jdbc = new JdbcIIIII();
		return JdbcIIIII.connection;
	}
	
	public Statement getStatement() {
		// Criando uma declaração - Statement
		try {
			stm = conn.createStatement();
			return stm;
		} catch (SQLException e) {
			System.out.println("Erro ao obter um Statement");
			return null;
		}
	}

	@SuppressWarnings("finally")
	public static PreparedStatement getPrepareStatement(String sql) {
		JdbcIIIII.getConexao();
		PreparedStatement pst = null;
		try {
			pst = JdbcIIIII.connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return pst != null ? pst : null;
		}
	}

}
