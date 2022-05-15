package com.calculadora.SAMIR.Modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficios")
public class Beneficios {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String name;
	private boolean salario13;
	private String[] inacumulavel;
	private boolean dif;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSalario13() {
		return salario13;
	}

	public void setSalario13(boolean salario13) {
		this.salario13 = salario13;
	}

	public String[] getInacumulavel() {
		return inacumulavel;
	}

	public void setInacumulavel(String[] inacumulavel) {
		this.inacumulavel = inacumulavel;
	}

	public boolean isDif() {
		return dif;
	}

	public void setDif(boolean dif) {
		this.dif = dif;
	}

}
