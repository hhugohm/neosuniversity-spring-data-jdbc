package com.neosuniversity.data.jdbc.controller;

import com.neosuniversity.data.jdbc.domain.Country;
import com.neosuniversity.data.jdbc.domain.Hobby;
import com.neosuniversity.data.jdbc.domain.Player;
import com.neosuniversity.data.jdbc.domain.ResponsePlayer;
import com.neosuniversity.data.jdbc.repositpory.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PlayerRestController {

    @Autowired
    private PlayerRepository repository;

    @GetMapping(path = "/player",produces = "application/json")
    public List<Player> createPlayer(){

        Country country1 = new Country("MEXICO");
        Country country2 = new Country("INGLATERRA");
        Hobby hobby1= new Hobby("CANTAR");
        Hobby hobby2= new Hobby("JUGAR BASKETBALL");
        Hobby hobby3= new Hobby("NADAR");
        Map<Integer,Hobby> mapHobbies = new HashMap<>();
        mapHobbies.put(1,hobby1);
        mapHobbies.put(2,hobby2);
        mapHobbies.put(3,hobby3);


        Player player = new Player("MEMO","OCHOA", country1,mapHobbies);
        Player player2 = new Player("FRANK","LAMPAR", country2);
        repository.save(player);
        repository.save(player2);
        player2.setMapTeam(mapHobbies);
        repository.save(player2);
        //repository.delete(player2);

        //ResponsePlayer lst= new ResponsePlayer(toList(repository.findAll()));

        //return lst;

        return toList(repository.findAll());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
