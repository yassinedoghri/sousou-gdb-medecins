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
public class Dep implements Comparable<Dep>{
    private String num;
    private Collection <Med> lesMeds;

    public Dep(String num, Collection<Med> lesMedecins) {
        this.num = num;
        this.lesMeds = lesMedecins;
    }
    
    public String getNum() {
        return num;
    }
    
    public int compareTo(Dep d) {
        return num.compareTo(d.num);
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

}
