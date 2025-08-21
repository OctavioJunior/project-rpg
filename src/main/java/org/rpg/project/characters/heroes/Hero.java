package org.rpg.project.characters.heroes;

import org.rpg.project.itens.Inventory;

public class Hero {
    protected String name;
    protected String guild;
    protected int level;
    protected int xp;
    protected int health;

    private final Inventory inventory;

    public Hero(String name, String guild, int level, int xp, int health, Inventory inventory) {
        this.name = name;
        this.guild = guild;
        this.level = level;
        this.xp = xp;
        this.health = health;
        this.inventory = new Inventory(15);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
