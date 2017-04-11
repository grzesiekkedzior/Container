/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

/**
 *
 * @author grzesiek
 */
public class Main {

    public static void main(String args[]) {

        double[] tab = {1.22, 2.33, 3.11};
        Container<Double> integer = new Container<>(tab);
        integer.showAll();
        Container<Integer> integer2 = new Container<>();
        for (int a = 1; a < 100000; a++) {
            integer2.addSorted(a);
        }
        integer2.addSorted(10000);
        integer2.showAll();
        //test git clone
    }

}
