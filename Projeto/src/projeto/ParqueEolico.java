/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public class ParqueEolico {

    ArrayList<Aerogerador> parque;
    //construtor instancia um novo parque eolico
    public ParqueEolico() {
        parque = new ArrayList<>();
    }
    //metodo para contar quantos aerogeradores existem no array
    public int contAerogerador() {
        return parque.size();
    }
    //metodo para contar quantos aerogeradores existem acima de uma certa altura no array
    public int contAerogerador(double altura) {
        int cont = 0;
        for (Aerogerador a : parque) {
            if (a.getAltura() > altura) {
                cont++;
            }
        }
        return cont;
    }
    //metodo que mostra toda a informaçao de um aerogerador expecifico 
    public void infAerogerador(int idx) {
        Aerogerador a = parque.get(idx);
        a.info();
    }
    //metodo para adicionar um novo aerogerador ao parque
    public void addAerogerador(double altitude, double longitude, double latitude, double rotor, String localidade, String data, String gerador, double altura) {
        parque.add(new Aerogerador(altitude, longitude, latitude, rotor, localidade, data, gerador, altura));
    }
    //metodo para remover um  aerogerador do parque
    public void remAerogerador(int idx) {
        parque.remove(idx);
    }
    
    //metodos para trocar componentes do aerogerador
    
    public void manutençao(String gerador, int idx) {
        Aerogerador a = parque.get(idx);
        a.manutencao(gerador);
    }

    public void manutençao(double rotor, int idx) {
        Aerogerador a = parque.get(idx);
        a.manutencao(rotor);
    }

    public void manutençao(String gerador, double rotor, int idx) {
        Aerogerador a = parque.get(idx);
        a.manutencao(rotor, gerador);
    }
    //metodo para calcular a potencia para um dado instante num unico aerogerador
    public double potenciaInst(double vel, int idx) {
        Aerogerador a = parque.get(idx);
        return a.potenciaTurbina(vel);
    }
    //metodo para calcular a potencia para varios instantes para um unico aerogerador
    public double[] potenciaInst(double[] vel, int idx) {
        Aerogerador a = parque.get(idx);
        double pt[] = new double[vel.length];
        for (int i = 0; i < vel.length; i++) {
            pt[i] = a.potenciaTurbina(vel[i]);
        }
        return pt;
    }
    //metodo para calcular a soma das potencias de todos os aerogeradores num dado instante
    public double somaPotenciaInt(double vel) {
        double some = 0;
        for (Aerogerador a : parque) {
            some += a.potenciaTurbina(vel);
        }
        return some;
    }
    //metodo intermedio que verifica qual a Estação Meteorológica(velocidade,longitude,latitude) fica mais perto de um dado Aerogerador e calcula a estimativa da potencia associada a mesma 
    public double potenciaCord(double[] vel, double[] longitude, double[] latitude, int idx) {
        Aerogerador a = parque.get(idx);
        int cordV = 0;
        double dist[] = new double[vel.length];
        dist[0] = Math.sqrt(Math.pow(longitude[0] - a.getLongitude(), 2) + Math.pow(latitude[0] - a.getLatitude(), 2));
        double distancia = dist[0];
        for (int i = 0; i < vel.length; i++) {
            dist[i] = Math.sqrt(Math.pow(longitude[i] - a.getLongitude(), 2) + Math.pow(latitude[i] - a.getLatitude(), 2));
            if (dist[i] <= distancia) {
                distancia = dist[i];
                cordV = i;
            }
        }
        return a.potenciaTurbina(vel[cordV]);
    }
    //metodo para estimar a potencia global produzida, com a melhor aproximação à velocidade do vento junto de cada aerogerador
    public double somaPotenciaCord(double[] vel, double[] longitude, double[] latitude) {
        double som = 0;
        for (Aerogerador a : parque) {
            som += potenciaCord(vel, longitude, latitude, parque.indexOf(a));
        }
        return som;
    }

}
