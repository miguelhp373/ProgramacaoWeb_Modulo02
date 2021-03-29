package desenvolvimento;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.charts.pie.PieChartModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;

@ManagedBean

public class Generator {

    double Renda, Alimentacao, Transporte, Saude, Moradia, Compras, Reserva, Outros, Despesas, Balanco;
    double  A, T, S, M, C, R, O;

    private PieChartModel PieModel;

    @PostConstruct

    public void init() {
        CreatePieModel();
    }

    private void CreatePieModel() {
        PieModel = new PieChartModel();
        ChartData dados = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> valores = new ArrayList<>();

        valores.add(Alimentacao);
        valores.add(Transporte);
        valores.add(Saude);
        valores.add(Moradia);
        valores.add(Compras);
        valores.add(Reserva);
        valores.add(Outros);

        dataSet.setData(valores);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(0, 32, 96)");
        bgColors.add("rgb(46, 117, 182)");
        bgColors.add("rgb(46, 204, 113)");
        bgColors.add("rgb(221, 89, 35)");
        bgColors.add("rgb(241, 196, 15)");
        bgColors.add("rgb(142, 68, 173)");
        bgColors.add("rgb(52, 73, 94)");
        dataSet.setBackgroundColor(bgColors);

        dados.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Allimentação");
        labels.add("Transporte");
        labels.add("Saúde");
        labels.add("Moradia");
        labels.add("Compras");
        labels.add("Reserva");
        labels.add("Outros");

        dados.setLabels(labels);

        PieModel.setData(dados);
    }

    public PieChartModel getPieModel() {
        return PieModel;
    }

    public void calcular() {
        Despesas = Alimentacao + Transporte + Saude + Moradia + Compras + Reserva + Outros;
        Balanco = Renda - Despesas;
        
         A = (Alimentacao / Despesas) * 100;
         T = (Transporte / Despesas) * 100;
         S = (Saude / Despesas ) * 100;
         M = (Moradia / Despesas )* 100;
         C = (Compras / Despesas) * 100;
         R = (Reserva / Despesas) * 100;
         O = (Outros / Despesas) * 100;
        
        CreatePieModel();
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getT() {
        return T;
    }

    public void setT(double T) {
        this.T = T;
    }

    public double getS() {
        return S;
    }

    public void setS(double S) {
        this.S = S;
    }

    public double getM() {
        return M;
    }

    public void setM(double M) {
        this.M = M;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }

    public double getR() {
        return R;
    }

    public void setR(double R) {
        this.R = R;
    }

    public double getO() {
        return O;
    }

    public void setO(double O) {
        this.O = O;
    }

    public double getBalanco() {
        return Balanco;
    }

    public void setBalanco(double Balanco) {
        this.Balanco = Balanco;
    }

    public void limpar() {
        Renda = Alimentacao = Transporte = Saude = Moradia = Compras = Reserva = Outros = 0;
        CreatePieModel();
    }

    public double getTransporte() {
        return Transporte;
    }

    public void setTransporte(double Transporte) {
        this.Transporte = Transporte;
    }

    public double getRenda() {
        return Renda;
    }

    public void setRenda(double Renda) {
        this.Renda = Renda;
    }

    public double getAlimentacao() {
        return Alimentacao;
    }

    public void setAlimentacao(double Alimentacao) {
        this.Alimentacao = Alimentacao;
    }

    public double getSaude() {
        return Saude;
    }

    public void setSaude(double Saude) {
        this.Saude = Saude;
    }

    public double getMoradia() {
        return Moradia;
    }

    public void setMoradia(double Moradia) {
        this.Moradia = Moradia;
    }

    public double getCompras() {
        return Compras;
    }

    public void setCompras(double Compras) {
        this.Compras = Compras;
    }

    public double getReserva() {
        return Reserva;
    }

    public void setReserva(double Reserva) {
        this.Reserva = Reserva;
    }

    public double getOutros() {
        return Outros;
    }

    public void setOutros(double Outros) {
        this.Outros = Outros;
    }

    public double getDespesas() {
        return Despesas;
    }

    public void setDespesas(double Despesas) {
        this.Despesas = Despesas;
    }

}
