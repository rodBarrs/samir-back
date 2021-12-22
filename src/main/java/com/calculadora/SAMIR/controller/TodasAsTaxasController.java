package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.Ativo;
import com.calculadora.SAMIR.Modelo.Juros;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Modelo.TaxaReajuste;
import com.calculadora.SAMIR.Modelo.TodasAsTaxasModelo;
import com.calculadora.SAMIR.Repositorio.CorrecaoRepository;
import com.calculadora.SAMIR.Repositorio.JurosRepositorio;
import com.calculadora.SAMIR.Repositorio.ReajusteRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/taxas")
public class TodasAsTaxasController {
	@Autowired
	private CorrecaoRepository correcaoRepository;
	@Autowired
	private JurosRepositorio jurosRepository;
	@Autowired
	private ReajusteRepositorio reajusteRepository;
	@GetMapping("todas/{juros}/{correcao}")
	public TodasAsTaxasModelo todasTaxas(@PathVariable ("juros") int ju,@PathVariable ("correcao") int cor) {
		
		
		List<Juros> juros = jurosRepository.findByTipoOrderByCodigoAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByCodigoAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAll();
		
		TodasAsTaxasModelo taxa = new TodasAsTaxasModelo(correcao, reajuste, juros);
		
		return taxa;
		
	}

}
