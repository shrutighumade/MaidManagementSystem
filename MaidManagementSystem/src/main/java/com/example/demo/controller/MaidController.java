package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.entity.Maid;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.MaidService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/maids")
public class MaidController {
	
	

    @Autowired
    private MaidService maidService;
    
    
    @PostMapping("/add")
    public ResponseEntity<Maid> addMaid(@Valid @RequestBody Maid maid) {
        Maid addedMaid = maidService.addMaid(maid);
        return new ResponseEntity<>(addedMaid, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Maid>> getAllMaids() {
        List<Maid> maids = maidService.getAllMaids();
        return new ResponseEntity<>(maids, HttpStatus.OK);
    }

    @GetMapping("/{maidId}")
    public ResponseEntity<Object> getMaidById(@PathVariable Integer maidId) {
    	 try {
             List<Maid> maid = maidService.getMaidById(maidId);
             return new ResponseEntity<>(maid, HttpStatus.OK);
         } catch (ResourceNotFoundException e) {
         	Map<String, String> map = new HashMap<>();
 			map.put("errorMessage", e.getMessage());
             return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
         }
    	 
    	
    }

    

   
}
