package com.gamingdata.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_summoner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summoner {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private Long profileIconId;

    private Long summonerLevel;

}
