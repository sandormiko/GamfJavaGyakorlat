/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikó Sándor
 */
public class AdatBazisKezelo {

    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost";
    private static final String DB_USER = "sa";
    private static final String DB_USER_PASSWORD = "";

    public ArrayList<Szamitas> getSzamitasok() {
        ArrayList<Szamitas> lekerdezettSzamitasok = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Class.forName("org.hsqldb.jdbcDriver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select szamitas_id,netto_osszeg,afa,brutto_osszeg,ado_ertek, letrehozas_ideje  from szamitas");
            while (rs.next()) {
                Szamitas sz = new Szamitas();
                sz.szamitasId = rs.getLong("szamitas_id");
                sz.nettoOsszeg = rs.getDouble("netto_osszeg");
                sz.afaErteke = AfaErtek.getEnum(rs.getDouble("afa"));
                sz.bruttoErtek = rs.getDouble("brutto_osszeg");
                sz.adoErtek = rs.getDouble("ado_ertek");
                sz.letrehozasIdeje = rs.getDate("letrehozas_ideje");
                lekerdezettSzamitasok.add(sz);
            }
            return lekerdezettSzamitasok;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return null;

    }

    public void mentSzamitast(Szamitas sz) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //Class.forName("org.hsqldb.jdbcDriver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);
            ps = conn.prepareStatement("insert into szamitas("
                    + "netto_osszeg,afa,brutto_osszeg,ado_ertek, letrehozas_ideje) "
                    + "values(?,?,?,?,?)");

            ps.setDouble(1, sz.nettoOsszeg);
            ps.setDouble(2, sz.afaErteke.getErtek());
            ps.setDouble(3, sz.bruttoErtek);
            ps.setDouble(4, sz.adoErtek);
            ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(conn);
        }
    }

    private void close(AutoCloseable closeAble) {
        if (closeAble != null) {
            try {
                closeAble.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
