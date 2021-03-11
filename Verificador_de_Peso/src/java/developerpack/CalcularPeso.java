/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developerpack;

import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;

@ManagedBean
/**
 *
 * @author migue
 */
public class CalcularPeso {
    private float weight, height;
    private String sexo, msg;
    
    public void calcular(){
        if(sexo.equals("M")){
            weight = ((72.7f * height) - 58);
            msg = new DecimalFormat("#,##0.00").format(weight);
        }else{
            weight = ((62.1f * height) - 44.7f);
            msg = new DecimalFormat("#,##0.00").format(weight);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void limpar(){
        weight = 0;
        height = 0;
        sexo = "";
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
