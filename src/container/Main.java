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
        Container<String> container = new Container<>();
        container.addSorted("alpha");
        container.addSorted("bravo");
        container.addSorted("zeta");
        container.addSorted("delta");
        container.addSorted("charlie");
        container.addSorted("theta");
        container.addSorted("wish");
        container.addSorted("lis");
        
        
        container.showAll();
    }
    
}
