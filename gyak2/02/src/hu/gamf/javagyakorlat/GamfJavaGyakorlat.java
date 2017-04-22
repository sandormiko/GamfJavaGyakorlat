/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        try {
            ArrayList<Szamitas> szamitasLista = new ArrayList<>();
            AdatBazisKezelo db = new AdatBazisKezelo();
            SzamitasService service = new SzamitasService();

            Scanner scanner = new Scanner(System.in, "iso-8859-2");
            System.out.println("Add meg az azonositojat");

            String azonosito = scanner.next();
            Szemely szemely = szemelytRegisztralHaUj(db, azonosito, scanner);
            System.out.println("Add meg a nettó összeget");

            String nettoOsszegString = scanner.next();

            System.out.println("Add meg az áfa értékét");
            String afaErtekString = scanner.next();

            Szamitas szamitas = service.szamit(nettoOsszegString, afaErtekString);

            szamitas.szemelyId = szemely.szemelyId;
            System.out.println("Adó értéke " + szamitas.adoErtek);
            System.out.println("Bruttó összeg " + szamitas.bruttoErtek);
            voltEIlyenSzamitas(szamitasLista, szamitas);
            szamitasLista.add(szamitas);

            db.mentSzamitast(szamitas);

            for (Szamitas sz : db.getSzamitasok()) {
                System.out.println(sz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private static Szemely szemelytRegisztralHaUj(AdatBazisKezelo db, String azonosito, Scanner scanner) throws ParseException, SQLException {
        Szemely szemely = db.getSzemelyByAzonosito(azonosito);

        if (szemely == null) {
            szemely = new Szemely();
            szemely.azonosito = azonosito;
            System.out.println("Ön még nincs regisztrálva rendszerünkben");
            System.out.println("Adja meg vezetéknevét");
            szemely.vezeteknev = scanner.next();
            System.out.println("Adja meg keresztnevét");
            szemely.keresztnev = scanner.next();

            System.out.println("Adja meg születési idejét");
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            szemely.szuletesiIdo = formatter.parse(scanner.next());
            db.mentSzemelyt(szemely);
        }

        return szemely;
    }

    private static void voltEIlyenSzamitas(ArrayList<Szamitas> szamitasok, Szamitas ujSzamitas) {
        for (Szamitas aktualis : szamitasok) {
            if (aktualis.nettoOsszeg.equals(ujSzamitas.nettoOsszeg)) {
                if (aktualis.afaErteke.equals(ujSzamitas.afaErteke)) {
                    //System.out.println("Ilyen Számítás már volt");
                }
            }
        }
        List<Szamitas> egyezoSzamitasok = szamitasok.stream()
                .filter(aktualis -> aktualis.nettoOsszeg.equals(ujSzamitas.nettoOsszeg) && aktualis.afaErteke.equals(ujSzamitas.afaErteke)).collect(Collectors.toList());
        if (egyezoSzamitasok.size() > 0) {
            System.out.println("Ilyen Számítás már volt");
        }
    }
}
