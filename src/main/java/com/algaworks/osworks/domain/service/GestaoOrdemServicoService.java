package com.algaworks.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Comentario;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.repository.ComentarioRepository;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestaoOrdemServicoService {

	@NonNull
	private OrdemServicoRepository ordemServicoRepository;

	@NonNull
	private ClienteRepository clienteRepository;

	@NonNull
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		var cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		ordemServico.setCliente(cliente);
		ordemServico.iniciar();

		return ordemServicoRepository.save(ordemServico);
	}

	public void finalizar(Long id) {
		var ordemServico = buscar(id);
		ordemServico.finalizar();
		ordemServicoRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long id, String descricao) {
		var ordemServico = buscar(id);
		var comentario = new Comentario(ordemServico, descricao, OffsetDateTime.now());

		return comentarioRepository.save(comentario);
	}

	private OrdemServico buscar(Long id) {
		return ordemServicoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
	}
}
