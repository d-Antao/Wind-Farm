/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

public class Atmosfera{

    final static double  T0 = 288.15, L = 0.0065, P0 = 101325, G = 9.80665, R = 8.31447, M = 0.0289644;
    double altitude;
    double Press;
    double Temp;
    //Construtor da class Atemofera que recebe uma altitude.
    public Atmosfera(double altitude){
        this.altitude = altitude;
    }
    // metudo que retorna a Temperatura para uma dada  altitude
    public double getTemperatura(){
        this.Temp = T0 - L * getAltitude();
        return this.Temp;

    }
    //metudo que retorna uma pressão para uma dada altitude
    public double getPressao(){

        double dentro = 1 - ((L * getAltitude())/ T0);
        double expoente = (G * M) / (R * L);

        return P0 * Math.pow(dentro,expoente);
    }
    //metudo que retorna uma Densidade para uma dada altitude
    
    public double getDensidade(){
        
        return (getPressao() * M )/(R * getTemperatura());

    }

    //altitude maxima da troposferas é 12000
    public double getAltitude()throws IllegalArgumentException{
        if(altitude>=12000){
            throw new IllegalArgumentException(" Altitude admissivel ultrapassada. ") ;
        }else if(altitude<0){
            throw new IllegalArgumentException(" Altitude < 0 ") ;
        }else{
            return altitude;
        }
    }

}
