/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;

/**
 *
 * @author ydoghri
 */
public class Pays {
    private Collection <Dep> lesDeps;
    private Collection <Spe> lesSpes;
    private Collection <Med> lesMeds;

    public Pays() {
        lesDeps = DAO.getLesDeps();
        lesSpes = DAO.getLesSpes();
        lesMeds = DAO.getLesMeds();
    }
    
    public Collection<Dep> getLesDeps() {
        return lesDeps;
    }
    
    public Collection<Spe> getLesSpes() {
        return lesSpes;
    }
    
    public Dep getLeDep(String numDep) {
        for (Dep unDepartement : lesDeps) {
            if (unDepartement.getNum().equals(numDep)) {
                return unDepartement;
            }
        }
        return null;
    }
    
}