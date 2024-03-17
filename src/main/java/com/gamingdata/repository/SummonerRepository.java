package com.gamingdata.repository;

import com.gamingdata.model.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SummonerRepository extends JpaRepository<Summoner, Long> {

    Summoner findByName(String name);
}
