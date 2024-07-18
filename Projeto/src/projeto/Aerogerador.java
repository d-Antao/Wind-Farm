/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author diogo
 */
public class Aerogerador {

    
    double longitude, latitude, rotor, altura;
    String localidade, data, gerador;
    CoeficientePotencia cp;
    Atmosfera atm;

    //metodo construtor da classe Aerogerador
    public Aerogerador(double altitude, double longitude, double latitude, double rotor, String localidade, String data, String gerador, double altura) {

        atm = new Atmosfera(altitude + altura);
        this.longitude = longitude;
        this.latitude = latitude;
        this.localidade = localidade;
        this.data = data;
        this.altura = altura;
        manutencao(rotor,gerador.toUpperCase());
    }

    //sets e gets da Aerogerador
    public String getData() {
        return data;
    }

    public String getLocalidade() {
        return localidade;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    //gets da turbina
    public double getRotor() {
        return this.rotor;
    }

    public String getGerador() {
        return this.gerador;
    }

    public double getAltura() {
        return altura;
    }

    //metodo para devolver as informações do Aerogerador
    public void info() {
        System.out.println("------INFORMAÇÃO AEROGERADOR------");
        System.out.println("Altitude: " + atm.getAltitude());
        System.out.println("----------------------------------");
        System.out.println("Longitude: " + getLongitude());
        System.out.println("----------------------------------");
        System.out.println("Latitude: " + getLatitude());
        System.out.println("----------------------------------");
        System.out.println("Localidade: " + getLocalidade());
        System.out.println("----------------------------------");
        System.out.println("Data de instalação: " + getData());
        System.out.println("----------------------------------");
        System.out.println("Raio das pás: " + getRotor());
        System.out.println("----------------------------------");
        System.out.println("Gerador: " + getGerador());
        System.out.println("----------------------------------");
        System.out.println("Altura até ao solo: " + getAltura());
        System.out.println("----------------FIM----------------");
    }

    //metodos relacionados com a tubina
    //metodo que retorna a area do rotor
    public double getArea() {
        return Math.PI * Math.pow(getRotor(), 2);
    }

    //metodo que avalia qual o cenario
    
    private void velificarCp() {
        if (rotor <= 8 && gerador.equals("G1")) {
            cp = new CenarioA();
        } else if (rotor > 8 || gerador.equals("G2")) {
            cp = new CenarioB();
        }
    }

    //metodo que retorna a potencia da tubina dependendo dos cenarios
    public double potenciaTurbina(double vel) {
        double pv = (0.5 * atm.getDensidade() * getArea() * Math.pow(vel, 3));
        velificarCp();
        return pv * cp.getCp(vel);

    }

    //metodo para fazer a troca do gerador
    public void manutencao(String gerador) {
        String ger = gerador.toUpperCase();
        if (ger.equals("G1") || ger.equals("G2")) {
            this.gerador = gerador.toUpperCase();
            
        } else {
            throw new IllegalArgumentException(" Tipo de gerador incompativel. ");
        }

    }

    //metodo para fazer a troca do rotor consuante a altura do Aerogerador
    public void manutencao(double rotor) {
        if ((altura - rotor) >= 4) {
            this.rotor = rotor;
        } else {
            throw new IllegalArgumentException(" Tamanho das pás incompativel. ");
        }
    }

    //metodo para fazer a troca do rotor e do gerador
    public void manutencao(double rotor, String gerador) {
        manutencao(rotor);
        manutencao(gerador);
    }
    
}

