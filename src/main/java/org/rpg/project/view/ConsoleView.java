package org.rpg.project.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Exibe uma mensagem simples no console
     */
    public void showMessage(String message) {
        System.out.println("🎮 " + message);
    }
    
    /**
     * Exibe uma mensagem de erro
     */
    public void showError(String error) {
        System.out.println("❌ " + error);
    }
    
    /**
     * Exibe uma mensagem de sucesso
     */
    public void showSuccess(String success) {
        System.out.println("✅ " + success);
    }
    
    /**
     * Exibe o título do jogo
     */
    public void showTitle() {
        System.out.println("\n" +
            "╔══════════════════════════════════════╗\n" +
            "║          🏰 RPG ADVENTURE 🏰          ║\n" +
            "║     Bem-vindo ao mundo da magia!    ║\n" +
            "╚══════════════════════════════════════╝\n");
    }
    
    /**
     * Exibe um menu com opções numeradas
     */
    public void showMenu(String title, List<String> options) {
        System.out.println("\n=== " + title.toUpperCase() + " ===");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println();
    }
    
    /**
     * Captura input do usuário com prompt
     */
    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }
    
    /**
     * Captura input do usuário com prompt padrão
     */
    public String getInput() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }
    
    /**
     * Captura um número inteiro do usuário
     */
    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                showError("Por favor, digite um número válido!");
            }
        }
    }
    
    /**
     * Exibe uma linha separadora
     */
    public void showSeparator() {
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
    
    /**
     * Limpa a tela (simulado com quebras de linha)
     */
    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    /**
     * Pausa e aguarda o usuário pressionar Enter
     */
    public void waitForEnter() {
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Exibe informações de um personagem
     */
    public void showCharacterInfo(String name, String guild, int level, int health) {
        System.out.println("\n📊 === STATUS DO PERSONAGEM ===");
        System.out.println("👤 Nome: " + name);
        System.out.println("🏛️ Guilda: " + guild);
        System.out.println("⭐ Nível: " + level);
        System.out.println("❤️ Vida: " + health);
    }
    
    /**
     * Fecha o scanner
     */
    public void close() {
        scanner.close();
    }
}