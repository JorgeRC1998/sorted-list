package com.shipmonk.sortedlist.service;

import org.springframework.stereotype.Service;

import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.ListsDto;
import com.shipmonk.sortedlist.dto.StringDto;

@Service
public interface ISortedListService {
    public ListsDto getSortedLists(String sort);
    public AdditionResultDto addStringToList(StringDto string);
    public AdditionResultDto addIntegerToList(IntegerDto integer);
}
