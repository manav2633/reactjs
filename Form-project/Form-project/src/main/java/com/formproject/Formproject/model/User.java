package com.formproject.Formproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String name;

   
    private String email;

  
    private String password;

   
    private String fileName;

    // Constructors
    public User() {
    }

    public User(String name, String email, String password, String fileName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.fileName = fileName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Transient
   public String getFilePath() {
       if (fileName == null || id == 0 ) return null;
        
       return "D://Form-project (1)//Form-project//Form-project//user-files/" +  fileName;
   }

	

    // Getters and Setters (Omitted for brevity)

}