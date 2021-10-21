package br.com.desafio.mv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.desafio.mv.models.Breakfast;
import br.com.desafio.mv.models.User;

public interface  UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "INSERT INTO users (name,cpf,password) VALUES (:name, :cpf, :pwd) RETURNING *", nativeQuery = true)
	public User register(@Param("name") String name, @Param("cpf") String cpf,@Param("pwd") String password);
	
	
	@Query(value = "SELECT * from users WHERE cpf = :cpf", nativeQuery = true)
	public Optional<User> login(@Param("cpf") String cpf);
	
	@Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
	public User getOne(@Param("id") Long id);
}
