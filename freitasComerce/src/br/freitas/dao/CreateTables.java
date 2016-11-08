package br.freitas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
    private Connection connection;

    public CreateTables() {
        this.connection = JdbcIIIII.getConexao();
    }

    public void createTablePessoas() {
        String sql = null;
        try {
            sql = "CREATE TABLE PESSOAS( " +
                    "id_pessoa integer not null GENERATED ALWAYS AS " +
                    "IDENTITY (START WITH 1, INCREMENT BY 1) " +
                    "CONSTRAINT PK_PESSOAS PRIMARY KEY, " +
                    "nome varchar(20) not null, " +
                    "idade integer not null" +
                    ")";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("CreateTables.createTablePessoas Ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableTelefones() {
        String sql = null;
        try {
            sql = "CREATE TABLE TELEFONES( " +
                    "id_fone integer not null GENERATED ALWAYS AS " +
                    "IDENTITY (START WITH 1, INCREMENT BY 1) " +
                    "CONSTRAINT PK_TEFEFONES PRIMARY KEY, " +
                    "numero varchar(12), " +
                    "tipo varchar(11), " +
                    "pessoa integer not null, " +
                    "CONSTRAINT FK_PESSOAS FOREIGN KEY (pessoa) " +
                    "REFERENCES PESSOAS (id_pessoa) " +
                    ")";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("CreateTables.createTableTelefones Ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
