/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author ydoghri
 */
public class Spe implements Comparable<Spe> {

    private String libelle;
    private Collection<Med> lesMeds = new TreeSet<Med>();

    public Spe(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }
    
    public void addUnMed(Med unMed) {
        lesMeds.add(unMed);
    }
    
    @Override
    public int compareTo(Spe s) {
        return libelle.compareTo(s.libelle);
    }
}