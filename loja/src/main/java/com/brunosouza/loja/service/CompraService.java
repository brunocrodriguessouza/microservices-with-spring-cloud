package com.brunosouza.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.loja.client.FornecedorClient;
import com.brunosouza.loja.controller.dto.CompraDTO;
import com.brunosouza.loja.controller.dto.InfoFornecedorDTO;
import com.brunosouza.loja.dto.InfoPedidoDTO;
import com.brunosouza.loja.model.Compra;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizarCompra(CompraDTO compra) {
		
		System.out.println(compra.getEndereco().toString());
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("buscando informacoes do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizarPedido(compra.getItens());
				
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		return compraSalva;
	}

}
