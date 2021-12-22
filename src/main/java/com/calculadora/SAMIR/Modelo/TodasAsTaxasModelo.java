package com.calculadora.SAMIR.Modelo;

public class TodasAsTaxasModelo {
	private TaxaDeCorrecao correcao = new TaxaDeCorrecao();
	private TaxaReajuste reajuste = new TaxaReajuste();
	private Juros juros = new Juros();
	
	public void setTodasAsTaxasModelo(TaxaDeCorrecao correcao, TaxaReajuste reajuste, Juros juros) {
		this.correcao = correcao;
		this.reajuste = reajuste;
		this.juros = juros;
	}
	public TaxaDeCorrecao getCorrecao() {
		return correcao;
	}
	public void setCorrecao(TaxaDeCorrecao correcao) {
		this.correcao = correcao;
	}
	public TaxaReajuste getReajuste() {
		return reajuste;
	}
	public void setReajuste(TaxaReajuste reajuste) {
		this.reajuste = reajuste;
	}
	public Juros getJuros() {
		return juros;
	}
	public void setJuros(Juros juros) {
		this.juros = juros;
	}
	
}
