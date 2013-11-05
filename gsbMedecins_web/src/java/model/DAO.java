package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {    

    public static Collection<Dep> getLesDeps() {
        Collection<Dep> d = new HashSet<Dep>();
        try {

            Connection cnx = Connect.get();

            //Requête
            java.sql.Statement req = (java.sql.Statement) cnx.createStatement();

            ResultSet rs = req.executeQuery("Select DISTINCT departement from medecin order by departement");

            //Parcours
            while (rs.next()) {
                String dep = rs.getString("departement");


                
                Statement req2;
                req2 = cnx.createStatement();
                ResultSet rs2 = req2.executeQuery("select id, nom, prenom, adresse, tel, specialitecomplementaire"
                        + " from medecin where departement='" + dep + "'");

                Collection<Med> m = new HashSet<Med>();
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
