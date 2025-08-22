package org.rpg.project;

import org.rpg.project.controller.GameController;

/**
 * Classe principal do RPG Adventure
 * Agora utiliza arquitetura MVC para melhor organização e escalabilidade
 */
public class Main {
    public static void main(String[] args) {
        // Inicia o jogo usando a nova arquitetura MVC
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
