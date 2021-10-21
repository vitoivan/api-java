package br.com.desafio.mv.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.mv.models.Breakfast;
import br.com.desafio.mv.models.BreakfastPatch;
import br.com.desafio.mv.repository.BreakfastRepository;

@RestController
@RequestMapping("/api/breakfast")
public class BreakfastController {
	
	@Autowired
	private BreakfastRepository breakfastRepository;
	
	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<?> register(@RequestBody Breakfast breakfast) {
		try {
			Breakfast breakfastRegistered = breakfastRepository.register(breakfast.getUserId(), breakfast.getFood());
			
			return new ResponseEntity<Breakfast>(breakfastRegistered, HttpStatus.CREATED);
		}
		catch (DataIntegrityViolationException e) {
			return new ResponseEntity<String>("DADOS INVALIDOS", HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@GetMapping("")
	public ArrayList<Breakfast> getAll(){
		return breakfastRepository.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id){
		Breakfast item = breakfastRepository.getOne(id);
		
		if (item == null) {
			return new ResponseEntity<String>("Não foi possível encontrar elemento", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Breakfast>(item, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateOne(@PathVariable("id") Long id, @RequestBody BreakfastPatch breakfast){
		try {
			Breakfast updated =  breakfastRepository.updateOne(id, breakfast.getFood());
			
			if (updated == null) {
				return new ResponseEntity<String>("Não foi possível encontrar elemento", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Breakfast>(updated, HttpStatus.OK);
		}
		catch (DataIntegrityViolationException e) {
			return new ResponseEntity<String>("Alimento já registrado", HttpStatus.CONFLICT);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable("id") Long id){
		Breakfast deleted = breakfastRepository.deleteOne(id);
		
		if (deleted == null) {
			return new ResponseEntity<String>("Registro não encontrado", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Breakfast>(deleted, HttpStatus.NO_CONTENT);
	}
}
