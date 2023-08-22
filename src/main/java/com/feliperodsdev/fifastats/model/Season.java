package com.feliperodsdev.fifastats.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "champions_id")
    private ChampionsLeague championsLeague;

    @OneToOne
    @JoinColumn(name = "league_id")
    private League league;

    private Long motm;

    private Long numberMatchs;

    private Long wins; 

}
