package br.edu.ifba.ads.inf008.wks.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;

public class AtividadeSQLDAO implements AtividadeDAOIF{
	
	private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
	private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String DB_USER = "SA";
	private static final String DB_PWD = "";
	private static final String SAVE = "INSERT INTO ELEMENTAR(id, descricao, duracao) VALUES(?, ?, ?)";
	
	
	
	
	public AtividadeSQLDAO() throws SQLException, ClassNotFoundException {
		Class.forName(AtividadeSQLDAO.DRIVER_NAME);
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(AtividadeSQLDAO.DB_URI, 
				AtividadeSQLDAO.DB_USER, AtividadeSQLDAO.DB_PWD);
	}
	
	
	@Override
	public void salvar(Atividade atividade) throws Exception {
		PreparedStatement stmt = this.getConnection().prepareStatement(AtividadeSQLDAO.SAVE);
		stmt.setString(1, atividade.getId());
		stmt.setString(2, atividade.getDescricao());
		stmt.setInt(3, atividade.getDuracao());
		stmt.executeUpdate();
		stmt.close();
	}

	@Override
	public Collection<Atividade> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
