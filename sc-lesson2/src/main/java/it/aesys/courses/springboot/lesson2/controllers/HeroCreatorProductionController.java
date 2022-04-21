package it.aesys.courses.springboot.lesson2.controllers;


import it.aesys.courses.springboot.lesson2.model.hero.Hero;
import it.aesys.courses.springboot.lesson2.request.HeroRequest;
import it.aesys.courses.springboot.lesson2.services.hero.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Profile("production")
@RequestMapping("api/hero")
public class HeroCreatorProductionController {

    @Autowired
    private HeroService heroService;

    @PostMapping
    public Hero createHero( @Valid @RequestBody HeroRequest request) {

        return heroService.insert(request.getHero());

    }

    @PutMapping("{id}")
    public Hero updateHero(@PathVariable String id,   @RequestBody HeroRequest request) {

        return heroService.update(request.getHero(),id);

    }

    @DeleteMapping("{id}")
    public void deleteHero(@PathVariable String id) {
        heroService.delete(id);
    }

    @GetMapping
    public List<Hero> findAll() {

        List<Hero> list = new ArrayList<>();

        return heroService.findAll();

    }


    @GetMapping("{id}")
    public Hero find(@PathVariable String id) {


        return heroService.find(id);

    }
}
