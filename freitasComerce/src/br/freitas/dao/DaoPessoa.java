package br.freitas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.freitas.model.Pessoa;

public class DaoPessoa {
	
	private final String SQL_INSERE_PESSOA = "INSERT INTO \"PUBLIC\".\"PESSOA\" (\"NOME\", \"FONE\", \"EMAIL\" ) VALUES (?,?,?)";
	private final String SQL_ALTERA_PESSOA = "UPDATE \"PUBLIC\".\"PESSOA\" SET \"NOME\"=?, \"FONE\"=?, \"EMAIL\"=? WHERE \"ID\"=? ";
	private final String SQL_DELETA_PESSOA = "DELETE FROM PUBLIC.PESSOA WHERE ID=? ";
	private final String SQL_LISTA_PESSOA = "SELECT * FROM PESSOA";
	private final String SQL_PESQUISA_PESSOA_CODIGO = SQL_LISTA_PESSOA
			+ " WHERE ID=?";
	private final String SQL_PESQUISA_PESSOA_NOME= SQL_LISTA_PESSOA 
			+ " WHERE NOME LIKE ?";
	
	
	private Jdbc CDB = null;

	public DaoPessoa() {
		CDB = new Jdbc();

	}
	
	
	public boolean inserePessoa(Pessoa p) {

		PreparedStatement stmt = Jdbc.getPrepareStatement(SQL_INSERE_PESSOA);
		try {
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSenha());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do inserePessoa"
					+ e.toString());
			return false;
		}
		
	}

	public boolean alteraPessoa(Pessoa p) {

		PreparedStatement stmt = Jdbc.getPrepareStatement(SQL_ALTERA_PESSOA);
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

	public boolean deletaPessoa(Pessoa p) {

		PreparedStatement stmt = Jdbc.getPrepareStatement(SQL_DELETA_PESSOA);
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

	public ArrayList<Pessoa> listaPessoa() {
		Statement stm = CDB.getStatement();
		ResultSet rs = null;
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

		try {
			rs = stm.executeQuery(SQL_LISTA_PESSOA);
			while (rs.next()) {
				lista.add(setPessoa(rs));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement.executeQuery "
					+ e.toString());
		}
		return lista;
	}

	public Pessoa pesquisaPessoaCodigo(int cod) {
		ResultSet rs = null;
		PreparedStatement stmt = Jdbc.getPrepareStatement(SQL_PESQUISA_PESSOA_CODIGO);
		try {
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			stmt.close();
			rs.next();
			return setPessoa(rs);
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do pesquisaPessoa por ID"
					+ e.toString());
		}
		return null;
	}
	


	public ArrayList<Pessoa> pesquisaPessoaNome(String termodebusca) {
		ResultSet rs = null;
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		PreparedStatement stmt = Jdbc.getPrepareStatement(SQL_PESQUISA_PESSOA_NOME);
		try {
			stmt.setString(1, "%"+termodebusca+"%");
			rs = stmt.executeQuery();
			stmt.close();
			while (rs.next()) {
				lista.add(setPessoa(rs));
			}
			
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro no prepareStatement do pesquisaPessoa por NOME"
					+ e.toString());
			return null;
		}
	}

	private Pessoa setPessoa(ResultSet rs){
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
