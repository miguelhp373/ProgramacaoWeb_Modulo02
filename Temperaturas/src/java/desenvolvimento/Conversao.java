
package desenvolvimento;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Conversao {
    private float celsius, fahrenheit, kelvin;
    private String msg;
    
    public void converter(){
        fahrenheit = (celsius * 5 / 9) + 32;
        kelvin = celsius + 273;
        
        if(celsius <= 15){
            msg = "Temperatura fria";
        }
        else if (celsius <= 25){
            msg = "Temperatura amena";
        }
        else {
            msg = "Temperatura quente";
        }
    }
    
    public void limpar(){
        celsius = 0;
        fahrenheit = 0;
        kelvin = 0;
        msg = "";
    }
    

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(float fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public float getKelvin() {
        return kelvin;
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    
}
