/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author diogo
 */
public class CenarioA extends CoeficientePotencia {

    ////tabela de cp assusiado a velocidade
    @Override

    public double tabel(int vel) {
        switch (vel) {
            case 0:
                return 0;
            case 2:
                return 0;
            case 4:
                return 0.02;
            case 6:
                return 0.30;
            case 8:
                return 0.40;
            case 10:
                return 0.44;
            case 12:
                return 0.41;
            case 14:
                return 0.35;
            case 16:
                return 0.26;
            case 18:
                return 0.18;
            default:
                throw new IllegalArgumentException("velocidade < 0");
        }
    }

}
