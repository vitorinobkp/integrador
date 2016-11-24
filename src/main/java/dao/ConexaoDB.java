package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;


public class ConexaoDB {
	Connection instance;

	public ConexaoDB() {
		instance = ConnectionFactory.getConnection();
	}

	public int executeSQL(String sql) throws SQLException {

		Statement statement = (Statement) instance.createStatement();
		return statement.executeUpdate(sql);

	}

	public int executeDelete(String sql) throws SQLException {

		Statement statement = (Statement) instance.createStatement();
		return statement.executeUpdate(sql);
	}
	
	public ResultSet executeConsulta(String sql) throws SQLException {
		Statement statement = (Statement) instance.createStatement();
		return statement.executeQuery(sql);
	}
}
