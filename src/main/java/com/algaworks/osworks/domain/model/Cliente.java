package com.algaworks.osworks.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Cliente {

	private Long id;
	
	@NonNull
	private String nome;
	
	@NonNull
	private String email;
	
	@NonNull
	private String telefone;
}
