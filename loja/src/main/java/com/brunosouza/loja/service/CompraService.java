package com.brunosouza.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brunosouza.loja.controller.dto.InfoFornecedorDTO;
import com.brunosouza.loja.controller.dto.compraDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;

	public void realizarCompra(compraDTO compra) {
		
		ResponseEntity<InfoFornecedorDTO> exchange = 
		client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
