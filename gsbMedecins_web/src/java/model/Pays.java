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

    public Pays() {
        DAO.getLesDeps();
    }
    
    public Collection<Dep> getLesDeps() {
        return lesDeps;
    }
    
    public Dep getLeDep(String numDep) {
        for (Dep unDepartement : lesDeps) {
            if (unDepartement.getNum()==numDep) {
                return unDepartement;
            }
        }
        return null;
    }
    
}
