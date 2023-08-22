package com.feliperodsdev.fifastats.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_champions")
public class ChampionsLeague {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "championsLeague", cascade = CascadeType.ALL)
    private Season season;

    private Long gols;

    private Long assists;

    private Boolean playerOfTournament;

    private Long phase;

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

    public Boolean getPlayerOfTournament() {
        return playerOfTournament;
    }

    public Long getPhase() {
        return phase;
    }

    public static ChampionsLeague create(Long gols, Long assists, Boolean playerOfTournament, Long phase){
        ChampionsLeague championsLeague = new ChampionsLeague();

        if(!championsLeague.isValidGols(gols)) throw new IllegalArgumentException();
        if(!championsLeague.isValidAssists(assists)) throw new IllegalArgumentException();
        if(!championsLeague.isValidPhase(phase)) throw new IllegalArgumentException();

        championsLeague.gols = gols;
        championsLeague.assists = assists;
        championsLeague.playerOfTournament = playerOfTournament;
        championsLeague.phase = phase;

        return championsLeague;
    }

    public boolean isValidGols(Long gols){
        if(gols < 0) return false;
        return true;
    }

    public boolean isValidAssists(Long assists){
        if(assists < 0) return false;
        return true;
    }

    public boolean isValidPhase(Long phase) {
        if(phase < 6 && phase > 0) return false;
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
