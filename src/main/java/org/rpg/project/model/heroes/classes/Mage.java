package org.rpg.project.model.heroes.classes;

import org.rpg.project.model.heroes.Hero;
import org.rpg.project.core.enums.MagicType;
import org.rpg.project.core.interfaces.Magic;
import org.rpg.project.model.itens.Inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mage extends Hero {
    public int mana;
    public Set<MagicType> magicType;
    public List<Magic> magicsLearned;

    public Mage(String name,int mana, String guild, MagicType magicType){
        super(name, guild,1,0,100, new Inventory(15));
        this.mana = mana;
        this.magicType = new HashSet<>();
        this.magicsLearned = new ArrayList<>();
        this.magicType.add(magicType);
        learnNewMagic();
    }

    public void learnNewMagicStyle(MagicType magicType){
        if (this.magicType.size() >= 3) {
            System.out.println("Já domina o maximo de estilos possíveis para o personagem");
            return;
        }

        this.magicType.add(magicType);
        System.out.println("Conhecimento do estilo " + magicType);
        learnNewMagic();
    }

    public void learnNewMagic(){
        for (MagicType magicType : this.magicType) {
            for (Magic magic : magicType.enableMagic()){
                if (magic.getLevel() <= this.level && !magicsLearned.contains(magic)){
                    magicsLearned.add(magic);
                    System.out.println("Nova magia aprendida: " + magic);
                }
            }
        }
    }

    public void listMageMagics(){
        System.out.println("Listando magias do personagem");
        for (Magic magic : magicsLearned){
            System.out.println("Nome: " + magic.getName() + ", Estilo: " + magic.getMagicStyle());
        }
    }
}
