package com.calculadora.SAMIR.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "calculoEmLote")
public class CalculoEmLote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeroDoProcesso;
    private String nome;
    private String dataDeAjuizamento;
    private String cpf;
    private String termoInicial;
    private String termoFinal;
    private String rmi;
    private String beneficio;
    private String numeroDoBeneficio;
    private String dataDePagamento;
    private String citacao;
    private String aps;
    private BeneficioAcumulado[] beneficioAcumulados;
    private String honorarioAdvocativosData;
    private String  honorariosAdvocativos;
    private UsuarioModelo usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDataDeAjuizamento() {
        return dataDeAjuizamento;
    }

    public void setDataDeAjuizamento(String dataDeAjuizamento) {
        this.dataDeAjuizamento = dataDeAjuizamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTermoInicial() {
        return termoInicial;
    }

    public void setTermoInicial(String termoInicial) {
        this.termoInicial = termoInicial;
    }

    public String getTermoFinal() {
        return termoFinal;
    }

    public void setTermoFinal(String termoFinal) {
        this.termoFinal = termoFinal;
    }

    public String getRmi() {
        return rmi;
    }

    public void setRmi(String rmi) {
        this.rmi = rmi;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public String getNumeroDoBeneficio() {
        return numeroDoBeneficio;
    }

    public void setNumeroDoBeneficio(String numeroDoBeneficio) {
        this.numeroDoBeneficio = numeroDoBeneficio;
    }

    public String getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(String dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public String getCitacao() {
        return citacao;
    }

    public void setCitacao(String citacao) {
        this.citacao = citacao;
    }

    public String getAps() {
        return aps;
    }

    public void setAps(String aps) {
        this.aps = aps;
    }

    public BeneficioAcumulado[] getBeneficioAcumulados() {
        return beneficioAcumulados;
    }

    public void setBeneficioAcumulados(BeneficioAcumulado[] beneficioAcumulados) {
        this.beneficioAcumulados = beneficioAcumulados;
    }

    public String getHonorarioAdvocativosData() {
        return honorarioAdvocativosData;
    }

    public void setHonorarioAdvocativosData(String honorarioAdvocativosData) {
        this.honorarioAdvocativosData = honorarioAdvocativosData;
    }

    public String getHonorariosAdvocativos() {
        return honorariosAdvocativos;
    }

    public void setHonorariosAdvocativos(String honorariosAdvocativos) {
        this.honorariosAdvocativos = honorariosAdvocativos;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }
}
