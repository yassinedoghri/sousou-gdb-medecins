/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ydoghri
 */
public class Connect { //singleton

    private static Connection cnx = null;

    private static Connection open() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote mal installé... " + e);
        }
        try {
            cnx = DriverManager.getConnection("jdbc:postgresql://lucie/medecin", "ydoghri", "linux");
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
        return cnx;
    }

    public static Connection get() {
        if (cnx == null) {
            cnx = Connect.open();
        }
        return cnx;
    }

    public static void close() {
        try {
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
    }
}