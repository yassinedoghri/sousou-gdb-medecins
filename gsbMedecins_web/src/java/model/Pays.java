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

    private Collection<Dep> lesDeps;
    private Collection<Spe> lesSpes;
    private Collection<Med> lesMeds;

    public Pays() {
        lesDeps = DAO.getLesDeps();
        lesSpes = DAO.getLesSpes();
        lesMeds = DAO.getLesMeds();
        this.assocMedecins();
    }

    public Collection<Dep> getLesDeps() {
        return lesDeps;
    }

    public Collection<Spe> getLesSpes() {
        return lesSpes;
    }
    
    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

    public void assocMedecins() {
        for (Med unMed : lesMeds) {
            getLeDep(unMed.getDep()).addUnMed(unMed);
            if (getLaSpe(unMed.getSpe()) != null) {
                getLaSpe(unMed.getSpe()).addUnMed(unMed);
            }
        }
    }

    public Dep getLeDep(String numDep) {
        for (Dep unDep : lesDeps) {
            if (unDep.getNum().equals(numDep)) {
                return unDep;
            }
        }
        return null;
    }

    public Spe getLaSpe(String libelle) {
        for (Spe uneSpe : lesSpes) {
            if (uneSpe.getLibelle().equals(libelle)) {
                return uneSpe;
            }
        }
        return null;
    }
}