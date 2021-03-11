package developer;

import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
@ManagedBean

public class Calculo {
    private float km;
    private float liters;
    private float total;
    private String msg;

    public void calcular(){
    //consumo >= 10 km/l : consumo ideal
    //consumo <10 km/l: consumo alto
      total = km / liters;
      
      if(total>=10){
          msg = "Você gastou " + new DecimalFormat("#,##0.00").format(total)  + "km/L, e está no Consumo Ideal";
      }else{
          msg = "Você gastou " + new DecimalFormat("#,##0.00").format(total) + "km/L,  e está no Consumo Alto";
       }
    
    }
    
    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
}
