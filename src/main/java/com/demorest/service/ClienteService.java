package com.demorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.demorest.dto.ClienteDTO;
import com.demorest.entity.Cliente;
import com.demorest.repository.ClienteRepository;
import com.demorest.utils.CastUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Flux<ClienteDTO> getClientes(){
		
		return repository.findAll().map(CastUtils::entityToDTO);
	}
	
	public Mono<ClienteDTO> getCliente(String id){
		return repository.findById(id).map(CastUtils::entityToDTO);
	}
	

	
	public Flux<ClienteDTO> getClienteRange(int min,int max){
		return repository.findByCantidadBetween(Range.closed(min, max));
	}
	
	public Mono<ClienteDTO> saveCliente(Mono<ClienteDTO> clienteDTO){
		return clienteDTO.map(CastUtils::DtoToEntity)
				.flatMap(repository::insert)
				.map(CastUtils::entityToDTO);
	}
	
	public Mono<ClienteDTO> updateCliente(Mono<ClienteDTO> clienteDTO,String id){
		
		return repository.findById(id)
				.flatMap(p-> clienteDTO.map(CastUtils::DtoToEntity))
				.doOnNext(e->e.setCodigo(id))
				.map(CastUtils::entityToDTO);
	}
	
	public Mono<Void> deleteCliente(String id){
		return repository.deleteById(id);
	}
}
