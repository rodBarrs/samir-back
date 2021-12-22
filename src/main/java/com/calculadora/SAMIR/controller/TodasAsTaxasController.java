package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public TodasAsTaxasModelo[] todasTaxas(@PathVariable ("juros") int ju,@PathVariable ("correcao") int cor) {
		
		TodasAsTaxasModelo[] taxasArray = new TodasAsTaxasModelo[10000];
		List<Juros> juros = jurosRepository.findByTipoOrderByCodigoAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByCodigoAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAll();
		int x = 0;
		for(int i = 0; i <= 100000; i++) {
			TodasAsTaxasModelo taxasRepository = new TodasAsTaxasModelo();
			if(i <= reajuste.size()) {
				taxasRepository.setReajuste(reajuste.get(i));
				x++;
			}
			if(i<=correcao.size()) {
				taxasRepository.setCorrecao(correcao.get(i));
				x++;
			}
			if(i <= juros.size()) {
				taxasRepository.setJuros(juros.get(i));
				x++;
			}
			if(x == 3) {
				i = 100000;
			}
			taxasArray[i] = taxasRepository;
		}
		
		
		return taxasArray;
		
	}

}