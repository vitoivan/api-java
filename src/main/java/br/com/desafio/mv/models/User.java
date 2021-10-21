package br.com.desafio.mv.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User
{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String password;
	
	
	
	//getters
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	public String getCpf() {
		return cpf;
	}
	
	// setters
	public void setId(Long userId) {
		id =  userId;
	}
	
	public void setName(String userName) {
		name =  userName;
	}
	
	public void setCpf(String userCpf) {
		cpf =  userCpf;
	}
	
	public void setPassword(String userPassword) {
		password = userPassword;
	}
}
