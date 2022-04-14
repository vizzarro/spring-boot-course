package it.aesys.courses.springboot.lesson2.dao;

import it.aesys.courses.springboot.lesson2.model.hero.Hero;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class HeroRepository {

    Map<String, Hero> heroInMemDatabaseMap = new HashMap<>();

    public Hero save(Hero hero) {
        hero.setId(UUID.randomUUID().toString());
        hero.setCreationDate(new Date());
        heroInMemDatabaseMap.put(hero.getId(),hero);
        return hero;
    }

    public Hero update(Hero hero, String id) {
        if (!id.equals(hero.getId())) throw new  RuntimeException("Id is not valid");
        if (heroInMemDatabaseMap.containsKey(id)) {
            Hero oldHero = heroInMemDatabaseMap.get(id);
            oldHero.setUpdatingDate(new Date());
            oldHero.setAge(hero.getAge());
            oldHero.setName(hero.getName());
            oldHero.setCharm(hero.getCharm());
            oldHero.setDexterity(hero.getDexterity());
            oldHero.setForce(hero.getForce());
            oldHero.setReflex(hero.getReflex());
            oldHero.setIntellect(hero.getIntellect());
            oldHero.setStamina(hero.getStamina());
            oldHero.setThougness(hero.getThougness());
            oldHero.setWill(hero.getWill());
            oldHero.setWisdom(hero.getWisdom());
            oldHero.setWounds(hero.getWounds());

            return oldHero;
        }

        return null;
    }


    public List<Hero> findAll() {
        return heroInMemDatabaseMap.values().stream().collect(Collectors.toList());
    }


    public Hero find(String id) {
        return heroInMemDatabaseMap.get(id);
    }


}
