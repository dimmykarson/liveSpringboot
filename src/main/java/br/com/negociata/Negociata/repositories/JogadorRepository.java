package br.com.negociata.Negociata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.negociata.Negociata.models.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
