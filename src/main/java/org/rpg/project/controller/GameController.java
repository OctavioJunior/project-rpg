package org.rpg.project.controller;

import org.rpg.project.service.GameService;
import org.rpg.project.view.ConsoleView;
import org.rpg.project.model.heroes.Hero;
import org.rpg.project.model.heroes.classes.Archer;
import org.rpg.project.model.heroes.classes.Mage;
import org.rpg.project.model.heroes.classes.Warrior;
import org.rpg.project.enums.AbilityType;
import org.rpg.project.enums.MagicType;
import org.rpg.project.enums.ItemType;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final ConsoleView view;
    
    public GameController() {
        this.gameService = new GameService();
        this.view = new ConsoleView();
    }
    
    /**
     * Inicia o loop principal do jogo
     */
    public void startGame() {
        view.showTitle();
        gameService.startGame();
        
        while (gameService.isRunning()) {
            switch (gameService.getGameState()) {
                case "MENU" -> showMainMenu();
                case "CHARACTER_CREATION" -> handleCharacterCreation();
                case "GAME_PLAY" -> handleGamePlay();
                case "EXIT" -> gameService.stopGame();
                default -> {
                    view.showError("Estado do jogo inválido!");
                    gameService.setGameState("MENU");
                }
            }
        }
        
        view.showMessage("Obrigado por jogar! 👋");
        view.close();
    }
    
    /**
     * Exibe o menu principal
     */
    private void showMainMenu() {
        List<String> options = Arrays.asList(
            "🆕 Criar Novo Personagem",
            "🎮 Jogar" + (gameService.hasActivePlayer() ? " (" + gameService.getPlayerInfo() + ")" : ""),
            "❌ Sair"
        );
        
        view.showMenu("Menu Principal", options);
        
        int choice = view.getIntInput("Escolha uma opção");
        
        switch (choice) {
            case 1 -> gameService.setGameState("CHARACTER_CREATION");
            case 2 -> {
                if (gameService.hasActivePlayer()) {
                    gameService.setGameState("GAME_PLAY");
                } else {
                    view.showError("Você precisa criar um personagem primeiro!");
                    view.waitForEnter();
                }
            }
            case 3 -> gameService.setGameState("EXIT");
            default -> {
                view.showError("Opção inválida!");
                view.waitForEnter();
            }
        }
    }
    
    /**
     * Gerencia a criação de personagens
     */
    private void handleCharacterCreation() {
        view.showSeparator();
        view.showMessage("🧙‍♂️ CRIAÇÃO DE PERSONAGEM 🧙‍♂️");
        
        // Escolha da classe
        List<String> classOptions = Arrays.asList(
            "🧙‍♂️ Mago - Especialista em magias elementais",
            "🏹 Arqueiro - Mestre em combate à distância",
            "⚔️ Guerreiro - Especialista em combate corpo a corpo"
        );
        
        view.showMenu("Escolha sua classe", classOptions);
        int classChoice = view.getIntInput("Classe");
        
        // Nome do personagem
        String name = view.getInput("Digite o nome do seu personagem");
        if (name.isEmpty()) {
            view.showError("Nome não pode estar vazio!");
            view.waitForEnter();
            return;
        }
        
        // Guilda
        String guild = view.getInput("Digite o nome da sua guilda");
        if (guild.isEmpty()) {
            guild = "Aventureiros";
        }
        
        Hero createdHero = null;
        
        switch (classChoice) {
            case 1 -> createdHero = createMage(name, guild);
            case 2 -> createdHero = createArcher(name, guild);
            case 3 -> createdHero = createWarrior(name, guild);
            default -> {
                view.showError("Classe inválida!");
                view.waitForEnter();
                return;
            }
        }
        
        if (createdHero != null) {
            view.showSuccess("Personagem criado com sucesso!");
            view.showCharacterInfo(createdHero.getName(), createdHero.getGuild(), 
                createdHero.getLevel(), createdHero.getHealth());
            view.waitForEnter();
            gameService.setGameState("MENU");
        }
    }
    
    /**
     * Cria um personagem Mago
     */
    private Mage createMage(String name, String guild) {
        List<String> magicOptions = Arrays.asList(
            "🔥 FIRE - Magia do Fogo",
            "❄️ ICE - Magia do Gelo",
            "⚡ THUNDER - Magia do Trovão",
            "💧 WATER - Magia da Água",
            "💨 AIR - Magia do Ar",
            "🗿 STONE - Magia da Pedra",
            "🌑 DARKNESS - Magia das Trevas",
            "✨ GODNESS - Magia Divina"
        );
        
        // Array com a ordem correta dos tipos de magia correspondente ao menu
        MagicType[] magicTypesInOrder = {
            MagicType.FIRE,
            MagicType.ICE,
            MagicType.THUNDER,
            MagicType.WATHER, // Note: WATHER no enum (não WATER)
            MagicType.AIR,
            MagicType.STONE,
            MagicType.DARKNESS,
            MagicType.GODNESS
        };
        
        view.showMenu("Escolha seu tipo de magia inicial", magicOptions);
        int magicChoice = view.getIntInput("Tipo de magia");
        
        if (magicChoice >= 1 && magicChoice <= magicTypesInOrder.length) {
            return gameService.createMage(name, guild, magicTypesInOrder[magicChoice - 1]);
        }
        
        view.showError("Tipo de magia inválido!");
        return null;
    }
    
    /**
     * Cria um personagem Arqueiro
     */
    private Archer createArcher(String name, String guild) {
        return gameService.createArcher(name, guild, AbilityType.ARCHER);
    }
    
    /**
     * Cria um personagem Guerreiro
     */
    private Warrior createWarrior(String name, String guild) {
        return gameService.createWarrior(name, guild, AbilityType.WARRIOR);
    }
    
    /**
     * Gerencia o gameplay principal
     */
    private void handleGamePlay() {
        Hero player = gameService.getCurrentPlayer();
        
        List<String> gameOptions = Arrays.asList(
            "📊 Ver Status do Personagem",
            "🎒 Ver Inventário",
            "🎯 Ver Habilidades/Magias",
            "➕ Adicionar Item ao Inventário",
            "📚 Aprender Nova Magia" + (player instanceof Mage ? "" : " (Apenas Magos)"),
            "🔙 Voltar ao Menu Principal"
        );
        
        view.showMenu("Gameplay - " + gameService.getPlayerInfo(), gameOptions);
        
        int choice = view.getIntInput("Escolha uma ação");
        
        switch (choice) {
            case 1 -> showPlayerStatus();
            case 2 -> showPlayerInventory();
            case 3 -> showPlayerSkills();
            case 4 -> addItemToInventory();
            case 5 -> learnNewMagic();
            case 6 -> gameService.setGameState("MENU");
            default -> {
                view.showError("Opção inválida!");
                view.waitForEnter();
            }
        }
    }
    
    /**
     * Exibe status do jogador
     */
    private void showPlayerStatus() {
        Hero player = gameService.getCurrentPlayer();
        view.showCharacterInfo(player.getName(), player.getGuild(), player.getLevel(), player.getHealth());
        
        if (player instanceof Mage mage) {
            view.showMessage("🔮 Mana: " + mage.mana);
        } else if (player instanceof Archer archer) {
            view.showMessage("⚡ Energia: " + archer.energy);
        } else if (player instanceof Warrior warrior) {
            view.showMessage("⚡ Energia: " + warrior.energy);
        }
        
        view.waitForEnter();
    }
    
    /**
     * Exibe inventário do jogador
     */
    private void showPlayerInventory() {
        view.showMessage("🎒 === INVENTÁRIO ===");
        gameService.showPlayerInventory();
        view.waitForEnter();
    }
    
    /**
     * Exibe habilidades do jogador
     */
    private void showPlayerSkills() {
        view.showMessage("🎯 === HABILIDADES/MAGIAS ===");
        gameService.listPlayerSkills();
        view.waitForEnter();
    }
    
    /**
     * Adiciona item ao inventário
     */
    private void addItemToInventory() {
        List<String> itemOptions = Arrays.asList(
            "⚔️ ESPADA",
            "🛡️ ESCUDO",
            "🏹 ARCO",
            "🧪 POÇÃO DE VIDA",
            "💎 GEMA MÁGICA"
        );
        
        view.showMenu("Escolha um item para adicionar", itemOptions);
        int itemChoice = view.getIntInput("Item");
        
        ItemType[] itemTypes = {ItemType.SWORD, ItemType.SHIELD, ItemType.BOW, 
                               ItemType.POTION_HEALTH, ItemType.GEM};
        
        if (itemChoice >= 1 && itemChoice <= itemTypes.length) {
            int quantity = view.getIntInput("Quantidade");
            if (quantity > 0) {
                boolean success = gameService.addItemToPlayer(itemTypes[itemChoice - 1], quantity);
                if (success) {
                    view.showSuccess("Item adicionado com sucesso!");
                } else {
                    view.showError("Não foi possível adicionar o item!");
                }
            } else {
                view.showError("Quantidade deve ser maior que zero!");
            }
        } else {
            view.showError("Item inválido!");
        }
        
        view.waitForEnter();
    }
    
    /**
     * Aprende nova magia (apenas para Magos)
     */
    private void learnNewMagic() {
        if (!(gameService.getCurrentPlayer() instanceof Mage)) {
            view.showError("Apenas Magos podem aprender novas magias!");
            view.waitForEnter();
            return;
        }
        
        List<String> magicOptions = Arrays.asList(
            "🔥 FIRE - Magia do Fogo",
            "❄️ ICE - Magia do Gelo",
            "⚡ THUNDER - Magia do Trovão",
            "💧 WATER - Magia da Água",
            "💨 AIR - Magia do Ar",
            "🗿 STONE - Magia da Pedra",
            "🌑 DARKNESS - Magia das Trevas",
            "✨ GODNESS - Magia Divina"
        );
        
        // Array com a ordem correta dos tipos de magia correspondente ao menu
        MagicType[] magicTypesInOrder = {
            MagicType.FIRE,
            MagicType.ICE,
            MagicType.THUNDER,
            MagicType.WATHER, // Note: WATHER no enum (não WATER)
            MagicType.AIR,
            MagicType.STONE,
            MagicType.DARKNESS,
            MagicType.GODNESS
        };
        
        view.showMenu("Escolha um novo estilo de magia", magicOptions);
        int magicChoice = view.getIntInput("Tipo de magia");
        
        if (magicChoice >= 1 && magicChoice <= magicTypesInOrder.length) {
            boolean success = gameService.learnNewMagicStyle(magicTypesInOrder[magicChoice - 1]);
            if (success) {
                view.showSuccess("Nova magia aprendida com sucesso!");
            } else {
                view.showError("Não foi possível aprender a magia!");
            }
        } else {
            view.showError("Tipo de magia inválido!");
        }
        
        view.waitForEnter();
    }
}