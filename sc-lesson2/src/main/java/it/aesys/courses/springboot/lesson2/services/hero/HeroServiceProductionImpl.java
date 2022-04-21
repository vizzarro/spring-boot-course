package it.aesys.courses.springboot.lesson2.services.hero;


import it.aesys.courses.springboot.lesson2.dao.HeroRepository;
import it.aesys.courses.springboot.lesson2.model.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("production")
public class HeroServiceProductionImpl implements HeroService{

    private HeroRepository repository;


    @Autowired
    public HeroServiceProductionImpl(HeroRepository repository) {
        this.repository = repository;;
    }

    public Hero insert(Hero hero) {
        return repository.save(hero);
    }

    public Hero update(Hero hero, String id) {
        return repository.update(hero,id);
    }

    public List<Hero> findAll() {
        return repository.findAll();
    }

    public Hero find(String id) {

        return repository.find(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
