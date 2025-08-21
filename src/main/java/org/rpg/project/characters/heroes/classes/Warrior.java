package org.rpg.project.characters.heroes.classes;

import org.rpg.project.characters.heroes.Hero;
import org.rpg.project.enums.AbilityType;
import org.rpg.project.interfaces.Ability;
import org.rpg.project.itens.Inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warrior extends Hero {
    public int energy;
    public Set<AbilityType> abilityType;
    public List<Ability> abilitiesLearned;

    public Warrior(String name,int energy, String guild, AbilityType abilityType){
        super(name, guild,1,0,100, new Inventory(20));
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

    public void listWarriorAbilities(){
        System.out.println("Listando habilidades do personagem");
        for (Ability ability : abilitiesLearned){
            System.out.println("Nome: " + ability.getName() + ", Estilo: " + ability.getAbilityStyle());
        }
    }
}
