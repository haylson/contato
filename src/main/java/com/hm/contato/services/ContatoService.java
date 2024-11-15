package com.hm.contato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.contato.domain.Contato;
import com.hm.contato.domain.dtos.ContatoDTO;
import com.hm.contato.repositories.ContatoRepository;
import com.hm.contato.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll() {
		return repository.findAll();
	}
	
	public Contato findById(Long id) {
		Optional<Contato> contato = repository.findById(id);
		return contato.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public Contato create(ContatoDTO contatoDTO) {
		//contatoDTO.setCodigo(null);
		//validaPorCpfEEmail(contatoDTO);
		Contato newContato = new Contato(contatoDTO);
		return repository.save(newContato);
	}
	
	public Contato update(Long id, @Valid ContatoDTO contatoDTO) {
		contatoDTO.setId(id);
		Contato contato = findById(id);
		//validaPorCpfEEmail(contatoDTO);
		contato = new Contato(contatoDTO);
		return repository.save(contato);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/*private void validaPorCpfEEmail(ContatoDTO contatoDTO) {
		
		Optional<Contato> obj = repository.findByCpf(contatoDTO.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != contatoDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = repository.findByEmail(contatoDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != contatoDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
		
	}*/


	

}
