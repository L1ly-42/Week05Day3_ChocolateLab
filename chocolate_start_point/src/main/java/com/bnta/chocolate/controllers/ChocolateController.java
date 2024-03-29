package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> chocolates = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/showChocolate{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> targetChocolate = chocolateService.getChocolateById(id);
        if(targetChocolate.isPresent()){ return new ResponseEntity<>(targetChocolate.get(),HttpStatus.OK);}
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/percentage")
    public ResponseEntity<List<Chocolate>> getChocolateByPercentage(@RequestParam int percentage){
        List<Chocolate> chocolates = chocolateService.getCocoaPercentage(percentage);
        return new ResponseEntity<>(chocolates,HttpStatus.CREATED);


    }




}
