package com.shipmonk.sortedlist.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipmonk.sortedlist.dao.SortedListDao;
import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.IntegersDto;
import com.shipmonk.sortedlist.dto.StringDto;
import com.shipmonk.sortedlist.dto.StringsDto;

@Service
public class SortedListServiceImp implements ISortedListService {

    @Autowired
    SortedListDao sortedListDao;

    private static String RESPONSE = "Your value was added correctly";
    
    @Override
    public StringsDto getSortedListString(String sort) {
        LinkedList<String> strings = new LinkedList<String>();
        StringsDto stringsDto = new StringsDto();
        
        try{
            strings = sortedListDao.getSortedStringList(sort);
            stringsDto.setStrings(strings);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return stringsDto;
    }

    @Override
    public IntegersDto getSortedListInteger(String sort) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        IntegersDto integersDto = new IntegersDto();
        
        try{
            integers = sortedListDao.getSortedIntegerList(sort);
            integersDto.setIntegers(integers);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return integersDto;
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
            additionResultDto.setValue(integer.toString());
            additionResultDto.setDescription(RESPONSE);
        }catch(Exception e){
            System.out.println("There was an error, details: " + e.getMessage());
        }

        return additionResultDto;
    }
    
}
