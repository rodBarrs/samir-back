package com.calculadora.SAMIR.Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "taxaDeCorrecao")
public class TaxaDeCorrecao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private Date data;
	private double taxaCorrecao;
	private double taxaAcumulada;
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

	public double getTaxaCorrecao() {
		return taxaCorrecao;
	}

	public void setTaxaCorrecao(double taxaCorrecao) {
		this.taxaCorrecao = taxaCorrecao;
	}

	public double getTaxaAcumulada() {
		return taxaAcumulada;
	}

	public void setTaxaAcumulada(double taxaAcumulada) {
		this.taxaAcumulada = taxaAcumulada;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
