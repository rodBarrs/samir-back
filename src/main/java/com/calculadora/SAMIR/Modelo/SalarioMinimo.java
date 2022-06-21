package com.calculadora.SAMIR.Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salarioMinimo")
public class SalarioMinimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float valor;
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	private Date data;
	
}
