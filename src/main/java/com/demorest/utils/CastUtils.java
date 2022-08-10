package com.demorest.utils;

import org.springframework.beans.BeanUtils;

import com.demorest.dto.ClienteDTO;
import com.demorest.entity.Cliente;

public class CastUtils {

	public static ClienteDTO entityToDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		BeanUtils.copyProperties(cliente, clienteDTO);
		return clienteDTO;
	}
	
	public static Cliente DtoToEntity(ClienteDTO clientedto) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clientedto, cliente);
		return cliente;
	}
}
