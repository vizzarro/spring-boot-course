package it.aesys.courses.springboot.lesson2.services.hero;

import it.aesys.courses.springboot.lesson2.model.hero.Hero;

import java.util.List;

public interface HeroService {

    public Hero insert(Hero hero);

    public Hero update(Hero hero, String id);

    public List<Hero> findAll();

    public Hero find(String id) ;

    void delete(String id) ;
}
