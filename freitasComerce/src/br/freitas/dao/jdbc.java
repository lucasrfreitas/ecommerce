package br.freitas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "D:\\Users\\Lucas Freitas\\git\\ecommerce\\freitasComerce\\base\\Banco";
			
			//"D:\\Users\\Lucas Freitas\\git\\ecommerce\\freitasComerce\\Banco\\dbecommerce";
	//D:\Users\Lucas Freitas\git\ecommerce\freitasComerce\base\Banco
	private String URL = "jdbc:hsqldb:file:" + PathBase + ";";

	public Connection getConexao() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
