package br.com.negociata.Negociata.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.negociata.Negociata.models.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JogadorSimplesDTO {

	private Long id;
	private String nome;
	private Long idade;

	public static List<JogadorSimplesDTO> convert(List<Jogador> jogadores) {
		List<JogadorSimplesDTO> jogadoresDTO = new ArrayList<JogadorSimplesDTO>();
		if (jogadores != null) {
			for (Jogador j : jogadores) {
				jogadoresDTO.add(convert(j));
			}
		}
		return jogadoresDTO;
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public JogadorSimplesDTO(Long id, String nome, Long idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public JogadorSimplesDTO(String nome, long idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}



	public static JogadorSimplesDTO convert(Jogador j) {
		return new JogadorSimplesDTO(j.getId(), j.getNome(), j.getIdade());
	}

}
