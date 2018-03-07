package iful.edu.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import iful.edu.dao.interfaces.MP3Dao;
import iful.edu.objects.MP3RowMapper;
import iful.edu.objects.Mp3;
import iful.edu.objects.Mp3PreparedStatementCreator;

@Component("sqliteDao")
public class SQLiteDao implements MP3Dao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void insert(Mp3 mp3) {
		String sql = "insert into mp3 (name, author) VALUES (:name, :author)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", mp3.getName());
		param.addValue("author", mp3.getAuthor());
		jdbcTemplate.update(sql, param);
	}

	@Override
	public void insert(List<Mp3> mp3List) {
		for (Mp3 mp3 : mp3List) {
			insert(mp3);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from mp3 where id=:id";
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(Mp3 mp3) {
		delete(mp3.getId());
	}

	@Override
	public Mp3 getMp3ById(int id) {
		String sql = "select * from mp3 where id=:id";
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);

		return jdbcTemplate.queryForObject(sql, param, new MP3RowMapper());
	}

	@Override
	public List<Mp3> getMp3ListByName(String name) {
		return (List<Mp3>) myExecute("name", name);
	}

	@Override
	public List<Mp3> getMp3ListByAuthor(String author) {
		return (List<Mp3>) myExecute("author", author);
	}

	@Override
	public int getMp3Count() {
		String sql = "select count(*) from mp3";

		return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
	}

	private Object myExecute(String fieldName, String fieldValue) {
		String sql = "select * from mp3 where " + fieldName + "=:field";
		MapSqlParameterSource param = new MapSqlParameterSource("field", fieldValue);

		return jdbcTemplate.query(sql, param, new MP3RowMapper());
	}

	public int getinsertID(String name, String author) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into mp3 (name, author) VALUES (?, ?)";

		jdbcTemplate.getJdbcOperations().update(new Mp3PreparedStatementCreator(sql, name, author), keyHolder);
		return keyHolder.getKey().intValue();

	}

}
