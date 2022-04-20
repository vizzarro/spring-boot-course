package it.aesys.courses.springboot.lesson2.request;

import it.aesys.courses.springboot.lesson2.model.hero.ClassHero;
import it.aesys.courses.springboot.lesson2.model.hero.Hero;

public class HeroRequest {

    private ClassHero classHero;
    private Hero hero;

    public HeroRequest(ClassHero classHero) {
        this.classHero = classHero;
    }

    public ClassHero getClasHero() {
        return classHero;
    }

    public void setClasHero(ClassHero classHero) {
        this.classHero = classHero;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
