/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenvolvimento;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

/**
 *
 * @author rafaelcergoli
 */

@ManagedBean

public class Calculos {
    double  salariobruto, dependentes, vldependentes, inss, faixaInss,
            basecalculo, faixaIR, valorIR, salarioliquido, totaldescontos;
    

    
    public void calcular(){
        salariobruto = 2550;
       
        calculaInss();
        calculaIR();
        calculaSalarioLiquido();
    }
    
    public void calculaInss(){
        double deducao;
        if(salariobruto <= 1100){
            faixaInss = 0.075;
            deducao = 0;
            inss = (salariobruto * faixaInss) - deducao;
        }
        else if(salariobruto <= 2203.48){
            faixaInss = 0.09;
            deducao = 16.5;
            inss = (salariobruto * faixaInss) - deducao;
        }
        else if(salariobruto <= 3305.22){
            faixaInss = 0.12;
            deducao = 82.6;
            inss = (salariobruto * faixaInss) - deducao;
        }
        else if(salariobruto <= 6433.57){
            faixaInss = 0.14;
            deducao = 148.71;
            inss = (salariobruto * faixaInss) - deducao;
        }
        else {
            faixaInss = 0.14;
            deducao = 148.71;
            inss = (6433.57 * faixaInss) - deducao;
        }
    }
    
    public void calculaIR(){
        double deducao;
        vldependentes = dependentes * 189.59;
        basecalculo = salariobruto - inss - vldependentes;
        
        if(basecalculo <= 1903.98){
            faixaIR = 0;
            deducao = 0;
            valorIR = (basecalculo * faixaIR) - deducao;
        }
        else if(basecalculo <= 2826.65){
            faixaIR = 0.075;
            deducao = 142.80;
            valorIR = (basecalculo * faixaIR) - deducao;
        }
        else if(basecalculo <= 3751.05){
            faixaIR = 0.15;
            deducao = 354.80;
            valorIR = (basecalculo * faixaIR) - deducao;
        }
        else if(basecalculo <= 4664.68){
            faixaIR = 0.225;
            deducao = 636.13;
            valorIR = (basecalculo * faixaIR) - deducao;
        }
        else {
            faixaIR = 0.275;
            deducao = 869.36;
            valorIR = (basecalculo * faixaIR) - deducao;
        }
    }
    
    public void calculaSalarioLiquido(){
        totaldescontos = inss + valorIR;
        salarioliquido = salariobruto - totaldescontos;
    }
    
    public void limpar(){
        salariobase = adicionais = horasextras = outros = salariobruto = dependentes = vldependentes =
                inss = faixaInss = basecalculo = faixaIR = valorIR = salarioliquido = totaldescontos = 0;
        createPieModel();
    }

    public double getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(double salariobase) {
        this.salariobase = salariobase;
    }

    public double getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(double adicionais) {
        this.adicionais = adicionais;
    }

    public double getHorasextras() {
        return horasextras;
    }

    public void setHorasextras(double horasextras) {
        this.horasextras = horasextras;
    }

    public double getOutros() {
        return outros;
    }

    public void setOutros(double outros) {
        this.outros = outros;
    }

    public double getSalariobruto() {
        return salariobruto;
    }

    public void setSalariobruto(double salariobruto) {
        this.salariobruto = salariobruto;
    }

    public double getDependentes() {
        return dependentes;
    }

    public void setDependentes(double dependentes) {
        this.dependentes = dependentes;
    }

    public double getVldependentes() {
        return vldependentes;
    }

    public void setVldependentes(double vldependentes) {
        this.vldependentes = vldependentes;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getFaixaInss() {
        return faixaInss;
    }

    public void setFaixaInss(double faixaInss) {
        this.faixaInss = faixaInss;
    }

    public double getBasecalculo() {
        return basecalculo;
    }

    public void setBasecalculo(double basecalculo) {
        this.basecalculo = basecalculo;
    }

    public double getFaixaIR() {
        return faixaIR;
    }

    public void setFaixaIR(double faixaIR) {
        this.faixaIR = faixaIR;
    }

    public double getValorIR() {
        return valorIR;
    }

    public void setValorIR(double valorIR) {
        this.valorIR = valorIR;
    }

    public double getSalarioliquido() {
        return salarioliquido;
    }

    public void setSalarioliquido(double salarioliquido) {
        this.salarioliquido = salarioliquido;
    }

    public double getTotaldescontos() {
        return totaldescontos;
    }

    public void setTotaldescontos(double totaldescontos) {
        this.totaldescontos = totaldescontos;
    }
    
    
    
}
