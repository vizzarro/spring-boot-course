package it.aesys.courses.springboot.lesson2.model.hero;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Hero {

    private String id;
    @NotBlank
    private String name;
    private ClassHero type;
    private Short age;
    private Integer wounds;
    private Integer stamina;
    private Integer force;
    private Integer dexterity;
    private Integer wisdom;
    private Integer intellect;
    private Integer charm;

    private Integer thougness;
    private Integer reflex;
    private Integer will;

    private Date creationDate;
    private Date updatingDate;
    
    
    

    public Hero() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassHero getType() {
        return type;
    }

    public void setType(ClassHero type) {
        this.type = type;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Integer getWounds() {
        return wounds;
    }

    public void setWounds(Integer wounds) {
        this.wounds = wounds;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer getCharm() {
        return charm;
    }

    public void setCharm(Integer charm) {
        this.charm = charm;
    }

    public Integer getThougness() {
        return thougness;
    }

    public void setThougness(Integer thougness) {
        this.thougness = thougness;
    }

    public Integer getReflex() {
        return reflex;
    }

    public void setReflex(Integer reflex) {
        this.reflex = reflex;
    }

    public Integer getWill() {
        return will;
    }

    public void setWill(Integer will) {
        this.will = will;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatingDate() {
        return updatingDate;
    }

    public void setUpdatingDate(Date updatingDate) {
        this.updatingDate = updatingDate;
    }
}
