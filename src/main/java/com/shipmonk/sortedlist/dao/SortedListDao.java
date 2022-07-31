package com.shipmonk.sortedlist.dao;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SortedListDao {
    private static LinkedList<String> strings = new LinkedList<String>();
    private static LinkedList<Integer> integers = new LinkedList<Integer>();
    private static String ASCENDANT = "ascendant";
    private static String DESCENDANT = "descendant";

    static {
        // add some data to string list
        strings.add("adelle");
        strings.add("jonas");
        strings.add("katy");
        strings.add("george");
        strings.add("paul");

        // add some data to integer list
        integers.add(Integer.valueOf(2));
        integers.add(Integer.valueOf(6));
        integers.add(Integer.valueOf(1));
        integers.add(Integer.valueOf(26));
        integers.add(Integer.valueOf(7));
    }

    public LinkedList<String> getSortedStringList(String typeSort){
        if(typeSort.toLowerCase().equals(ASCENDANT.toLowerCase())){
            strings.sort(Comparator.naturalOrder());
        }else if(typeSort.toLowerCase().equals(DESCENDANT.toLowerCase())){
            strings.sort(Comparator.reverseOrder());
        }else{

        }

        return strings;
    }

    public LinkedList<Integer> getSortedIntegerList(String typeSort){
        if(typeSort.toLowerCase().equals(ASCENDANT.toLowerCase())){
            integers.sort(Comparator.naturalOrder());
        }else if(typeSort.toLowerCase().equals(DESCENDANT.toLowerCase())){
            integers.sort(Comparator.reverseOrder());
        }else{

        }

        return integers;
    }

    public void addStringToList(String string){
        strings.add(string);
    }

    public void addIntegerToList(Integer integer){
        integers.add(integer);
    }

}
