package com.demorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demorest.dto.ClienteDTO;
import com.demorest.entity.Cliente;
import com.demorest.service.ClienteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public Flux<ClienteDTO> getClientes(){
		return service.getClientes();
	}
	
	@GetMapping("/{id}")
	public Mono<ClienteDTO> getCliente(@PathVariable String id){
		return service.getCliente(id);
	}
	
	@GetMapping("/client-range")
	public Flux<ClienteDTO> getClienteRange(@RequestParam("min") int min,@RequestParam("max") int max){
		return service.getClienteRange(min,max);
	}
	
	@PostMapping
	public Mono<ClienteDTO> saveClient(@RequestBody Mono<ClienteDTO> cliente){
		return service.saveCliente(cliente);
	}
	
	@PutMapping("update/{id}")
	public Mono<ClienteDTO> saveClient(@RequestBody Mono<ClienteDTO> cliente,@PathVariable String id){
		return service.updateCliente(cliente,id);
	}
	
	@DeleteMapping
	public Mono<Void> deleteCliente(@PathVariable String id){
		return service.deleteCliente(id);
	}
}
