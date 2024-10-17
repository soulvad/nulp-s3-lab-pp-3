package droids;

import java.util.List;

public abstract class Droid {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected int damage;
    protected int defense;

    public Droid(String name, int health, int damage, int defense) {
        this.name = name;
        this.currentHealth = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public String takeDamage(Droid droid) {
        if(droid.getDamage() - this.defense > 0) {
            this.currentHealth -= droid.getDamage() - this.defense;
        }
        return "";
    }

    public void takeReflectDamage(int reflectDamage) {
        this.currentHealth -= reflectDamage;
    }

    public void takeHeal(int heal) {
        this.currentHealth += heal;
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
    }

    public abstract List<String> attack(Droid enemy, Droid teammate);
}