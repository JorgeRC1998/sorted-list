package com.shipmonk.sortedlist.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipmonk.sortedlist.dao.SortedListDao;
import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.ListsDto;
import com.shipmonk.sortedlist.dto.StringDto;

@Service
public class SortedListServiceImp implements ISortedListService {

    @Autowired
    SortedListDao sortedListDao;

    private static String RESPONSE = "Your value was added correctly";
    
    @Override
    public ListsDto getSortedLists(String sort) {
        LinkedList<String> strings = new LinkedList<String>();
        LinkedList<Integer> integers = new LinkedList<Integer>();
        ListsDto listsDto = new ListsDto();
        
        try{
            strings = sortedListDao.getSortedStringList(sort);
            integers = sortedListDao.getSortedIntegerList(sort);
            listsDto.setStrings(strings);
            listsDto.setIntegers(integers);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return listsDto;
    }

    @Override
    public AdditionResultDto addStringToList(StringDto string) {
        AdditionResultDto additionResultDto = new AdditionResultDto();

        try{
            sortedListDao.addStringToList(string.getString());
            additionResultDto.setValue(string.getString());
            additionResultDto.setDescription(RESPONSE);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return additionResultDto;
    }

    @Override
    public AdditionResultDto addIntegerToList(IntegerDto integer) {
        AdditionResultDto additionResultDto = new AdditionResultDto();

        try{
            sortedListDao.addIntegerToList(integer.getInteger());
            additionResultDto.setValue(integer.getInteger().toString());
            additionResultDto.setDescription(RESPONSE);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return additionResultDto;
    }
    
}
