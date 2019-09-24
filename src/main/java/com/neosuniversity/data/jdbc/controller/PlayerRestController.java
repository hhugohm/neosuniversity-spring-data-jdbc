package com.neosuniversity.data.jdbc.controller;

import com.neosuniversity.data.jdbc.domain.Country;
import com.neosuniversity.data.jdbc.domain.Player;
import com.neosuniversity.data.jdbc.domain.ResponsePlayer;
import com.neosuniversity.data.jdbc.repositpory.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PlayerRestController {

    @Autowired
    private PlayerRepository repository;

    @GetMapping(path = "/player",produces = "application/json")
    public ResponsePlayer createPlayer(){

        Country country = new Country("MEXICO");
        Player player = new Player("MEMO","OCHOA", country);
        Player player2 = new Player("GUILLERMO","LAYUN", country);
        repository.save(player);
        repository.save(player2);
        repository.delete(player2);

        ResponsePlayer lst= new ResponsePlayer(toList(repository.findAll()));

        return lst;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
