package org.rpg.project.abilities.heroes;

import org.rpg.project.enums.AbilityType;
import org.rpg.project.interfaces.Ability;

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
}
