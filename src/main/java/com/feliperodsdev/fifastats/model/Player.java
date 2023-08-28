package com.feliperodsdev.fifastats.model;

import com.feliperodsdev.fifastats.model.exceptions.EntityValidationException;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tb_players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Season> seasons;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player() {}

    public static Player create(String name){
        Player player = new Player();

        if(!player.isValidName(name)) throw new EntityValidationException("'name' invalid.");

        player.name = name;

        return player;
    }

    public boolean isValidName(String name){

        if(name.isEmpty()) return false;

        return true;
    }

}
