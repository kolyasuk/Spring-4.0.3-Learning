package iful.edu.main;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iful.edu.dao.impl.SQLiteDao;
import iful.edu.objects.Mp3;

public class Start {
	public static void main(String[] args) {
		Mp3 mp3 = new Mp3();
		mp3.setName("111");
		mp3.setAuthor("111");

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDao mp3Dao = (SQLiteDao) context.getBean("sqliteDao");
		for(Map.Entry<String, Integer> x : mp3Dao.getGroupValues().entrySet()) {
			System.out.println(x.getKey()+" - "+x.getValue());
		}

	}

}
