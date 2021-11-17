package com.calculadora.SAMIR.Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxaDeCorrecao")
public class TaxaDeCorrecao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private Date data;
	private double fator;
	private double taxaAcumulada;
	private double percentual;
	private String tipo_De_Taxa;
	private int referencia;
	private int tipo;
	private String descricao;

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
		return fator;
	}

	public void setTaxaCorrecao(double taxaCorrecao) {
		this.fator = taxaCorrecao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_De_Taxa() {
		return tipo_De_Taxa;
	}

	public void setTipo_De_Taxa(String tipo_De_Taxa) {
		this.tipo_De_Taxa = tipo_De_Taxa;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

}
