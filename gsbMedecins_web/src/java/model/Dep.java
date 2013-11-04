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
public class Dep {
    private String num;
    private Collection <Med> lesMeds;

    public Dep(String num, Collection<Med>lesMeds) {
        this.num = num;
        this.lesMeds = lesMeds;
    }
    
    public String getNum() {
        return num;
    }
    
//    public compareTo(Object t) {
//        
//    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

}
