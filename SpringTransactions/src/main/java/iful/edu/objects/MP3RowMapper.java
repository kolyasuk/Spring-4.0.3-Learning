package iful.edu.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class MP3RowMapper implements RowMapper<Mp3> {

	@Override
	public Mp3 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mp3 mp3 = new Mp3();
		mp3.setId(rs.getInt("id"));
		mp3.setName(rs.getString("name"));
		mp3.setAuthor(rs.getString("author"));

		return mp3;
	}

}
