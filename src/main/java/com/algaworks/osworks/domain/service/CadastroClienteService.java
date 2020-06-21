package com.algaworks.osworks.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroClienteService {

	@NonNull
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		var optional = clienteRepository.findByEmail(cliente.getEmail());

		if (optional.isPresent() && !optional.get().equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail!");
		}

		return clienteRepository.save(cliente);
	}

	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
