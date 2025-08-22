package org.rpg.project.service;

import org.rpg.project.model.heroes.Hero;
import org.rpg.project.model.heroes.classes.Archer;
import org.rpg.project.model.heroes.classes.Mage;
import org.rpg.project.model.heroes.classes.Warrior;
import org.rpg.project.enums.AbilityType;
import org.rpg.project.enums.MagicType;
import org.rpg.project.enums.ItemType;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Hero currentPlayer;
    private boolean gameRunning;
    private String gameState;
    
    public GameService() {
        this.gameRunning = false;
        this.gameState = "MENU";
    }
    
    /**
     * Inicia o jogo
     */
    public void startGame() {
        this.gameRunning = true;
        this.gameState = "MENU";
    }
    
    /**
     * Para o jogo
     */
    public void stopGame() {
        this.gameRunning = false;
    }
    
    /**
     * Verifica se o jogo está rodando
     */
    public boolean isRunning() {
        return gameRunning;
    }
    
    /**
     * Obtém o estado atual do jogo
     */
    public String getGameState() {
        return gameState;
    }
    
    /**
     * Define o estado do jogo
     */
    public void setGameState(String state) {
        this.gameState = state;
    }
    
    /**
     * Cria um novo personagem Mago
     */
    public Mage createMage(String name, String guild, MagicType magicType) {
        Mage mage = new Mage(name, 100, guild, magicType);
        this.currentPlayer = mage;
        return mage;
    }
    
    /**
     * Cria um novo personagem Arqueiro
     */
    public Archer createArcher(String name, String guild, AbilityType abilityType) {
        Archer archer = new Archer(name, 50, guild, abilityType);
        this.currentPlayer = archer;
        return archer;
    }
    
    /**
     * Cria um novo personagem Guerreiro
     */
    public Warrior createWarrior(String name, String guild, AbilityType abilityType) {
        Warrior warrior = new Warrior(name, 50, guild, abilityType);
        this.currentPlayer = warrior;
        return warrior;
    }
    
    /**
     * Obtém o jogador atual
     */
    public Hero getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Define o jogador atual
     */
    public void setCurrentPlayer(Hero player) {
        this.currentPlayer = player;
    }
    
    /**
     * Verifica se há um jogador ativo
     */
    public boolean hasActivePlayer() {
        return currentPlayer != null;
    }
    
    /**
     * Obtém lista de tipos de magia disponíveis
     */
    public List<MagicType> getAvailableMagicTypes() {
        List<MagicType> types = new ArrayList<>();
        types.add(MagicType.FIRE);
        types.add(MagicType.ICE);
        types.add(MagicType.THUNDER);
        types.add(MagicType.WATHER);
        types.add(MagicType.AIR);
        types.add(MagicType.STONE);
        types.add(MagicType.DARKNESS);
        types.add(MagicType.GODNESS);
        return types;
    }
    
    /**
     * Obtém lista de tipos de habilidade disponíveis
     */
    public List<AbilityType> getAvailableAbilityTypes() {
        List<AbilityType> types = new ArrayList<>();
        types.add(AbilityType.ARCHER);
        types.add(AbilityType.WARRIOR);
        return types;
    }
    
    /**
     * Adiciona item ao inventário do jogador atual
     */
    public boolean addItemToPlayer(ItemType itemType, int quantity) {
        if (currentPlayer != null) {
            return currentPlayer.getInventory().addItem(itemType, quantity);
        }
        return false;
    }
    
    /**
     * Exibe inventário do jogador atual
     */
    public void showPlayerInventory() {
        if (currentPlayer != null) {
            currentPlayer.getInventory().showInventory();
        }
    }
    
    /**
     * Aprende novo estilo de magia (apenas para Mago)
     */
    public boolean learnNewMagicStyle(MagicType magicType) {
        if (currentPlayer instanceof Mage mage) {
            mage.learnNewMagicStyle(magicType);
            return true;
        }
        return false;
    }
    
    /**
     * Lista habilidades do jogador atual
     */
    public void listPlayerSkills() {
        if (currentPlayer instanceof Mage mage) {
            mage.listMageMagics();
        } else if (currentPlayer instanceof Archer archer) {
            archer.listArcherAbilities();
        } else if (currentPlayer instanceof Warrior warrior) {
            warrior.listWarriorAbilities();
        }
    }
    
    /**
     * Obtém informações básicas do jogador
     */
    public String getPlayerInfo() {
        if (currentPlayer == null) {
            return "Nenhum personagem ativo";
        }
        
        String className = currentPlayer.getClass().getSimpleName();
        return String.format("%s - %s (Nível %d)", 
            currentPlayer.getName(), className, currentPlayer.getLevel());
    }
}