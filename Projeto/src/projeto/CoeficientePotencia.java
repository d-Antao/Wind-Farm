/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author diogo
 */
public abstract class CoeficientePotencia {
    //metodo para returna o cp (inclusive faz interpolaçao)
    public double getCp(double vel) {
        double cp;
        if (vel >= 0 && vel <= 2) {
            cp = tabel((int) vel);
        } else if (vel % 2 != 0 && vel <= 18) {
            if ((int) vel % 2 != 0) {
                cp = Math.abs((((tabel((int) vel + 1) - tabel((int) vel - 1)) / (((int) vel + 1) - ((int) vel - 1))) * ((int) (vel + 1) - vel)) - tabel((int) vel + 1));
            } else {
                cp = Math.abs((((tabel((int) vel + 2) - tabel((int) vel)) / (((int) vel + 2) - ((int) vel))) * ((int) (vel + 2) - vel)) - tabel((int) vel + 2));
            }
        } else if (vel > 18) {
            cp = tabel(18);
        } else {
            cp = tabel((int) vel);
        }
        return cp;
    }

    public abstract double tabel(int vel);

}
