package br.com.flavianeris.recrutamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flavianeris.recrutamento.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
