package com.dna.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dna.model.Data;
import com.dna.model.SerVivo;
import com.dna.repository.ISerVivoRepository;
import com.dna.service.SerVivoService;

@RestController
@CrossOrigin("*")
public class SerVivoController {

	@Autowired
	SerVivoService service;
	
	@Autowired
	ISerVivoRepository repo;
	
	@PostMapping("/simian")	
	public ResponseEntity<String[]> validarDNA(@RequestBody SerVivo ser)
	{		
		
		if(service.isSimian(ser.getDna()))
			return ResponseEntity.status(HttpStatus.OK).body(ser.getDna());
		else
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ser.getDna());		
	}
	
	@PostMapping("")
	public SerVivo salvar(@RequestBody @Valid SerVivo ser) 
	{
		return service.salvar(ser);
	}
	
	@GetMapping("/stats")
	public Data rate() 
	{
		return repo.rate();
	}
	
}
