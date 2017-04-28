/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mikó Sándor
 */
public abstract class AbsztraktAdatbazisKezelo {
    
    
    protected static void close(AutoCloseable closeAble) {
        if (closeAble != null) {
            try {
                closeAble.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    protected static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
