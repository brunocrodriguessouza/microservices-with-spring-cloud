package com.brunosouza.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brunosouza.loja.controller.dto.InfoFornecedorDTO;
import com.brunosouza.loja.controller.dto.ItemDaCompraDTO;
import com.brunosouza.loja.dto.InfoPedidoDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method = RequestMethod.POST, value="/pedido")
	InfoPedidoDTO realizarPedido(List<ItemDaCompraDTO> itens);

}
