package org.rpg.project.enums;

import org.rpg.project.model.abilities.heroes.AbilityLevel;

import java.util.List;

public enum AbilityType {
    ARCHER{
        @Override
        public List<AbilityLevel> enableAbility(){
            return List.of(
                    new AbilityLevel("Rajada de Flechas",1,ARCHER,5),
                    new AbilityLevel("Tiro Certeiro",3,ARCHER,7),
                    new AbilityLevel("Chuva de Flechas",5,ARCHER,8)
            );
        }
    },
    WARRIOR {
        @Override
        public List<AbilityLevel> enableAbility() {
            return List.of(
                    new AbilityLevel("Golpe Rápido", 1, WARRIOR, 5),
                    new AbilityLevel("Golpe Pesado", 3, WARRIOR, 7),
                    new AbilityLevel("Golpe Giratório", 5, WARRIOR, 8)
            );
        }
    }
    ;

    public abstract List<AbilityLevel> enableAbility();
}
