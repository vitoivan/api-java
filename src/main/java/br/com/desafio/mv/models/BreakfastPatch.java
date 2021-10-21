package br.com.desafio.mv.models;

public class BreakfastPatch {
	
	private Long id;
	private String food;
	
	public String getFood() {
		return food;
	}
	
	public Long getId() {
		return id;
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
	
	public void setId(Long newId) {
		id = newId;
	}
}
