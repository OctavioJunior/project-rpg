package org.rpg.project.interfaces;

import org.rpg.project.enums.AbilityType;

public interface Ability {
    String getName();
    int getLevel();
    AbilityType getAbilityStyle();
    int getEnergyCost();
}
