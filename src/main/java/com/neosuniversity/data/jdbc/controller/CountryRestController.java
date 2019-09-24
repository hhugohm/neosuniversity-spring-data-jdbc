package com.neosuniversity.data.jdbc.controller;

import com.neosuniversity.data.jdbc.domain.Country;
import com.neosuniversity.data.jdbc.repositpory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CountryRestController {

    @Autowired
    private CountryRepository repository;

    @GetMapping("/country")
    public List<Country> createCountry(){

        repository.save(new Country("MEXICO"));
        repository.save(new Country("ITALIA"));


        return toList(repository.findAll());

    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
