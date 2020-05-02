package com.brunosouza.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosouza.fornecedor.model.InfoFornecedor;
import com.brunosouza.fornecedor.repository.InfoRepository;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;

	public InfoFornecedor getInfoPorEstado(String estado) {
		
		return infoRepository.findByEstado(estado);
		
	}

}
