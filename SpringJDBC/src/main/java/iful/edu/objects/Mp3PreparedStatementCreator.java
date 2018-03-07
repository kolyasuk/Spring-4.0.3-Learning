package iful.edu.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class Mp3PreparedStatementCreator implements PreparedStatementCreator {
	String sql;
	String name;
	String author;

	public Mp3PreparedStatementCreator(String sql, String name, String author) {
		super();
		this.sql = sql;
		this.name = name;
		this.author = author;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql, new String[] { "id" });
		ps.setString(1, name);
		ps.setString(2, author);
		return ps;
	}

}
