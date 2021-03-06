package iful.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import iful.edu.dao.interfaces.MP3Dao;
import iful.edu.objects.Author;
import iful.edu.objects.MP3RowMapper;
import iful.edu.objects.Mp3;

@Component("sqliteDao")
public class SQLiteDao implements MP3Dao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	// @Transactional(propagation = Propagation.REQUIRED)
	public void insert(Mp3 mp3) {
		int authorId = insertAuthor(mp3.getAuthor());

		String sql = "insert into mp3 (name, author_id) VALUES (:name, :author_id)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("name", mp3.getName());
		param.addValue("author_id", authorId);
		jdbcTemplate.update(sql, param);
	}

	// if used JdbcTemplate need to use PreparedStatementCreator

	// @Transactional(propagation = Propagation.MANDATORY,
	// isolation=Isolation.SERIALIZABLE, timeout=1)
	public int insertAuthor(Author author) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into author (name) VALUES (:name)";
		MapSqlParameterSource param = new MapSqlParameterSource("name", author.getName());
		jdbcTemplate.update(sql, param, keyHolder);

		return keyHolder.getKey().intValue();
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
		String sql = "select * from mp3_view where mp3_id=:id";
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);

		return jdbcTemplate.queryForObject(sql, param, new MP3RowMapper());
	}

	@Override
	public List<Mp3> getMp3ListByName(String name) {
		return (List<Mp3>) myExecute("mp3_name", name);
	}

	@Override
	public List<Mp3> getMp3ListByAuthor(String author) {
		return (List<Mp3>) myExecute("author_name", author);
	}

	@Override
	public int getMp3Count() {
		String sql = "select count(*) from mp3";

		return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
	}

	// getting object by MP3RowMapper | possibly use ResultSetExtractor
	private Object myExecute(String fieldName, String fieldValue) {
		String sql = "select * from mp3_view where " + fieldName + "=:field";
		MapSqlParameterSource param = new MapSqlParameterSource("field", fieldValue);

		return jdbcTemplate.query(sql, param, new MP3RowMapper());
	}

	// filling map by ResultSetExtractor | possibly use MP3RowMapper
	public Map<String, Integer> getGroupValues() {
		String sql = "select author_name, count(*) as count from mp3_view group by author_name";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, Integer>>() {
			@Override
			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, Integer> map = new TreeMap<>();
				while (rs.next()) {
					map.put(rs.getString("author_name"), rs.getInt("count"));
				}
				return map;
			}
		});
	}

}
