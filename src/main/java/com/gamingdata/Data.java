package com.gamingdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    private String riotApiKey = "RGAPI-e36e6770-6d43-4620-9232-e94665d0563e";

    private String riotUrl = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
}
