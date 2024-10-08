package droids;

import java.util.List;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;

    public Droid(String name, int health, int damage, int defense) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String takeDamage(int damage) {
        this.health -= damage - this.defense;
        return "";
    }

    public void takeReflectDamage(int reflectDamage) {
        this.health -= reflectDamage;
    }

    public void takeHeal(int heal) {
        this.health += heal;
    }

    public abstract List<String> attack(Droid enemy, Droid teammate);
}