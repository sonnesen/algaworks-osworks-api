package com.algaworks.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Problema {

	@NonNull
	private Integer status;
	@NonNull
	private LocalDateTime dataHora;
	@NonNull
	private String titulo;

	private List<Campo> campos = new ArrayList<>();

	public void adicionarCampo(Campo campo) {
		this.campos.add(campo);
	}

	@Getter
	@AllArgsConstructor
	static class Campo {
		private String nome;
		private String mensagem;
	}

}
