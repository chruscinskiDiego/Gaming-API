package com.gamingdata.service.exceptions;

public class SummonerNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SummonerNotFound(Object summonerName) {
        super("SUMMONER NOT FOUND! ERROR -> ");
    }
}
