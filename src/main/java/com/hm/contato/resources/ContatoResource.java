package com.hm.contato.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hm.contato.domain.Contato;
import com.hm.contato.domain.dtos.ContatoDTO;
import com.hm.contato.services.ContatoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContatoDTO> findById(@PathVariable Long id) {
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(new ContatoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ContatoDTO>> findAll() {
		List<Contato> list = service.findAll();
		List<ContatoDTO> listDTO = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoDTO objDTO) {
		Contato newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContatoDTO> update(@PathVariable Long id, @Valid @RequestBody ContatoDTO objDTO) {
		Contato obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ContatoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ContatoDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
    
	
}
