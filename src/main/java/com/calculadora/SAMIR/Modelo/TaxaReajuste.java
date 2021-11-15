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
	private double taxaReajuste;
	private double taxaAcumulado;
	private int tipo;

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

	public double getTaxaReajuste() {
		return taxaReajuste;
	}

	public void setTaxaReajuste(double taxaReajuste) {
		this.taxaReajuste = taxaReajuste;
	}

	public double getTaxaAcumulado() {
		return taxaAcumulado;
	}

	public void setTaxaAcumulado(double taxaAcumulado) {
		this.taxaAcumulado = taxaAcumulado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
