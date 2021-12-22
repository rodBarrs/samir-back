package com.calculadora.SAMIR.Modelo;

import java.util.List;

public class TodasAsTaxasModelo {
	private List<TaxaDeCorrecao> correcaoT;
	private List<TaxaReajuste> reajusteT;
	private List<Juros> jurosT;
	
	

	public TodasAsTaxasModelo(List<TaxaDeCorrecao> correcaoT, List<TaxaReajuste> reajusteT, List<Juros> jurosT) {
		super();
		this.correcaoT = correcaoT;
		this.reajusteT = reajusteT;
		this.jurosT = jurosT;
	}

	public List<TaxaDeCorrecao> getCorrecaoT() {
		return correcaoT;
	}

	public void setCorrecaoT(List<TaxaDeCorrecao> correcaoT) {
		this.correcaoT = correcaoT;
	}

	public List<TaxaReajuste> getReajusteT() {
		return reajusteT;
	}

	public void setReajusteT(List<TaxaReajuste> reajusteT) {
		this.reajusteT = reajusteT;
	}

	public List<Juros> getJurosT() {
		return jurosT;
	}

	public void setJurosT(List<Juros> jurosT) {
		this.jurosT = jurosT;
	}


	
}