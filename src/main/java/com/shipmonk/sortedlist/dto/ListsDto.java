package com.shipmonk.sortedlist.dto;

import java.util.LinkedList;

public class ListsDto {
    private LinkedList<Integer> integers = new LinkedList<Integer>();
    private LinkedList<String> strings = new LinkedList<String>();

    public LinkedList<Integer> getIntegers() {
        return integers;
    }
    public void setIntegers(LinkedList<Integer> integers) {
        this.integers = integers;
    }
    public LinkedList<String> getStrings() {
        return strings;
    }
    public void setStrings(LinkedList<String> strings) {
        this.strings = strings;
    }
    
}
