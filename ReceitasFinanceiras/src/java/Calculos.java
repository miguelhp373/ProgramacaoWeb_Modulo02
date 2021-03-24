
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean

public class Calculos {
    private PieChartModel pieModel;
    double salario, aplicacoes, rendavariavel, outras;
    
    private void createPieModel(){
        pieModel = new PieChartModel();
        pieModel.set("Salário",salario);
        pieModel.set("Aplicações",aplicacoes);
        pieModel.set("Renda",rendavariavel);
        pieModel.set("Outras",outras);
        
        //configurações
        pieModel.setTitle("Receitas");
    }
    
    @PostConstruct
    
    
   public void createPieModels(){
        createPieModel();
    } 
        
    public void init(){
        createPieModels();
}
    public PieChartModel getPieModels(){
        return pieModel;
    }
    
    public void calcular(){
        createPieModel();
    }
    
    public void limpar(){
        salario = 0;
        aplicacoes = 0;
        rendavariavel = 0; 
        outras = 0;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(double aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public double getRendavariavel() {
        return rendavariavel;
    }

    public void setRendavariavel(double rendavariavel) {
        this.rendavariavel = rendavariavel;
    }

    public double getOutras() {
        return outras;
    }

    public void setOutras(double outras) {
        this.outras = outras;
    }
    
    
}


