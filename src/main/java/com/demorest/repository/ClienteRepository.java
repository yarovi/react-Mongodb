package com.demorest.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.demorest.dto.ClienteDTO;
import com.demorest.entity.Cliente;

import reactor.core.publisher.Flux;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String>{

	Flux<ClienteDTO> findByCantidadBetween(Range<Integer> closed);

}
