/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.util.ArrayList;

/**
 *
 * @author 4-11-3-Hallgato
 */
public class SzamitasService {

    public Szamitas szamit(String nettoOsszegString, String afaErtekeString) {
        Double nettoOsszeg = Double.parseDouble(nettoOsszegString);
        //Double afaErteke = Double.parseDouble(afaErtekeString);
        AfaErtek afaertekEnumkent  = AfaErtek.getEnum(afaErtekeString);
        Double afaErteke = afaertekEnumkent.getErtek();
        Double adoErtek = nettoOsszeg / 100 * afaErteke;
        Double bruttoErtek = nettoOsszeg + adoErtek;
        Szamitas szamitas = new Szamitas();
        szamitas.adoErtek = adoErtek;
        szamitas.nettoOsszeg = nettoOsszeg;
        szamitas.bruttoErtek = bruttoErtek;
        szamitas.afaErteke = afaertekEnumkent;
        return szamitas;
    }
    
    
}
