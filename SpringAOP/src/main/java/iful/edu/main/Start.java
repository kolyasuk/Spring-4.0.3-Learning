package iful.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iful.edu.obj.FileManager;
import iful.edu.obj.FileManager2;

public class Start {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		FileManager fm = (FileManager) context.getBean("fileManager");
		FileManager2 fm2 = (FileManager2) context.getBean("fileManager2");

		fm.getExtensionCount("C:\\Windows\\System32");
		fm.getExtensionList("C:\\Windows\\System32");
		fm2.getExtensionCount("C:\\Windows\\System32");
		fm2.getExtensionList("C:\\Windows\\System32");
	}

}
