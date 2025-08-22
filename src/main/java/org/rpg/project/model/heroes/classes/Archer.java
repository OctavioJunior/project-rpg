package org.rpg.project.model.heroes.classes;

import org.rpg.project.model.heroes.Hero;
import org.rpg.project.core.enums.AbilityType;
import org.rpg.project.core.interfaces.Ability;
import org.rpg.project.model.itens.Inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Archer extends Hero {
    public int energy;
    public Set<AbilityType> abilityType;
    public List<Ability> abilitiesLearned;

    public Archer(String name,int energy, String guild, AbilityType abilityType){
        super(name, guild,1,0,100, new Inventory(30));
        this.energy = energy;
        this.abilityType = new HashSet<>();
        this.abilitiesLearned = new ArrayList<>();
        this.abilityType.add(abilityType);
        learnNewAbility();
    }

    public void learnNewAbility(){
        for (AbilityType abilityType : this.abilityType) {
            for (Ability ability : abilityType.enableAbility()){
                if (ability.getLevel() <= this.level && !abilitiesLearned.contains(ability)){
                    abilitiesLearned.add(ability);
                    System.out.println("Nova habilidade aprendida: " + ability);
                }
            }
        }
    }

    public void listArcherAbilities(){
        System.out.println("Listando habilidades do personagem");
        for (Ability ability : abilitiesLearned){
            System.out.println("Nome: " + ability.getName() + ", Estilo: " + ability.getAbilityStyle());
        }
    }
}


