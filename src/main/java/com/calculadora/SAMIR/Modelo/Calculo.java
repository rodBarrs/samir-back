package com.calculadora.SAMIR.Modelo;

public class Calculo {

	private String data;
	private float reajusteAcumulado;
	private float salario;	
	private float correcao;
	private float salarioCorrigido;
	private float juros;
	private float salarioJuros;
	private float salarioTotal;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getReajusteAcumulado() {
		return reajusteAcumulado;
	}
	public void setReajusteAcumulado(float reajusteAcumulado) {
		this.reajusteAcumulado = reajusteAcumulado;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getCorrecao() {
		return correcao;
	}
	public void setCorrecao(float correcao) {
		this.correcao = correcao;
	}
	public float getSalarioCorrigido() {
		return salarioCorrigido;
	}
	public void setSalarioCorrigido(float salarioCorrigido) {
		this.salarioCorrigido = salarioCorrigido;
	}
	public float getJuros() {
		return juros;
	}
	public void setJuros(float juros) {
		this.juros = juros;
	}
	public float getSalarioJuros() {
		return salarioJuros;
	}
	public void setSalarioJuros(float salarioJuros) {
		this.salarioJuros = salarioJuros;
	}
	public float getSalarioTotal() {
		return salarioTotal;
	}
	public void setSalarioTotal(float salarioTotal) {
		this.salarioTotal = salarioTotal;
	}
	public Calculo(String data, float reajusteAcumulado, float salario, float correcao, float juros) {
		super();
		this.data = data;
		this.reajusteAcumulado = reajusteAcumulado;
		this.salario = salario;
		this.correcao = correcao;
		this.salarioCorrigido = salario * correcao;
		this.juros = juros / 100;
		this.salarioJuros = salario * correcao * juros / 100;
		this.salarioTotal = (salario * correcao * juros / 100) + (salario * correcao);
	}
	
}
