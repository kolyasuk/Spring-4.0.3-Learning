package iful.edu.spring.objects;

import javax.validation.constraints.Size;

public class User {
	@Size(min = 5, max = 10, message = "{name.size.error}")
	private String name;
	@Size(min = 5, max = 10, message = "{password.size.error}")
	private String password;
	private boolean admin;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
