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

	@SuppressWarnings("deprecation")
	@GetMapping("todas/{juros}/{correcao}")
	public TodasAsTaxasModelo[] todasTaxas(@PathVariable("juros") int ju, @PathVariable("correcao") int cor) {
		TodasAsTaxasModelo[] lista = new TodasAsTaxasModelo[10000];

		List<Juros> juros = jurosRepository.findByTipoOrderByCodigoAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByCodigoAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAll();
		int indiceReajuste = 0;
		int indiceJuros = 0;
		int indiceCorrecao = 0;

		for (int i = 0; i <= 1000; i++) {

			if (indiceReajuste <= reajuste.size() - 1) {
				while (reajuste.get(indiceReajuste).getData() != correcao.get(indiceCorrecao).getData() && reajuste
						.get(indiceReajuste).getData().getYear() != correcao.get(indiceCorrecao).getData().getYear()) {

					indiceCorrecao++;
					if (indiceCorrecao == correcao.size() - 1) {
						indiceCorrecao = 0;
						break;
					}

				}
				while (reajuste.get(indiceReajuste).getData() != juros.get(indiceJuros).getData() && reajuste
						.get(indiceReajuste).getData().getYear() != juros.get(indiceJuros).getData().getYear()) {
					indiceJuros++;
					if (indiceJuros == juros.size() - 1) {
						indiceJuros = 0;
					}

				}
				TodasAsTaxasModelo taxa = new TodasAsTaxasModelo();
				if (indiceJuros <= juros.size() - 1 && taxa.getData() == juros.get(indiceJuros).getData()) {
					taxa.setJurosAcumulado(juros.get(indiceJuros).getJurosAcumulados());
				}
				if (indiceCorrecao <= correcao.size() - 1 && taxa.getData() == correcao.get(indiceCorrecao).getData()) {
					taxa.setCorrecaoAcumulado(correcao.get(indiceCorrecao).getTaxaAcumulada());
				}
				taxa.setData(reajuste.get(indiceReajuste).getData());
				taxa.setReajuste(reajuste.get(indiceReajuste).getReajusteAcumulado());
				lista[i] = taxa;
			}

			indiceCorrecao++;
			indiceJuros = 0;
			indiceReajuste++;
		}

		return lista;

	}

	@SuppressWarnings("deprecation")
	@GetMapping("todasTaxas/{juros}/{correcao}")
	public TodasAsTaxasModelo[] Taxas(@PathVariable("juros") int ju, @PathVariable("correcao") int cor) {
		TodasAsTaxasModelo[] lista = new TodasAsTaxasModelo[10000];

		List<Juros> juros = jurosRepository.findByTipoOrderByCodigoAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByCodigoAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAll();
		int indiceReajuste = 0;
		int indiceJuros = 0;
		int indiceCorrecao = 0;
		int j = 2;
		for (int i = 0; i < juros.size(); i++) {
			if(juros.get(i).getData() == correcao.get(indiceCorrecao).getData()) {
				j = i;
			}
		}
		System.out.println("aqui e o j" + j);
		for (int i = 0; i < juros.size(); i++) {
			TodasAsTaxasModelo taxa = new TodasAsTaxasModelo();
			taxa.setData(juros.get(i).getData());
			taxa.setJurosAcumulado(juros.get(i).getJurosAcumulados());
			lista[i] = taxa;	
			}
		for (int i = 2; i < juros.size(); i++) {
			TodasAsTaxasModelo taxa = new TodasAsTaxasModelo();
			if(indiceCorrecao < correcao.size()) {
				taxa.setCorrecaoAcumulado(correcao.get(indiceCorrecao).getTaxaAcumulada());
				taxa.setDataCor(correcao.get(indiceCorrecao).getData());
				indiceCorrecao ++;
			}
			taxa.setData(juros.get(i).getData());
			taxa.setJurosAcumulado(juros.get(i).getJurosAcumulados());
			
			lista[i] = taxa;	
			}
		for (int i = 6; i < juros.size(); i++) {
			TodasAsTaxasModelo taxa = new TodasAsTaxasModelo();
			taxa = lista[i];
			if(indiceReajuste < reajuste.size()) {
				taxa.setDataRe(reajuste.get(indiceReajuste).getData());
				taxa.setReajuste(reajuste.get(indiceReajuste).getReajusteAcumulado());
				indiceReajuste ++;
			}
			taxa.setData(juros.get(i).getData());
			taxa.setJurosAcumulado(juros.get(i).getJurosAcumulados());
			
			lista[i] = taxa;	
			}
		
		return lista;
}

}
