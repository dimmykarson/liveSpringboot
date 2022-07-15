package br.com.negociata.Negociata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.negociata.Negociata.dtos.JogadorSimplesDTO;
import br.com.negociata.Negociata.forms.JogadorForm;
import br.com.negociata.Negociata.models.Jogador;
import br.com.negociata.Negociata.repositories.JogadorRepository;

@Component
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	
	
	public JogadorService(JogadorRepository jogadorRepository) {
		this.jogadorRepository = jogadorRepository;
	}

	public List<JogadorSimplesDTO> listaSimples() {
		
		List<Jogador> jogadores = jogadorRepository.findAll();

		return JogadorSimplesDTO.convert(jogadores);
	}

	public JogadorSimplesDTO salvar(JogadorForm jogadorForm) {
		Jogador j = jogadorForm.convert();
		
		jogadorRepository.save(j);
		
		return JogadorSimplesDTO.convert(j);
	}
	
	public void deletar(Long id) {
		jogadorRepository.deleteById(id);
	}
	
	public void atualizar(Long id, JogadorForm jogadorForm) {
		Optional<Jogador> opt = jogadorRepository.findById(id);
		if(opt.isPresent()) {
			Jogador jogador = opt.get();
			jogador.setNome(jogadorForm.getNome());
			jogador.setIdade(jogadorForm.getIdade());
			jogadorRepository.save(jogador);
		}
		
	}
	

}
