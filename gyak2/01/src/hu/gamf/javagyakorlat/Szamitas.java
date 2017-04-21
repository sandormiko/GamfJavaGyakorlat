/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.util.Date;

/**
 *
 * @author 4-11-3-Hallgato
 */
public class Szamitas {

    public Long szamitasId;
    public Double nettoOsszeg;
    public Double adoErtek;
    public AfaErtek afaErteke;
    public Double bruttoErtek;
    public Date letrehozasIdeje;

    @Override
    public String toString() {
        return "Szamitas{" + "szamitasId=" + szamitasId + ", nettoOsszeg=" + nettoOsszeg + ", adoErtek=" + adoErtek + ", afaErteke=" + afaErteke + ", bruttoErtek=" + bruttoErtek + ", letrehozasIdeje=" + letrehozasIdeje + '}';
    }

    

    
}
