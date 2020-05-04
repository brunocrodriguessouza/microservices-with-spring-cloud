package com.brunosouza.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunosouza.loja.controller.dto.CompraDTO;
import com.brunosouza.loja.model.Compra;
import com.brunosouza.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Compra realizarCompra(@RequestBody CompraDTO compra) {
		return compraService.realizarCompra(compra);
	}
}
