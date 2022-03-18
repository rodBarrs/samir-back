package com.calculadora.SAMIR.Modelo;

import java.util.Date;

public class TodasAsTaxasModelo {
	private Date data;
	private double reajuste;
	private double jurosAcumulado;
	private double correcaoAcumulado;
	private Date dataCor;
	private Date dataRe;
	
	public Date getDataCor() {
		return dataCor;
	}
	public void setDataCor(Date dataCor) {
		this.dataCor = dataCor;
	}
	public Date getDataRe() {
		return dataRe;
	}
	public void setDataRe(Date dataRe) {
		this.dataRe = dataRe;
	}
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
	public void  limpar(){
		 this.data = new Date();
		 this.reajuste = 0;
		 this.jurosAcumulado = 0;
		 this.correcaoAcumulado = 0;
		 this.dataCor = new Date();
		 this.dataRe = new Date();
	}

	


	
}