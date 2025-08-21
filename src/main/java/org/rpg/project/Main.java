package org.rpg.project;

import org.rpg.project.characters.heroes.classes.Archer;
import org.rpg.project.characters.heroes.classes.Mage;
import org.rpg.project.characters.heroes.classes.Warrior;
import org.rpg.project.enums.AbilityType;
import org.rpg.project.enums.ItemType;
import org.rpg.project.enums.MagicType;

public class Main {
    public static void main(String[] args) {
        Mage merlin = new Mage("Merlin",100,"Feiticeiros", MagicType.ICE);
        Archer legolas = new Archer("Legolas",50,"Atiradores", AbilityType.ARCHER);
        Warrior conan = new Warrior("Conan",50,"Lutadores", AbilityType.WARRIOR);

        merlin.listMageMagics();
        merlin.learnNewMagicStyle(MagicType.FIRE);

        legolas.listArcherAbilities();

        conan.listWarriorAbilities();

        merlin.listMageMagics();
        legolas.listArcherAbilities();
        conan.listWarriorAbilities();

        conan.getInventory().addItem(ItemType.SWORD,60);

        merlin.getInventory().showInventory();
        legolas.getInventory().showInventory();
        conan.getInventory().showInventory();

    }
}
