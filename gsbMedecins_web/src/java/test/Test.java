/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Pays;

/**
 *
 * @author ydoghri
 */
public class Test {
    public static void main(String[] args) {
        Pays p = new Pays();
        System.out.println(p.getLeDep("5").getNum());
    }
}