package grzesiek.collection.main;

import java.util.ArrayList;

import grzesiek.collection.container.Container;
import grzesiek.collection.container.List;
import grzesiek.collection.map.LinkedMap;
import grzesiek.collection.map.Map;



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

        List<Integer> list = new Container<>(1,2,3,4,5);
        
        
        list.addIndex(1,20);
        for(int i : list) {
        	System.out.println(i);
        }
		Map<String, Integer> map = new LinkedMap<>();
		map.put("key1", 10);
		map.put("key2", 20);
		map.put("key3", 30);
		map.remove("key3");

        System.out.println(map.get("key2"));
        
    }

}
