package com.gamingdata.controller;


import com.gamingdata.model.Summoner;
import com.gamingdata.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/summoners")
public class SummonerController {

    @Autowired
    private final SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }


    @GetMapping
    public ResponseEntity<List<Summoner>> findAll(){

        List<Summoner> list = summonerService.findAll();

        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{name}")
    public ResponseEntity<Summoner> findBySummoner(@PathVariable String name) {
        Summoner summoner = summonerService.saveSummonerDataFromRiotAPI(name);
        return ResponseEntity.ok().body(summoner);
    }


    @PostMapping
    public ResponseEntity<Summoner> insert (@RequestBody Summoner obj){
        obj = summonerService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }



}

