package iful.edu.interfaces;

import java.util.Map;
import java.util.Set;

public interface Manager {

	public Set<String> getExtensionList(String path);

	public Map<String, Integer> getExtensionCount(String path);

}
