package com.example.angular.tour_of_heroes_backend.controller;

import com.example.angular.tour_of_heroes_backend.model.Hero;
import com.example.angular.tour_of_heroes_backend.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/heroes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HeroController {
    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/{id}")
    public Hero getById(@PathVariable("id") Long id){
        return heroRepository.findOne(id);
    }

    @GetMapping
    public Iterable<Hero> getByName(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (name.isEmpty())
            return heroRepository.findAll();
        return heroRepository.findByName(name);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Hero update(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Hero add(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") long id) {
        heroRepository.delete(id);
    }
}
