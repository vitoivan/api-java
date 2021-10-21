package br.com.desafio.mv.models;

public class UserLogin {
	
	private Long id;
	private String name;
	private String cpf;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setId(Long userId) {
		id = userId;
	}
	public void setName(String userName) {
		name = userName;
	}
	public void setCpf(String userCpf) {
		cpf = userCpf;
	}
}
