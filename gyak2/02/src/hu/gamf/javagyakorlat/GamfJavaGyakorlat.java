/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 4-11-3-Hallgato
 */
public class GamfJavaGyakorlat {

    public String nev = "GamfJavaGyakorlat";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Szamitas> szamitasLista = new ArrayList<>();
        SzamitasService service = new SzamitasService();
      
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add meg a nettó összeget");

            String nettoOsszegString = scanner.next();

            System.out.println("Add meg az áfa értékét");
            String afaErtekString = scanner.next();
            Szamitas szamitas = null;
            try {
                szamitas = service.szamit(nettoOsszegString, afaErtekString);
            } catch (Exception e) {
                System.err.println("Az áfa értékre csak 15 vagy 27 lehet");
                
            }
            System.out.println("Adó értéke " + szamitas.adoErtek);
            System.out.println("Bruttó összeg " + szamitas.bruttoErtek);
            voltEIlyenSzamitas(szamitasLista,szamitas);
            szamitasLista.add(szamitas);
            
            AdatBazisKezelo db = new AdatBazisKezelo();
            
            db.mentSzamitast(szamitas);
        
        for (Szamitas sz : db.getSzamitasok()) {
            System.out.println(sz);
        }

    }

    private static void voltEIlyenSzamitas(ArrayList<Szamitas> szamitasok, Szamitas ujSzamitas){
        for(Szamitas aktualis:szamitasok){
            if(aktualis.nettoOsszeg.equals(ujSzamitas.nettoOsszeg)){
                if(aktualis.afaErteke.equals(ujSzamitas.afaErteke)){
                    //System.out.println("Ilyen Számítás már volt");
                }
            }
        }
        List<Szamitas> egyezoSzamitasok = szamitasok.stream()
                .filter(aktualis -> aktualis.nettoOsszeg.equals(ujSzamitas.nettoOsszeg) && aktualis.afaErteke.equals(ujSzamitas.afaErteke)).collect(Collectors.toList());
        if(egyezoSzamitasok.size() > 0){
             System.out.println("Ilyen Számítás már volt");
        }
    }
}
