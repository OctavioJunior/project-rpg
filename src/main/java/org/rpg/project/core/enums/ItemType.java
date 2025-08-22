package org.rpg.project.core.enums;

public enum ItemType {
    POTION_HEALTH("Poção de Vida", 5),
    POTION_MANA("Poção de Mana", 5),
    SWORD("Espada", 1),
    SHIELD("Escudo", 1),
    BOW("Arco", 1),
    ARROW("Flechas", 30),
    GEM("Gema Misteriosa", 99);

    private final String name;
    private final int maxQuantity;

    ItemType(String name, int maxQuantity) {
        this.name = name;
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }
}
