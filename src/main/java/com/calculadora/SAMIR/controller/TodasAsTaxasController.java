package com.calculadora.SAMIR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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



	
	@GetMapping("todasTaxas/{juros}/{correcao}")
	public @ResponseBody TodasAsTaxasModelo[] Taxas(@PathVariable("juros") int ju, @PathVariable("correcao") int cor) {
		TodasAsTaxasModelo[] lista = new TodasAsTaxasModelo[10000];

		List<Juros> juros = jurosRepository.findByTipoOrderByDataAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByDataAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAllByOrderByDataAsc();
		int indiceReajuste = 0;
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
				taxa.setCorrecaoAcumulado((correcao.get(indiceCorrecao).getTaxaAcumulada() / 100) + 1);
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
				taxa.setReajuste((reajuste.get(indiceReajuste).getReajusteAcumulado() / 100) + 1);
				indiceReajuste ++;
			}
			taxa.setData(juros.get(i).getData());
			taxa.setJurosAcumulado((juros.get(i).getJurosAcumulados() / 100));
			
			lista[i] = taxa;	
			}
		
		return lista;
}

}
