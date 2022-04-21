package it.aesys.courses.springboot.lesson2.controllers;


import it.aesys.courses.springboot.lesson2.model.hero.Hero;
import it.aesys.courses.springboot.lesson2.request.HeroRequest;
import it.aesys.courses.springboot.lesson2.services.hero.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Profile("production")
@RequestMapping("api/hero")
public class HeroCreatorProductionController {

    @Autowired
    private HeroService heroService;

    @PostMapping
    public ResponseEntity<Hero> createHero( @RequestBody HeroRequest request) {

        return ResponseEntity.ok(heroService.insert(request.getHero()));

    }

    @PutMapping("{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable String id,   @RequestBody HeroRequest request) {

        return ResponseEntity.ok(heroService.update(request.getHero(),id));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHero(@PathVariable String id) {
        heroService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Hero>> findAll() {

        List<Hero> list = new ArrayList<>();

        return ResponseEntity.ok(heroService.findAll());

    }


    @GetMapping("{id}")
    public ResponseEntity<Hero> find(@PathVariable String id) {


        return ResponseEntity.ok(heroService.find(id));

    }
}
