package org.rpg.project.model.abilities.heroes;

import org.rpg.project.enums.MagicType;
import org.rpg.project.interfaces.Magic;

public class MagicLevel implements Magic {
    private final String name;
    private final int level;
    private final MagicType magicType;
    private final int manaCost;

    public MagicLevel(String name, int level, MagicType magicType, int manaCost) {
        this.name = name;
        this.level = level;
        this.magicType = magicType;
        this.manaCost = manaCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public MagicType getMagicStyle() {
        return magicType;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MagicLevel that = (MagicLevel) obj;
        return level == that.level && 
               manaCost == that.manaCost && 
               name.equals(that.name) && 
               magicType == that.magicType;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, level, magicType, manaCost);
    }

    @Override
    public String toString() {
        return name + " (Nível " + level + ", " + magicType + ", Custo: " + manaCost + " mana)";
    }
}
