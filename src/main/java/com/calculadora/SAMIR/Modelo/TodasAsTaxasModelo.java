package com.calculadora.SAMIR.Modelo;

import java.util.Date;

public class TodasAsTaxasModelo {
	private Date data;
	private double reajuste;
	private double jurosAcumulado;
	private double correcaoAcumulado;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getReajuste() {
		return reajuste;
	}
	public void setReajuste(double reajuste) {
		this.reajuste = reajuste;
	}
	public double getJurosAcumulado() {
		return jurosAcumulado;
	}
	public void setJurosAcumulado(double jurosAcumulado) {
		this.jurosAcumulado = jurosAcumulado;
	}
	public double getCorrecaoAcumulado() {
		return correcaoAcumulado;
	}
	public void setCorrecaoAcumulado(double correcaoAcumulado) {
		this.correcaoAcumulado = correcaoAcumulado;
	}
	


	
}