/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.util.Date;

/**
 *
 * @author Mikó Sándor
 */
public class Szemely {

    public Long szemelyId;
    public String azonosito;
    public String keresztnev;
    public String vezeteknev;
    public Date szuletesiIdo;

    @Override
    public String toString() {
        return "Szemely{" + "szemelyId=" + szemelyId + ", azonosito=" + azonosito + ", keresztnev=" + keresztnev + ", vezeteknev=" + vezeteknev + ", szuletesiIdo=" + szuletesiIdo + '}';
    }
}
