package iful.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iful.edu.dao.impl.SQLiteDao;
import iful.edu.objects.Author;
import iful.edu.objects.Mp3;

public class Start {
	public static void main(String[] args) {

		Author author2 = new Author();
		author2.setName("testAuthorName");
		Mp3 mp32 = new Mp3();
		mp32.setName("testMP3Name");
		mp32.setAuthor(author2);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDao mp3Dao = (SQLiteDao) context.getBean("sqliteDao");

		/*
		 * for (Map.Entry<String, Integer> x : mp3Dao.getGroupValues().entrySet()) {
		 * System.out.println(x.getKey() + " - " + x.getValue()); }
		 */

		mp3Dao.insert(mp32);

	}

}
