package com.mie.model;

import java.util.Date;

public class Member {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Member object.
	 */
	private int user_id;
	//private String firstName;
	private String Name;
	//private String username;
	private String password;
	private String email;
	private String SkinType_ID;
	private boolean valid;

	public int getUser_ID() {
		return user_id;
	}

	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSkinType_ID() {
		return SkinType_ID;
	}

	public void setSkinType_ID(String SkinType_ID) {
		this.SkinType_ID = SkinType_ID;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	@Override
	public String toString() {
		return "Member [user_id=" + user_id + ", Name=" + Name 
				+ ", password=" + password + ", email=" + email + "]";
	}
}