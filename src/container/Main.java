
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author grzesiek
 */
public class Main {

    public static void main(String args[]) {

        List<Integer> list = new Container(1,2,3,4,5,6);
        List<Integer> list2 = list.reverse();
        list2.showAll();
        //System.out.println(list2.contains(7));
        List<Integer> subList = list2.subList(1, 3);
        subList.clear();
        System.out.println(subList.isEmpty());
        subList.add(100);
        
        subList.showAll();
        //.out.println(subList.isEmpty());
        
        
    }

}
