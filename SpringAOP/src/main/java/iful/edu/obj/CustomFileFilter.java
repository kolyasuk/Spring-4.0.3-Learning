package iful.edu.obj;

import java.io.File;
import java.io.FilenameFilter;

public class CustomFileFilter implements FilenameFilter {

	private String extantion;

	public CustomFileFilter(String extantion) {
		this.extantion = extantion;
	}

	@Override
	public boolean accept(File file, String name) {
		return name.toUpperCase().endsWith(extantion.toUpperCase());
	}

}
