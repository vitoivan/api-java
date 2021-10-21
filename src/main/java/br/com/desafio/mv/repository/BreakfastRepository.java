package br.com.desafio.mv.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.desafio.mv.models.Breakfast;

public interface BreakfastRepository extends JpaRepository<Breakfast, Long>{

	@Query(value = "INSERT INTO breakfast (user_id, food) VALUES (:id, :food) RETURNING *;", nativeQuery = true)
	public Breakfast register(@Param("id") Long id, @Param("food") String food);
	
	@Query(value = "SELECT * FROM breakfast;", nativeQuery = true)
	public ArrayList<Breakfast> getAll();
	
	@Query(value = "SELECT * FROM breakfast WHERE id = :id", nativeQuery = true)
	public Breakfast getOne(@Param("id") Long id);
	
	@Query(value = "DELETE FROM breakfast WHERE id = :id RETURNING *;", nativeQuery = true)
	public Breakfast deleteOne(@Param("id") Long id);
	
	@Query(value = "UPDATE breakfast SET food = :food WHERE id = :id RETURNING *;", nativeQuery = true)
	public Breakfast updateOne(@Param("id") Long id, @Param("food") String food);
}
