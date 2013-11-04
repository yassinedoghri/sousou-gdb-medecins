package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private static Collection<Dep> d;

    public static Collection<Dep> getLesDeps() {
        try {

            java.sql.Statement req;

            Connection cnx = Connect.get();

            //Requête
            req = (java.sql.Statement) cnx.createStatement();
            ResultSet rs;

            rs = req.executeQuery("Select DISTINCT departement from medecin order by departement");
            Collection<Dep> d = new TreeSet<Dep>();

            //Parcours
            while (rs.next()) {
                String dep = rs.getString(1);


                Collection<Med> m = new HashSet<Med>();
                Statement req2;
                req2 = cnx.createStatement();
                ResultSet rs2 = req2.executeQuery("select id, nom, prenom, adresse, tel, specialitecomplementaire"
                        + " from medecin where departement='" + dep + "'");

                while (rs2.next()) {
                    String id = rs2.getString("id");
                    String nom = rs2.getString("nom");
                    String prenom = rs2.getString("prenom");
                    String adresse = rs2.getString("adresse");
                    String tel = rs2.getString("tel");
                    String spe = rs2.getString("specialitecomplementaire");
                    m.add(new Med(nom, prenom, adresse, tel, spe, id));
                }
                d.add(new Dep(dep, m));
                
                rs2.close();
            }

            rs.close();

            //fermeture de la B de D
            req.close();

        } catch (SQLException ex) {
            Logger.getLogger(Pays.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
