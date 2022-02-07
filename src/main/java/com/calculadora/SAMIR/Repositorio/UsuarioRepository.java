package com.calculadora.SAMIR.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculadora.SAMIR.Modelo.UsuarioModelo;

public interface UsuarioRepository extends JpaRepository<UsuarioModelo, Integer> {
	
	UsuarioModelo findByCpf(String cpf);
	 
	UsuarioModelo findByNome(String nome);
}
