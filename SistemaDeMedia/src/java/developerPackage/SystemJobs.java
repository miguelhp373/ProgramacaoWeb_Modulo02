package developerPackage;


import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
@ManagedBean

public class SystemJobs {
     private float n1,n2,n3,media;
     public String msg,situation;
    
    public void calcular(){
        
         media = (n1+n2+n3) / 3;

        if(media>=5){
            situation = "Aprovado";
        }else
         if((media<5) && (media>2)){
             situation = "Recuperação";
         }else
         if(media<2){
             situation = "Reprovado";
         }
        
        msg = "Média Final: " + new DecimalFormat("#,##0.00").format(media) + " | Situação Final: Aluno "+situation;
    }
    
    public void limpar(){
        media = 0;
        n1 = 0;
        n2 = 0;
        n3 = 0;
        msg = "";
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN3(float n3) {
        this.n3 = n3;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
    
    
    
}
