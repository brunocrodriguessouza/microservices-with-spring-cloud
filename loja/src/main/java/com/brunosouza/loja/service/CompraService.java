package com.brunosouza.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brunosouza.loja.controller.dto.InfoFornecedorDTO;
import com.brunosouza.loja.controller.dto.compraDTO;
//import com.netflix.discovery.DiscoveryClient;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	public void realizarCompra(compraDTO compra) {
		
		ResponseEntity<InfoFornecedorDTO> exchange = 
		client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(fornecedor -> {
			System.out.println("localhost" + fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
