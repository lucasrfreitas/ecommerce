package br.freitas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.freitas.model.Pessoa;

public class DaoPessoa {
	
	private final String SQL_INSERE_PESSOA = "INSERT INTO PESSOA (NOME, CPF, SENHA ) VALUES (?,?,?)";
	private final String SQL_ALTERA_PESSOA = "UPDATE \"PUBLIC\".\"PESSOA\" SET \"NOME\"=?, \"CPF\"=?, \"SENHA\"=? WHERE \"ID\"=? ";
	private final String SQL_DELETA_PESSOA = "DELETE FROM PUBLIC.PESSOA WHERE ID=? ";
	private final String SQL_LISTA_PESSOA = "SELECT * FROM PESSOA";
	private final String SQL_PESQUISA_PESSOA_CODIGO = SQL_LISTA_PESSOA
			+ " WHERE ID=?";
	private final String SQL_PESQUISA_PESSOA_NOME= SQL_LISTA_PESSOA 
			+ " WHERE NOME LIKE ?";
	
	
	private JdbcIIIII CDB = null;

		
	public boolean InserePessoa(Pessoa p) {

		
		try(Connection connection = new jdbc().getConexao();
				PreparedStatement stmt = connection.prepareStatement(SQL_INSERE_PESSOA);) {
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSenha());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do inserePessoa"
					+ e.toString());
			return false;
		}
		
	}

	public boolean AlteraPessoa(Pessoa p) {

		PreparedStatement stmt = JdbcIIIII.getPrepareStatement(SQL_ALTERA_PESSOA);
		try {
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSenha());
			stmt.setInt(4, p.getId());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do alteraPessoa"
					+ e.toString());
			return false;
		}
	}

	public boolean DeletaPessoa(Pessoa p) {

		PreparedStatement stmt = JdbcIIIII.getPrepareStatement(SQL_DELETA_PESSOA);
		try {
			stmt.setInt(1, p.getId());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do deletarPessoa"
					+ e.toString());
			return false;
		}
	}

	@SuppressWarnings("finally")
	/**
	 * Lista todas as pessoas cadastradas
	 * @return ArrayList - Com todas as pessoas cadastradas
	 */
	public ArrayList<Pessoa> ListaPessoa() throws SQLException {
		Connection connection = new jdbc().getConexao();
		PreparedStatement stmt = connection.prepareStatement(SQL_LISTA_PESSOA);
		ResultSet rs = null;
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

		try {
			rs = stmt.executeQuery();
			stmt.close();
			while (rs.next()) {
				lista.add(SetPessoa(rs));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement.executeQuery "
					+ e.toString());
		} finally {
			return lista;
		}

	}

	public Pessoa PesquisaPessoaCodigo(int cod) {
		ResultSet rs = null;
		PreparedStatement stmt = JdbcIIIII.getPrepareStatement(SQL_PESQUISA_PESSOA_CODIGO);
		try {
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			stmt.close();
			rs.next();
			return SetPessoa(rs);
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do pesquisaPessoa por ID"
					+ e.toString());
		}
		return null;
	}
	


	public ArrayList<Pessoa> PesquisaPessoaNome(String termodebusca) {
		ResultSet rs = null;
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		PreparedStatement stmt = JdbcIIIII.getPrepareStatement(SQL_PESQUISA_PESSOA_NOME);
		try {
			stmt.setString(1, "%"+termodebusca+"%");
			rs = stmt.executeQuery();
			stmt.close();
			while (rs.next()) {
				lista.add(SetPessoa(rs));
			}
			
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do pesquisaPessoa por NOME"
					+ e.toString());
			return null;
		}
	}

	private Pessoa SetPessoa(ResultSet rs){
		Pessoa umaPessoa = null;
		try {
			umaPessoa = new Pessoa(rs.getInt("ID"));
			umaPessoa.setNome(rs.getString("Nome"));
			umaPessoa.setCpf(rs.getString("Cpf"));
			umaPessoa.setSenha(rs.getString("Senha"));
			return umaPessoa;
		} catch (SQLException e) {
			System.out.println("Erro ao fazer get no ResultSet "
					+ e.toString());
		}
		return null;
	}
}
