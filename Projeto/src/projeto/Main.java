/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto;

//import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author diogo
 */
public class Main {

    public static void main(String[] args) {
        //criando variaveis
        //
        //test do caso 1 do relatorio
        Atmosfera atm1 = new Atmosfera(50);
        System.out.println(atm1.getTemperatura());
        System.out.println(atm1.getPressao());
        System.out.println(atm1.getDensidade());
        System.out.println("");
        
        //teste do caso 2 do relatorio
        Atmosfera atm2 = new Atmosfera(100);
        System.out.println(atm2.getTemperatura());
        System.out.println(atm2.getPressao());
        System.out.println(atm2.getDensidade());
        System.out.println("");
        
        //parque eolico
        ParqueEolico p = new ParqueEolico();
        double[] vel = new double[]{3, 8, 7.32, 10, 6, 2};
        double[] longitude = new double[]{22000, 4000, 3998, 38000, 10005, 5000};
        double[] latitude = new double[]{13000, 4000, 4200, 38000, 20000, 5};

        //addicionado aerogeradores
        //Aerogerador(altitude,longitude,latitude,rotor,localidade,data,gerador,altura)
        p.addAerogerador(30, 10000, 20000, 5, "Moita", "05-06-2000", "g1", 20);
        p.addAerogerador(50, 4005,3995, 8.5, "Pinhal Novo", "22-07-2022", "G2", 50);
        p.addAerogerador(10, 20000, 2000, 10, "Santarem", "01-05-0500", "G2", 240);
        p.addAerogerador(1200, 33000, 15000, 100, "Lisboa", "65-12-2000", "G2", 533);
        p.addAerogerador(6856, 22000, 20000, 42, "Algarve", "12-12-2000", "G2", 500);
        //
        //para o caso 1 do relatorio
        //teste para verificar se a potencia do Aerogerador esta a ser calculada com os dados da Estação Meteorológica(velocidade,longitude,latitude) mais proxima
        System.out.println(p.potenciaInst(6, 0));
        System.out.println(p.potenciaCord(vel, longitude, latitude, 0));
        
        System.out.println("");
        //caso 2 do relatorio
        //teste para verificar se a potencia do Aerogerador esta a ser calculada com os dados da Estação Meteorológica(velocidade,longitude,latitude) mais proxima
        System.out.println(p.potenciaInst(8, 1));
        System.out.println(p.potenciaCord(vel, longitude, latitude, 1));
        
        System.out.println("");
        
        //remover aerogerador
        //p.remAerogerador(4);
        //testando contAero
        System.out.println(p.contAerogerador());
        System.out.println(p.contAerogerador(250));

        //testando info
        System.out.println("");
        //p.infAerogerador(0);
        
        //testando potencias do array do metodo potenciaInst()
        System.out.println(p.potenciaInst(3, 0));
        System.out.println(p.potenciaInst(8, 0));
        System.out.println(p.potenciaInst(7.32, 0));
        System.out.println(p.potenciaInst(10, 0));
        System.out.println(p.potenciaInst(6, 0));
        System.out.println(p.potenciaInst(2, 0));
        System.out.println(Arrays.toString(p.potenciaInst(vel, 0)));
        System.out.println(p.somaPotenciaInt(5));
        
        System.out.println("");
        //testanto pontencias relativo as coordenadas do vento
        System.out.println(p.potenciaCord(vel, longitude, latitude, 0));
        System.out.println("");
        System.out.println(p.somaPotenciaCord(vel, longitude, latitude));
        
        //testando a manutenção
        p.manutençao("g1", 10, 3);

        
        //testando possiveis erros 
        
        //Aerogerador(double altitude, double longitude, double latitude, double rotor, String localidade, String data, String gerador, double altura)
        
        //erros relativos altitude
        
        //altitude da admissivel ultrapassada
        
        //p.addAerogerador(13000, 10000, 20000, 40, "Moita", "05-06-2000", "g1", 50);
        //System.out.println(p.potenciaInst(10, 4));
        
        //altitude negativa
        
        //p.addAerogerador(-100, 10000, 20000, 40, "Moita", "05-06-2000", "g1", 50);
        //System.out.println(p.potenciaInst(10, 4));
        
        //erros velocidade
        
        // velocidade < 0
        //System.out.println(p.potenciaInst(-1, 0));
        
        //erros de manutençao
        
        //p.manutençao(600, 3);//tamanho das pas do rotor imcompativel
        //p.manutençao("tr2", 0);//tipo de gerador imcompatível
        
    }
}
//----------------------------------------------------main interativa--------------------------------------------------------------------------------------------
/*public static void main(String[] args) {
        ParqueEolico p = new ParqueEolico();
        

        int menu;
        Scanner s = new Scanner(System.in);


        do {
            System.out.println("--------------------MENU--------------------");
            System.out.println("Olá seja bem vindo! O que o trás aqui hoje? ");
            System.out.println("--------------------------------------------");
            System.out.println("1 - Gerir Aerogeradores ");
            System.out.println("--------------------------------------------");
            System.out.println("2 - Adicionar Aerogeradores");
            System.out.println("--------------------------------------------");
            System.out.println("3 - Remover Aerogeradores");
            System.out.println("--------------------------------------------");
            System.out.println("4 - Manutenção de Aerogeradores");
            System.out.println("--------------------------------------------");
            System.out.println("5 - Informações sobre Aerogeradores");
            System.out.println("--------------------------------------------");
            System.out.println("7 - Outros métodos pedidos no enunciado");
            System.out.println("--------------------------------------------");
            System.out.println("0 - Sair");
            System.out.println("--------------------------------------------");


            menu = s.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("1 - Quantos aerogeradores ativos? ");
                    System.out.println("2 - Quantos aerogeradores instalados acima de uma determinada altura? ");
                    System.out.println("3 - Calcular energia produzida num instante ");
                    //System.out.println("4 - Calcular energia produzida em dias ");
                    //System.out.println("5 - Calcular energia produzida do empreendimento a velocidade constante");
                    int men = s.nextInt();


                    switch (men) {

                            case 1:
                                System.out.println(p.contAerogerador()+ " Geradores ativos.");

                                break;


                            case 2:
                                System.out.println("Qual é a altura?");
                                int h = s.nextInt();
                                System.out.println(p.contAerogerador(h)+ " Geradores ativos para " + h + " metros.");
                                break;

                            case 3:
                                System.out.println("Aerogerador? ");
                                int idx = s.nextInt();
                                System.out.println("Velocidade?");
                                double v = s.nextDouble();
                                System.out.println(p.potenciaInst(v,idx));
                                break;




                    }

                    break;


                case 2:
                    System.out.println("...Preciso de algumas informações...");
                    System.out.println("--------------------------------------------");

                    System.out.println("Altitude: ");
                    double altitude = s.nextDouble();

                    System.out.println("Longitude: ");
                    double longitude = s.nextDouble();

                    System.out.println("Latitude: ");
                    double latitude = s.nextDouble();

                    System.out.println("Localidade: ");
                    String localidade = s.nextLine();


                    System.out.println("Data de instalação: ");
                    String data = s.nextLine();


                    System.out.println("Tamanho das pás do rotor: ");
                    double rotor = s.nextDouble();

                    System.out.println("Tipo de gerador: ");
                    String gerador = s.next();

                    System.out.println("Altura do eixo: ");
                    double altura = s.nextDouble();

                    p.addAerogerador(altitude,longitude,latitude,rotor, localidade, data ,gerador,altura);
                    System.out.println("ADICIONADO! ");
                    break;

                case 3:
                    System.out.println("Qual o Aerogerador que pretente remover?: (0 - " + p.contAerogerador() );
                    int remove = s.nextInt();
                    p.remAerogerador(remove);
                    System.out.println("REMOVIDO! ");
                    break;


                case 4:
                    System.out.println("Qual o Aerogerador que pretente executar a manutenção?: ");
                    System.out.println("--------------------------------------------");
                    int ger = s.nextInt();
                    System.out.println("Que tipo de manutenção irá querer executar? ");
                    System.out.println("--------------------------------------------");
                    System.out.println("1 - Troca de rotor ");
                    System.out.println("--------------------------------------------");
                    System.out.println("2 - Troca de gerador ");
                    System.out.println("--------------------------------------------");
                    System.out.println("3 - Troca de ambos os componentes ");
                    System.out.println("--------------------------------------------");
                    int man = s.nextInt();

                    switch (man){
                        case 1 :
                            System.out.println("Qual o raio das pás do rotor? ");
                            double trocaRaio = s.nextDouble();
                            p.manutençao(trocaRaio,ger);
                            break;


                        case 2 :
                            System.out.println("Qual o tipo de gerador? ");
                            String trocaGerador = s.next();
                            p.manutençao(trocaGerador,ger);
                            break;


                        case 3:
                            System.out.println("Qual o raio das pás do rotor? ");
                            double trocaRaiox = s.nextDouble();
                            System.out.println("Qual o tipo de gerador? ");
                            String trocaGeradorx = s.next();
                            p.manutençao(trocaGeradorx,trocaRaiox,ger);
                            break;

                    }
                    break;

                case 5:
                    System.out.println("Deseja saber a informação de qual Aerogerador? ");
                    int i =s.nextInt();
                    p.infAerogerador(i);
                    break;


                case 7:
                    System.out.println("1 - Calcular energia produzida em dias: ");
                    double [] vel = new double[]{3.4, 5.5 , 7.8, 10.9, 11.34, 2.44, 5.33};
                    double [] lon = new double[]{273937,333533, 396838, 398393, 99344, 12611, 7491};
                    double [] lat = new double[]{27227, 52439 , 379373, 453378, 378989, 345453, 3463};
                    double[] pot = p.potenciaInst(vel,0);
                    System.out.println("Energia produzida em 7 dias: " + Arrays.toString(pot));
                    System.out.println("--------------------------------------------");
                    System.out.println("2 - Calcular energia produzida do empreendimento a velocidade constante");
                    double inst = p.somaPotenciaInt(vel[2]);
                    System.out.println("Energia produzida a " + vel[2]+ " m/s: " + inst );
                    System.out.println("--------------------------------------------");
                    System.out.println("3 - Calculo da estimativa de potencia que verifica qual a Estação Meteorológica(velocidade,longitude,latitude) fica mais perto de um dado Aerogerador. ");
                    double pote = p.potenciaCord(vel, lon, lat,0);
                    System.out.println("Potência " + pote );
                    System.out.println("--------------------------------------------");
                    System.out.println("4 -Calcúlo para estimar a potência global produzida, com a melhor aproximação à velocidade do vento junto de cada aerogerador. ");
                    double sompot = p.somaPotenciaCord(vel,lon,lat);
                    System.out.println("Potência Global produzida: " + sompot );
                    System.out.println("--------------------------------------------");
                    break;
            }
        }
        while( menu != 0 );

        System.out.println("----------...GOODBYE...----------");
        s.close();









    }
}
*/