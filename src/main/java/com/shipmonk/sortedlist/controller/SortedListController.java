package com.shipmonk.sortedlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipmonk.sortedlist.dto.AdditionResultDto;
import com.shipmonk.sortedlist.dto.IntegerDto;
import com.shipmonk.sortedlist.dto.IntegersDto;
import com.shipmonk.sortedlist.dto.StringDto;
import com.shipmonk.sortedlist.dto.StringsDto;
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

    @GetMapping(value="/strings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSortedStringsList(@RequestParam String sort) {
        StringsDto stringsDto = iSortedListService.getSortedListString(sort);
        return new ResponseEntity<Object>(stringsDto, HttpStatus.OK);
    }
    
    @GetMapping(value="/integers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSortedIntegersList(@RequestParam String sort) {
        IntegersDto integersDto = iSortedListService.getSortedListInteger(sort);
        return new ResponseEntity<Object>(integersDto, HttpStatus.OK);
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
