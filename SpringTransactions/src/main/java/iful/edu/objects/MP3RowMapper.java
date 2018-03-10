package iful.edu.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class MP3RowMapper implements RowMapper<Mp3> {

	@Override
	public Mp3 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setId(rs.getInt("author_id"));
		author.setName(rs.getString("author_name"));
		Mp3 mp3 = new Mp3();
		mp3.setId(rs.getInt("mp3_id"));
		mp3.setName(rs.getString("mp3_name"));
		mp3.setAuthor(author);

		return mp3;
	}

}
