package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		var cliente1 = new Cliente(1L, "João das Couves", "34 99999-1111", "joaodascouves@algaworks.com");
		var cliente2 = new Cliente(2L, "Maria de Souza", "11 77777-7777", "mariadasilva@algaworks.com");
		return ResponseEntity.ok().body(Arrays.asList(cliente1, cliente2));
	}
}
