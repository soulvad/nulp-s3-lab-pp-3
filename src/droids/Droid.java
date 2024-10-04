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

    public void takeDamage(int damage) {
        this.health -= damage - this.defense;
    }

    public void takeHeal(int heal) {
        this.health += heal;
    }

    public abstract void attack(Droid enemy);
}