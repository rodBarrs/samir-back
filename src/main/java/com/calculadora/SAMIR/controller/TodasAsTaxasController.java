package com.calculadora.SAMIR.controller;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.Date;
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
	public @ResponseBody List<TodasAsTaxasModelo> Taxas(@PathVariable("juros") int ju, @PathVariable("correcao") int cor) {
		List<TodasAsTaxasModelo> lista = new ArrayList<TodasAsTaxasModelo>();
		TodasAsTaxasModelo taxaModelo = new TodasAsTaxasModelo();

		List<Juros> juros = jurosRepository.findByTipoOrderByDataAsc(ju);
		List<TaxaDeCorrecao> correcao = correcaoRepository.findByTipoOrderByDataAsc(cor);
		List<TaxaReajuste> reajuste = reajusteRepository.findAllByOrderByDataAsc();
		int indiceReajuste = 0;
		int indiceCorrecao = 0;
		int indiceJuros = 2;
		int fim = 0;
		
		System.out.println("Size juros: " + juros.size());
		System.out.println("Size correcao: " + correcao.size());
		System.out.println("Size reajuste: " + reajuste.size());
		System.out.println("caralho");

		try {
			for (int j = 0; j < reajuste.size(); j++){
				taxaModelo.setDataRe(reajuste.get(j).getData());
				taxaModelo.setReajuste((reajuste.get(j).getReajusteAcumulado() / 100) + 1);
				Date date;
				LocalDate reajusteLocal = reajuste.get(j).getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				for(int i = 0; i < juros.size(); i++) {
					LocalDate jurosLocal = juros.get(i).getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					if(juros.get(i).getData().getMonth() == reajuste.get(j).getData().getMonth() && juros.get(i).getData().getYear() == reajuste.get(j).getData().getYear()){
						System.out.println("mes juros: " + juros.get(i).getData().getMonth()  +"  " + reajuste.get(j).getData().getMonth() );
						System.out.println("ano juros: " + juros.get(i).getData().getYear() + "  " + reajuste.get(j).getData().getYear());
						taxaModelo.setData(juros.get(i).getData());
						taxaModelo.setJurosAcumulado((juros.get(i).getJurosAcumulados() / 100));
						Object object;
						i = juros.size();
					}
				}
				for(int z = 0; z < correcao.size(); z++) {
					if(correcao.get(z).getData().getMonth() == reajuste.get(j).getData().getMonth() && correcao.get(z).getData().getYear() == reajuste.get(j).getData().getYear()){
						System.out.println("mes correcao: " + correcao.get(z).getData().getMonth() + "  " + reajuste.get(j).getData().getMonth());
						System.out.println("Ano correcao: " + correcao.get(z).getData().getYear() + "  " + reajuste.get(j).getData().getYear() );
						taxaModelo.setCorrecaoAcumulado((correcao.get(z).getTaxaAcumulada()));
						taxaModelo.setDataCor(correcao.get(z).getData());

						z = correcao.size();
					}
				}
				lista.add(taxaModelo);
				taxaModelo = new TodasAsTaxasModelo();
			}

			System.out.println(indiceCorrecao >= correcao.size());
			System.out.println(indiceJuros >= juros.size());
			System.out.println(indiceReajuste >= reajuste.size());
			/*while(indiceCorrecao <= correcao.size() || indiceJuros <= juros.size()  || indiceReajuste <= reajuste.size()) {

					taxaModelo.setCorrecaoAcumulado(correcao.get(indiceCorrecao).getTaxaAcumulada());
					taxaModelo.setDataCor(correcao.get(indiceCorrecao).getData());
					indiceCorrecao ++;
					System.out.println("index do correcao: " + indiceCorrecao);
					taxaModelo.setData(juros.get(indiceJuros).getData());
					taxaModelo.setJurosAcumulado(juros.get(indiceJuros).getJurosAcumulados());
					indiceJuros++;
					System.out.println("index do correcao: " + indiceCorrecao);
					taxaModelo.setDataRe(reajuste.get(indiceReajuste).getData());
					taxaModelo.setReajuste(reajuste.get(indiceReajuste).getReajusteAcumulado());
					System.out.println("index do Juros: " + indiceJuros);
					indiceJuros++;
				lista.add(taxaModelo);
				taxaModelo = new TodasAsTaxasModelo();

			}*/
		}
		catch (Exception e){
			System.out.println("errro: " + e);
		}

		
		
		/*for (int i = 0; i < juros.size(); i++) {
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
			}*/
		
		return lista;
}

}
