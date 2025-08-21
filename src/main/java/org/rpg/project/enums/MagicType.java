package org.rpg.project.enums;

import org.rpg.project.abilities.heroes.MagicLevel;

import java.util.List;

public enum MagicType {
    AIR{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Tornado",1,AIR,5),
                    new MagicLevel("Flutuar",3,AIR,7),
                    new MagicLevel("Vendaval Furioso",5,AIR,8)
            );
        }
    },
    DARKNESS{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Escurecer",1,DARKNESS,5),
                    new MagicLevel("Roubar Alma",3,DARKNESS,7),
                    new MagicLevel("Reerguer",5,DARKNESS,8)
            );
        }
    },
    FIRE{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Bola de Fogo",1,FIRE,5),
                    new MagicLevel("Parede de Chamas",3,FIRE,7),
                    new MagicLevel("Lava",5,FIRE,8)
            );
        }
    },
    GODNESS{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Curar",1,GODNESS,5),
                    new MagicLevel("Purificar",3,GODNESS,7),
                    new MagicLevel("Iluminar",5,GODNESS,8)
            );
        }
    },
    ICE{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Espinho de Gelo",1,ICE,5),
                    new MagicLevel("Nevasca",3,ICE,7),
                    new MagicLevel("Parede de Gelo",5,ICE,8)
            );
        }
    },
    STONE{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Bloco de Pedra",1,STONE,5),
                    new MagicLevel("Terreno Movediço",3,STONE,7),
                    new MagicLevel("Terremoto",4,STONE,8)
            );
        }
    },
    THUNDER{
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Raio Rápido",1,THUNDER,5),
                    new MagicLevel("Rede de Choque",3,THUNDER,7),
                    new MagicLevel("Relâmpago",4,THUNDER,8)
            );
        }
    },
    WATHER {
        @Override
        public List<MagicLevel> enableMagic(){
            return List.of(
                    new MagicLevel("Jato de Água",1,WATHER,5),
                    new MagicLevel("Chuva de Bolhas",3,WATHER,7),
                    new MagicLevel("Prisão de Água",4,WATHER,8)
            );
        }
    }
    ;

    public abstract List<MagicLevel> enableMagic();
}
