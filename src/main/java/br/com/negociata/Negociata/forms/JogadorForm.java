package br.com.negociata.Negociata.forms;

import br.com.negociata.Negociata.models.Jogador;

public class JogadorForm {

	private String nome;
	private Long idade;
	
	

	public JogadorForm() {
	}
	
	

	public JogadorForm(String nome, Long idade) {
		this.nome = nome;
		this.idade = idade;
	}



	public Jogador convert() {
		Jogador j = new Jogador();
		j.setNome(this.nome);
		j.setIdade(this.idade);
		return j;
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

}
