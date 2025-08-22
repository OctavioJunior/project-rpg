package org.rpg.project.model.heroes;

import org.rpg.project.model.itens.Inventory;

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
    
    // Getters públicos para acesso aos campos
    public String getName() {
        return name;
    }
    
    public String getGuild() {
        return guild;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getXp() {
        return xp;
    }
}
