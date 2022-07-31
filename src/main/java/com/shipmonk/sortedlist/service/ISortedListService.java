package com.shipmonk.sortedlist.service;

import org.springframework.stereotype.Service;

import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.IntegersDto;
import com.shipmonk.sortedlist.dto.StringDto;
import com.shipmonk.sortedlist.dto.StringsDto;

@Service
public interface ISortedListService {
    public StringsDto getSortedListString(String sort);
    public IntegersDto getSortedListInteger(String sort);
    public AdditionResultDto addStringToList(StringDto string);
    public AdditionResultDto addIntegerToList(IntegerDto integer);
}
