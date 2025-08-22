package org.rpg.project.model.abilities.heroes;

import org.rpg.project.core.enums.AbilityType;
import org.rpg.project.core.interfaces.Ability;

public class AbilityLevel implements Ability {
    private final String name;
    private final int level;
    private final AbilityType abilityType;
    private final int energyCost;

    public AbilityLevel(String name, int level, AbilityType abilityType, int energyCost) {
        this.name = name;
        this.level = level;
        this.abilityType = abilityType;
        this.energyCost = energyCost;
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
    public AbilityType getAbilityStyle() {
        return abilityType;
    }

    @Override
    public int getEnergyCost() {
        return energyCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbilityLevel that = (AbilityLevel) obj;
        return level == that.level && 
               energyCost == that.energyCost && 
               name.equals(that.name) && 
               abilityType == that.abilityType;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, level, abilityType, energyCost);
    }

    @Override
    public String toString() {
        return name + " (Nível " + level + ", " + abilityType + ", Custo: " + energyCost + " energia)";
    }
}
