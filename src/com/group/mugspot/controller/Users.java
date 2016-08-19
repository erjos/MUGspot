package com.group.mugspot.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;
	
	public void setID(int iD) {
		ID = iD;
	}

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
		public Users(){}
		
		public Users(String fullname, String password, String email){
			this.fullname=fullname;
			this.password=password;
			this.email=email;
			
		}
		public String getfullname() {
			return fullname;
		}
		public String getPassword() {
			return password;
		}
		public void setfullname(String fullname) {
			this.fullname = fullname;
		}
		
		public void setPassword(String password) throws NoSuchAlgorithmException {
				MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(password.getBytes());
		        byte byteData[] = md.digest();
		 
		        final StringBuilder builder = new StringBuilder();
		        
		        for(byte b : byteData) {
		            builder.append(String.format("%02x", b));
		        }
		        
		        this.password = builder.toString();
			}
			
		
		public void resetPassword(){
				this.password = null;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email.toLowerCase();
		}
	
		public int getID() {
			return ID;
		}
}

