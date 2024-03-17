package com.gamingdata.service;

import com.gamingdata.Data;
import com.gamingdata.model.Summoner;
import com.gamingdata.repository.SummonerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class SummonerService {

    private final RestTemplate restTemplate;
    private final SummonerRepository repository;
    private final Data data = new Data();

    public List<Summoner> findAll() {
        return repository.findAll();
    }

    public Summoner insert(Summoner obj) {
        return repository.save(obj);
    }

    public Summoner findBySummonerName(String name) {
        return repository.findByName(name);
    }

    public Summoner saveSummonerDataFromRiotAPI(String summonerName) {
        String url = data.getRiotUrl() + summonerName + "?api_key=" + data.getRiotApiKey();
        ResponseEntity<Summoner> response = restTemplate.getForEntity(url, Summoner.class);
        Summoner summoner = response.getBody();
        return repository.save(summoner);
    }

}
