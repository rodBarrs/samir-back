package com.calculadora.SAMIR.Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TaxaReajuste")
public class TaxaReajuste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private Date data;
	private double reajuste;
	private double aumentoReal;
	private double reajusteAcumulado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public double getAumentoReal() {
		return aumentoReal;
	}

	public void setAumentoReal(double aumentoReal) {
		this.aumentoReal = aumentoReal;
	}

	public double getReajusteAcumulado() {
		return reajusteAcumulado;
	}

	public void setReajusteAcumulado(double reajusteAcumulado) {
		this.reajusteAcumulado = reajusteAcumulado;
	}

}
