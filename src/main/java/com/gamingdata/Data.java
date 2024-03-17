package com.gamingdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    private String riotApiKey = "RGAPI-d4a232d0-7d17-428f-a808-7622666f91f1";

    private String riotUrl = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
}
