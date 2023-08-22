package com.feliperodsdev.fifastats.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_league")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "league", cascade = CascadeType.ALL)
    private Season season;

    private Long gols;

    private Long assists;

    private Long place;

    private Boolean playerOfTournament;

    public Long getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public Long getGols() {
        return gols;
    }

    public Long getAssists() {
        return assists;
    }

    public Long getPlace() {
        return place;
    }

    public Boolean getPlayerOfTournament() {
        return playerOfTournament;
    }

    public static League create(Long gols, Long assists, Long place, Boolean playerOfTournament){
        League actualLeague = new League();

        if(!actualLeague.isValidGols(gols)) throw new IllegalArgumentException();
        if(!actualLeague.isValidAssists(assists)) throw new IllegalArgumentException();
        if(!actualLeague.isValidPlace(place)) throw new IllegalArgumentException();

        actualLeague.gols = gols;
        actualLeague.assists = assists;
        actualLeague.place = place;
        actualLeague.playerOfTournament = playerOfTournament;

        return actualLeague;
    }

    public boolean isValidGols(Long gols){
        if(gols < 0) return false;
        return true;
    }

    public boolean isValidAssists(Long assists){
        if(assists < 0) return false;
        return true;
    }

    public boolean isValidPlace(Long place) {
        if(place > 20 || place < 1) return false;
        return true;
    }

}
