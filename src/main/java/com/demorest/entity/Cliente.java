package com.demorest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	String codigo;
	String nroDocumento;
	String nombres;
	Double prestamo;
	int cantidad;
	
}
