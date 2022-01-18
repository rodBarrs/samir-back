package com.calculadora.SAMIR.Modelo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class InfomacoesDosPrev {
	private String numeroDoProcesso;
	private String nome;
	private String dataAjuizamento;
	private String cpf;
	private String dibInicial;
	private String dibFinal;
	private String rmi;
	private String beneficio;
	private String nb;
	private String aps;
	private String dip;
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public String getNb() {
		return nb;
	}
	public void setNb(String nb) {
		this.nb = nb;
	}
	public String getAps() {
		return aps;
	}
	public void setAps(String aps) {
		this.aps = aps;
	}
	public String getDip() {
		return dip;
	}
	public void setDip(String dip) {
		this.dip = dip;
	}
	public String getNumeroDoProcesso() {
		return numeroDoProcesso;
	}
	public void setNumeroDoProcesso(String numeroDoProcesso) {
		this.numeroDoProcesso = numeroDoProcesso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataAjuizamento() {
		return dataAjuizamento;
	}
	public void setDataAjuizamento(String dataAjuizamento) {
		this.dataAjuizamento = dataAjuizamento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDibInicial() {
		return dibInicial;
	}
	public void setDibInicial(String dibInicial) {
		this.dibInicial = dibInicial;
	}
	public String getDibFinal() {
		return dibFinal;
	}
	public void setDibFinal(String dibFinal) {
		this.dibFinal = dibFinal;
	}
	public String getRmi() {
		return rmi;
	}
	public void setRmi(String rmi) {
		this.rmi = rmi;
	}
	public void setInformacoes(InfomacoesDosPrev inf) {
		cpf = inf.getCpf();
		rmi = inf.getRmi();
		dibInicial = inf.dibInicial;
		dibInicial = inf.getDibFinal();
		nome =inf.getNome();
		numeroDoProcesso = inf.getNumeroDoProcesso();
		dataAjuizamento = inf.getDataAjuizamento();
	}
	

}
