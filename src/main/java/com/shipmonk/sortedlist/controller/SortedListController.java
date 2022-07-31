package com.shipmonk.sortedlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.ListsDto;
import com.shipmonk.sortedlist.dto.StringDto;
import com.shipmonk.sortedlist.service.ISortedListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/shipmonk")
public class SortedListController {
    
    @Autowired
    ISortedListService iSortedListService;

    @GetMapping(value="/lists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSortedLists(@RequestParam String sort) {
        ListsDto listsDto = iSortedListService.getSortedLists(sort);
        return new ResponseEntity<Object>(listsDto, HttpStatus.OK);
    }

    @PostMapping(value="/string", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addStringToList(@RequestBody StringDto string){
        AdditionResultDto additionResultDto = iSortedListService.addStringToList(string);
        return new ResponseEntity<Object>(additionResultDto, HttpStatus.OK);
    }

    @PostMapping(value="/integer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addIntegerToList(@RequestBody IntegerDto integer){
        AdditionResultDto additionResultDto = iSortedListService.addIntegerToList(integer);
        return new ResponseEntity<Object>(additionResultDto, HttpStatus.OK);
    }

}
