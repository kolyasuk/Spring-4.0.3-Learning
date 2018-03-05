package iful.edu.obj;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import iful.edu.annotation.ShowResult;
import iful.edu.annotation.ShowTime;

@Component
public class FileManager2 {

	@ShowTime
	@ShowResult
	public Set<String> getExtensionList(String path) {
		File dir = new File(path);
		System.out.println("Dir: " + dir.getPath());
		Set<String> extList = new TreeSet<String>();

		for (File file : dir.listFiles()) {
			if (file.isFile() && file.getName().contains(".")) {
				String ext = file.getName();
				extList.add(ext.substring(ext.lastIndexOf(".")).toLowerCase());
			}
		}
		return extList;
	}

	@ShowTime
	@ShowResult
	public Map<String, Integer> getExtensionCount(String path) {
		File dir = new File(path);
		Map<String, Integer> extCount = new HashMap<String, Integer>();

		for (String ext : getExtensionList(path)) {
			FilenameFilter ff = new CustomFileFilter(ext);
			extCount.put(ext, dir.list(ff).length);
		}
		return extCount;
	}
}