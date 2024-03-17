package com.gamingdata;

import com.gamingdata.model.Summoner;
import com.gamingdata.repository.SummonerRepository;
import com.gamingdata.service.SummonerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.Fail.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SummonerControllerTest {

    private final String API_SUMMONERS = "/summoners";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private SummonerRepository summonerRepository;

    private String validSummoner = "Scroowlz";

    @BeforeEach
    public void cleanup(){
        summonerRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }

    @Test
    @DisplayName("GET valid summoner from receive 200 ok")
    public void testSaveSummonerDataFromRiotAPI_realSummoner() {

        SummonerService ss = new SummonerService(new RestTemplate(),summonerRepository);

        assertThatNoException().isThrownBy(() -> ss.saveSummonerDataFromRiotAPI("Scroowlz"));
    }

    @Test
    @DisplayName("GET invalid summoner and receive negative responde")
    public void testSaveSummonerDataFromRiotAPI_fakeSummoner() {

        SummonerService ss = new SummonerService(new RestTemplate(),summonerRepository);

        assertThatException().isThrownBy(() -> ss.saveSummonerDataFromRiotAPI("xxxxScroowlz"));
    }
}
