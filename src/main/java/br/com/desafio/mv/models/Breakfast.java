package br.com.desafio.mv.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "breakfast")
public class Breakfast {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private String food;
	
	public Long getId() {
		return id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public String getFood() {
		return food;
	}
	
	public void setUserId(Long newUserId) {
		userId = newUserId;
	}
	
	
	public void setFood(String newFood) {
		String newStr = "";
		String words[] = newFood.split(" ");
		for (String w: words) {
			String firstLetter = w.substring(0, 1);
			String rest = w.substring(1);
			
			newStr += firstLetter.toUpperCase() + rest.toLowerCase() + " ";
		}
		food = newStr.trim();
	}
}
