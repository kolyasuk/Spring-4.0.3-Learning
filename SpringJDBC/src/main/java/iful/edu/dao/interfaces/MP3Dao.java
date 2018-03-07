package iful.edu.dao.interfaces;

import java.util.List;

import iful.edu.objects.Mp3;

public interface MP3Dao {

	void insert(Mp3 mp3);

	void insert(List<Mp3> mp3);

	void delete(Mp3 mp3List);

	void delete(int id);

	Mp3 getMp3ById(int id);

	List<Mp3> getMp3ListByName(String name);

	List<Mp3> getMp3ListByAuthor(String author);

	int getMp3Count();

}
