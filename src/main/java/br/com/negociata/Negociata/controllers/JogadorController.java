package br.com.negociata.Negociata.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.negociata.Negociata.dtos.JogadorSimplesDTO;
import br.com.negociata.Negociata.forms.JogadorForm;
import br.com.negociata.Negociata.services.JogadorService;


@RestController
@RequestMapping("/jogadores")
public class JogadorController {
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public String getStatus() {
		return "Está tudo on!";
	}
	
	@GetMapping("/lista/simples")
	public ResponseEntity<List<JogadorSimplesDTO>> listaJogadores(){
		return ResponseEntity.ok().body(jogadorService.listaSimples());
	}
	
	@PostMapping
	public ResponseEntity<JogadorSimplesDTO> salvar(
			@RequestBody
			JogadorForm jogadorForm){
		
		JogadorSimplesDTO jogadorDTO =  jogadorService.salvar(jogadorForm);
		
		return ResponseEntity.ok().body(jogadorDTO);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		jogadorService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, 
			@RequestBody JogadorForm jogadorForm) {
		jogadorService.atualizar(id, jogadorForm);
		return ResponseEntity.ok().build();
	}
	
	

}
