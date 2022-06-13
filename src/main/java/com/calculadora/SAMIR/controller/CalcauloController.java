package com.calculadora.SAMIR.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculadora.SAMIR.Modelo.Calculo;
import com.calculadora.SAMIR.Modelo.InfoCalculo;
import com.calculadora.SAMIR.Modelo.Juros;
import com.calculadora.SAMIR.Modelo.SalarioMinimo;
import com.calculadora.SAMIR.Modelo.TaxaDeCorrecao;
import com.calculadora.SAMIR.Modelo.TaxaReajuste;
import com.calculadora.SAMIR.Repositorio.CorrecaoRepository;
import com.calculadora.SAMIR.Repositorio.JurosRepositorio;
import com.calculadora.SAMIR.Repositorio.ReajusteRepositorio;
import com.calculadora.SAMIR.Repositorio.SalarioMinimoRepository;

@RestController
@CrossOrigin
@RequestMapping("/calculo")
public class CalcauloController {

	@Autowired
	private ReajusteRepositorio reajusteRepositorio;
	@Autowired
	private JurosRepositorio jurosRepositorio;
	@Autowired
	private CorrecaoRepository correcaoRepository;
	@Autowired
	private SalarioMinimoRepository salarioMinimoRepository;

	@PostMapping("/calcular")
	public @ResponseBody Object calcular(@RequestBody InfoCalculo informacoes) {
		try {
			String[] arrayDib = informacoes.getDib().split("/");
			int mesDib = Integer.parseInt(arrayDib[1]);
			int anoDib = Integer.parseInt(arrayDib[2]);
			String[] arrayDip = informacoes.getDip().split("/");
			int mesDip = Integer.parseInt(arrayDip[1]);
			int anoDip = Integer.parseInt(arrayDip[2]);
			String[] arrayAtualizacao = informacoes.getAtulizacao().split("/");
			int mesAtualizacao = Integer.parseInt(arrayAtualizacao[0]);
			int anoAtualizacao = Integer.parseInt(arrayAtualizacao[1]);
			int mesIncioJuros = 0;
			int anoIncioJuros = 0;
			if (informacoes.getIncioJuros() != null) {
				String[] arrayInicioJuros = informacoes.getIncioJuros().split("/");
				mesIncioJuros = Integer.parseInt(arrayInicioJuros[0]) - 1;
				anoIncioJuros = Integer.parseInt(arrayInicioJuros[1]);
				if (mesIncioJuros == 0) {
					mesIncioJuros = 12;
					anoIncioJuros--;
				}

			}

			List<Calculo> listCalculo = new ArrayList<Calculo>();
			List<SalarioMinimo> listaSalarioMinimo = new ArrayList<SalarioMinimo>();
			if(informacoes.isSalarioMinimo() || informacoes.isLimiteMinimoMaximo()) {
				listaSalarioMinimo = salarioMinimoRepository.findAll();
			}
			List<TaxaReajuste> listReajuste = reajusteRepositorio.findAll();
			List<TaxaDeCorrecao> listCorrecao = correcaoRepository
					.findByTipoOrderByDataAsc(informacoes.getTipoCorrecao());
			List<Juros> listJuros = jurosRepositorio.findByTipoOrderByDataAsc(informacoes.getTipoJuros());

			float correcaoAcumulada = 1;
			float jurosAcumulado = 0;
			float reajusteAcumulado = 1;

			int mesCalculo = mesDib;
			int anoCalculo = anoDib;
			float rmi = informacoes.getRmi();
			float reajuste = 1;
			int confirmadoData = 0;

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			

			if (anoCalculo <= anoDip) {
				while (anoCalculo != anoDip + 1) {

					SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					String dataCalculo = out.format(in.parse(anoCalculo + "-" + mesCalculo + "-01"));
					
					// coloca o reajuste
					if (mesCalculo == 1) {
						//quando ele e baseado no salario minimo entao o valor do reajuste anual e sempre igual ao salario minimo
						if(!informacoes.isSalarioMinimo()) {
							rmi = rmi * reajusteAcumulado;
						}
						reajuste = reajusteAcumulado;
					}
					// verifica se no calculo tem o juros
					if (informacoes.isJuros()) {
						jurosAcumulado = calculoJuros(mesCalculo, anoCalculo, listJuros, mesAtualizacao, anoAtualizacao,
								mesIncioJuros, anoIncioJuros, dateFormat);
					}
					correcaoAcumulada = calculoCorrecao(mesCalculo, anoCalculo, listCorrecao, mesAtualizacao,
							anoAtualizacao, dateFormat);
					
					if(informacoes.isSalarioMinimo() || rmi < salarioMinimo(mesCalculo, anoCalculo, dateFormat, listaSalarioMinimo)) {
						rmi = salarioMinimo(mesCalculo, anoCalculo, dateFormat, listaSalarioMinimo);
					}
					
					// estancia o objeto e adiciona na lista
					Calculo calculoAdd = new Calculo(dataCalculo, reajuste, rmi, correcaoAcumulada, jurosAcumulado);
					reajuste = 1;
					listCalculo.add(calculoAdd);
					// para o calculo
					if (mesDip == mesCalculo && anoCalculo == anoDip) {
						return listCalculo;
					}
					// verifica a data para fazer o colocar o reajuste
					if (mesCalculo == 1 || confirmadoData == 0) {
						reajusteAcumulado = calculoReajuste(mesCalculo, anoCalculo, listReajuste, dateFormat);
					}
					// faz a progressao da data
					mesCalculo++;
					if (mesCalculo == 13) {
						mesCalculo = 01;
						anoCalculo++;
					}
					confirmadoData++;
				}
			}
			return listCalculo;
		} catch (Exception e) {
			return e;
		}
	}

	@PostMapping("/alcada")
	public @ResponseBody Object alcada(@RequestBody InfoCalculo informacoes) {
		try {
			String[] arrayDib = informacoes.getDib().split("/");
			int mesDib = Integer.parseInt(arrayDib[1]);
			int anoDib = Integer.parseInt(arrayDib[2]);
			String[] arrayDip = informacoes.getDip().split("/");
			int mesDip = Integer.parseInt(arrayDip[1]);
			int anoDip = Integer.parseInt(arrayDip[2]);
			String[] arrayAtualizacao = informacoes.getAtulizacao().split("/");
			int mesAtualizacao = Integer.parseInt(arrayAtualizacao[0]);
			int anoAtualizacao = Integer.parseInt(arrayAtualizacao[1]);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			List<TaxaDeCorrecao> listCorrecao = correcaoRepository
					.findByTipoOrderByDataAsc(informacoes.getTipoCorrecao());
			int mesCalculo = mesDib;
			int anoCalculo = anoDib;

			List<Calculo> listCalculo = new ArrayList<Calculo>();

			float correcaoAcumulada = 1;

			if (anoCalculo <= anoDip) {
				while (anoCalculo != anoDip + 1) {

					SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					String dataCalculo = out.format(in.parse(anoCalculo + "-" + mesCalculo + "-01"));

					correcaoAcumulada = calculoCorrecao(mesCalculo, anoCalculo, listCorrecao, mesAtualizacao,
							anoAtualizacao, dateFormat);

					// estancia o objeto e adiciona na lista
					Calculo calculoAdd = new Calculo(dataCalculo, 0, 0, correcaoAcumulada, 0);
					listCalculo.add(calculoAdd);
					// para o calculo
					if (mesDip == mesCalculo && anoCalculo == anoDip) {
						return listCalculo;
					}
					// faz a progressao da data
					mesCalculo++;
					if (mesCalculo == 13) {
						mesCalculo = 01;
						anoCalculo++;
					}

				}
			}
			return listCalculo;
		} catch (Exception e) {
			return e;
		}
	}

	@PostMapping("/beneficioAcumulado")
	public @ResponseBody Object beneficioAcumulado(@RequestBody InfoCalculo informacoes) {
		try {
			String[] arrayDib = informacoes.getDib().split("/");
			int mesDib = Integer.parseInt(arrayDib[1]);
			int anoDib = Integer.parseInt(arrayDib[2]);
			String[] arrayDip = informacoes.getDip().split("/");
			int mesDip = Integer.parseInt(arrayDip[1]);
			int anoDip = Integer.parseInt(arrayDip[2]);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			float reajusteAcumulado = 1;

			int mesCalculo = mesDib;
			int anoCalculo = anoDib;
			float rmi = informacoes.getRmi();
			float reajuste = 1;
			int confirmadoData = 0;

			List<TaxaReajuste> listReajuste = reajusteRepositorio.findAll();

			List<Calculo> listCalculo = new ArrayList<Calculo>();
			
			List<SalarioMinimo> listaSalarioMinimo = new ArrayList<SalarioMinimo>();
			if(informacoes.isSalarioMinimo() || informacoes.isLimiteMinimoMaximo()) {
				listaSalarioMinimo = salarioMinimoRepository.findAll();
			}
			

			if (anoCalculo <= anoDip) {
				while (anoCalculo != anoDip + 1) {

					SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					String dataCalculo = out.format(in.parse(anoCalculo + "-" + mesCalculo + "-01"));

					// coloca o reajuste
					if (mesCalculo == 1) {
						if(!informacoes.isSalarioMinimo()) {
							rmi = rmi * reajusteAcumulado;
						}
						reajuste = reajusteAcumulado;
					}
					if(informacoes.isSalarioMinimo() || rmi < salarioMinimo(mesCalculo, anoCalculo, dateFormat, listaSalarioMinimo)) {
						rmi = salarioMinimo(mesCalculo, anoCalculo, dateFormat, listaSalarioMinimo);
					}

					// estancia o objeto e adiciona na lista
					Calculo calculoAdd = new Calculo(dataCalculo, reajuste, rmi, 0, 0);
					reajuste = 1;
					listCalculo.add(calculoAdd);
					// para o calculo
					if (mesDip == mesCalculo && anoCalculo == anoDip) {
						return listCalculo;
					}
					// verifica a data para fazer o colocar o reajuste
					if (mesCalculo == 1 || confirmadoData == 0) {
						reajusteAcumulado = calculoReajuste(mesCalculo, anoCalculo, listReajuste, dateFormat);
					}
					// faz a progressao da data
					mesCalculo++;
					if (mesCalculo == 13) {
						mesCalculo = 01;
						anoCalculo++;
					}
					confirmadoData++;
				}
			}

			return listCalculo;

		} catch (Exception e) {
			return e;
		}
	}

	public boolean verificarPeriodo(int mesFornecido, int anoFornecido, int mesInformado, int anoInformado) {
		if (anoFornecido <= anoInformado) {
			if (anoFornecido == anoInformado) {
				if (mesFornecido < mesInformado) {

					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public float salarioMinimo(int mesCalculo, int anoCalculo, DateFormat dateFormat, List<SalarioMinimo> listaSalarioMinimo) {
		float salariominimo = 0;
		for(int i = 0; i < listaSalarioMinimo.size(); i++) {
			String strDate = dateFormat.format(listaSalarioMinimo.get(i).getData());
			int ano = Integer.parseInt(strDate.split(" ")[0].split("-")[0]);
			int mes = Integer.parseInt(strDate.split(" ")[0].split("-")[1]);
			if(ano == anoCalculo) {
				if(mes <= mesCalculo) {
					salariominimo = listaSalarioMinimo.get(i).getValor();
				}
			}else if(ano >= anoCalculo){
				return salariominimo;
			}
		}
		return salariominimo;
	}

	public float calculoJuros(int mesCalculo, int anoCalculo, List<Juros> listJuros, int mesAtualizacao,
			int anoAtualizacao, int mesIncioJuros, int anoIncioJuros, DateFormat dateFormat) {
		float jurosAcumulado = 0;

		try {
			for (int indexJuros = listJuros.size() - 1; indexJuros >= 0; indexJuros--) {
				String[] dataJuros = dateFormat.format(listJuros.get(indexJuros).getData()).split(" ")[0].split("-");
				int mesJuros = Integer.parseInt(dataJuros[1]);
				int anoJuros = Integer.parseInt(dataJuros[0]);
				if (verificarPeriodo(mesIncioJuros, anoIncioJuros, mesJuros, anoJuros)
						&& verificarPeriodo(mesJuros, anoJuros, mesAtualizacao, anoAtualizacao)) {
					jurosAcumulado += listJuros.get(indexJuros).getJuros();

				}
				if (mesJuros == mesCalculo && anoCalculo == anoJuros) {
					return jurosAcumulado;
				}
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return jurosAcumulado;
		}
	}

	public float calculoCorrecao(int mesCalculo, int anoCalculo, List<TaxaDeCorrecao> listCorrecao, int mesAtualizacao,
			int anoAtualizacao, DateFormat dateFormat) {
		float correcaoAcumulada = 1;
		try {
			for (int indexCorrecao = listCorrecao.size() - 1; indexCorrecao >= 0; indexCorrecao--) {

				String[] data = dateFormat.format(listCorrecao.get(indexCorrecao).getData()).split(" ")[0].split("-");
				int mesCorrecao = Integer.parseInt(data[1]);
				int anoCorrecao = Integer.parseInt(data[0]);
				if (verificarPeriodo(mesCorrecao, anoCorrecao, mesAtualizacao, anoAtualizacao)) {
					correcaoAcumulada *= listCorrecao.get(indexCorrecao).getTaxaCorrecao();
				}
				if (mesCorrecao == mesCalculo && anoCalculo == anoCorrecao) {
					return correcaoAcumulada;
				}
			} // termino do laco for da correcao;
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return correcaoAcumulada;
		}

	}

	public float calculoReajuste(int mesCalculo, int anoCalculo, List<TaxaReajuste> listReajuste,
			DateFormat dateFormat) {
		float reajusteAcumulado = 1;
		try {
			for (int i = listReajuste.size() - 1; i >= 0; i--) {
				String[] dataReajuste = dateFormat.format(listReajuste.get(i).getData()).split(" ")[0].split("-");
				int mesReajuste = Integer.parseInt(dataReajuste[1]);
				int anoReajuste = Integer.parseInt(dataReajuste[0]);

				if (mesReajuste == mesCalculo && anoCalculo == anoReajuste) {
					reajusteAcumulado = (float) listReajuste.get(i).getReajusteAcumulado();
					return (float) (listReajuste.get(i).getReajusteAcumulado() / 100) + 1;
				}

			} // termino do laco for do reajuste;
			return 1;

		} catch (Exception e) {
			System.out.println(e);
			return reajusteAcumulado;
		}
	}
}
