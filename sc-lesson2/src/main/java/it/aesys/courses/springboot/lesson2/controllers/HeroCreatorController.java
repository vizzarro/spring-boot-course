package it.aesys.courses.springboot.lesson2.controllers;

import it.aesys.courses.springboot.lesson2.model.hero.Hero;
import it.aesys.courses.springboot.lesson2.services.hero.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/hero")
@Profile("devel")
public class HeroCreatorController {
    

    @Autowired
    private HeroServiceImpl heroService;

    @PostMapping
    public Hero createhero(@Valid @RequestBody Hero hero) {

        return  heroService.insert(hero);

    }

    @PutMapping("{id}")
    public Hero  savehero(@RequestBody Hero hero, @PathVariable  String id) {

        return  heroService.update(hero, id);

    }

    @GetMapping("{id}")
    public Hero find( @PathVariable  String id) {

        return  heroService.find(id);
    }

    @GetMapping
    public List<Hero> findAll() {
        return heroService.findAll();
    }

}
