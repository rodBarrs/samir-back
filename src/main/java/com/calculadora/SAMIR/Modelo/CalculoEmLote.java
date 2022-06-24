package com.calculadora.SAMIR.Modelo;

import javax.persistence.*;
@Entity
@Table(name = "calculoEmLote")
public class CalculoEmLote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String numeroDoProcesso;
    private String nome;
    private String dataDeAjuizamento;
    private String cpf;
    private String termoInicial;
    private String termoFinal;
    private float rmi;
    private String beneficio;
    private String numeroDoBeneficio;
    private String dataDePagamento;
    private String citacao;
    private String aps;
    private boolean recebeuBeneficio;
    private String[] nomeBeneficioBeneficioAcumulado;
    private String[] dataDeInicioBeneficioAcumulado;
    private String[] dataFinalBeneficioAcumulado;
    private String[] rmilBeneficioAcumulado;
    private String inicioJuros;


    //    @JoinColumn(name = "beneficio_acumulados")
//    private BeneficioAcumulado[] beneficioAcumulados;
    private String honorarioAdvocativosData;
    private float  honorariosAdvocativos;
    private float acordo;
    private int tipoJuros;
    private int tipoCorrecao;
    private boolean possuiDecimoTerceiro;
    private boolean possuiJuros;
    private boolean alcada;
    private boolean salarioMinimo;
    private boolean limiteMinimoMaximo;
    private int usuario;
    private String atualizacao;
    private String dibAnterior;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String[] getNomeBeneficioBeneficioAcumulado() {
        return nomeBeneficioBeneficioAcumulado;
    }

    public void setNomeBeneficioBeneficioAcumulado(String[] nomeBeneficioBeneficioAcumulado) {
        this.nomeBeneficioBeneficioAcumulado = nomeBeneficioBeneficioAcumulado;
    }

    public String[] getDataDeInicioBeneficioAcumulado() {
        return dataDeInicioBeneficioAcumulado;
    }

    public void setDataDeInicioBeneficioAcumulado(String[] dataDeInicioBeneficioAcumulado) {
        this.dataDeInicioBeneficioAcumulado = dataDeInicioBeneficioAcumulado;
    }

    public String[] getDataFinalBeneficioAcumulado() {
        return dataFinalBeneficioAcumulado;
    }

    public void setDataFinalBeneficioAcumulado(String[] dataFinalBeneficioAcumulado) {
        this.dataFinalBeneficioAcumulado = dataFinalBeneficioAcumulado;
    }

    public String[] getRmilBeneficioAcumulado() {
        return rmilBeneficioAcumulado;
    }

    public void setRmilBeneficioAcumulado(String[] rmilBeneficioAcumulado) {
        this.rmilBeneficioAcumulado = rmilBeneficioAcumulado;
    }

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

    public float getRmi() {
        return rmi;
    }

    public void setRmi(float rmi) {
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

    public boolean isRecebeuBeneficio() {
        return recebeuBeneficio;
    }

    public void setRecebeuBeneficio(boolean recebeuBeneficio) {
        this.recebeuBeneficio = recebeuBeneficio;
    }



    public String getHonorarioAdvocativosData() {
        return honorarioAdvocativosData;
    }

    public void setHonorarioAdvocativosData(String honorarioAdvocativosData) {
        this.honorarioAdvocativosData = honorarioAdvocativosData;
    }

    public float getHonorariosAdvocativos() {
        return honorariosAdvocativos;
    }

    public void setHonorariosAdvocativos(float honorariosAdvocativos) {
        this.honorariosAdvocativos = honorariosAdvocativos;
    }

    public float getAcordo() {
        return acordo;
    }

    public void setAcordo(float acordo) {
        this.acordo = acordo;
    }

    public boolean isPossuiDecimoTerceiro() {
        return possuiDecimoTerceiro;
    }

    public void setPossuiDecimoTerceiro(boolean possuiDecimoTerceiro) {
        this.possuiDecimoTerceiro = possuiDecimoTerceiro;
    }

    public boolean isPossuiJuros() {
        return possuiJuros;
    }

    public void setPossuiJuros(boolean possuiJuros) {
        this.possuiJuros = possuiJuros;
    }

    public boolean isAlcada() {
        return alcada;
    }

    public void setAlcada(boolean alcada) {
        this.alcada = alcada;
    }

    public int getTipoJuros() {
        return tipoJuros;
    }

    public void setTipoJuros(int tipoJuros) {
        this.tipoJuros = tipoJuros;
    }

    public int getTipoCorrecao() {
        return tipoCorrecao;
    }

    public void setTipoCorrecao(int tipoCorrecao) {
        this.tipoCorrecao = tipoCorrecao;
    }

    public String getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }

    public String getDibAnterior() {
        return dibAnterior;
    }

    public void setDibAnterior(String dibAnterior) {
        this.dibAnterior = dibAnterior;
    }

    public boolean isSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(boolean salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public boolean isLimiteMinimoMaximo() {
        return limiteMinimoMaximo;
    }

    public void setLimiteMinimoMaximo(boolean limiteMinimoMaximo) {
        this.limiteMinimoMaximo = limiteMinimoMaximo;
    }

    public String getInicioJuros() {
        return inicioJuros;
    }

    public void setInicioJuros(String inicioJuros) {
        this.inicioJuros = inicioJuros;
    }



}
