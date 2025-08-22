package org.rpg.project.core.interfaces;

import org.rpg.project.core.enums.AbilityType;

public interface Ability {
    String getName();
    int getLevel();
    AbilityType getAbilityStyle();
    int getEnergyCost();
}
