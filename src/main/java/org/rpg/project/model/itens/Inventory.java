package org.rpg.project.model.itens;

import org.rpg.project.core.enums.ItemType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final int maxSlots;
    private final List<ItemStack> items;

    public Inventory(int maxSlots) {
        this.maxSlots = maxSlots;
        this.items = new ArrayList<>();
    }

    public boolean addItem(ItemType type, int quantity) {
        for (ItemStack stack : items) {
            if (stack.getType() == type) {
                int oldQuantity = stack.getQuantity();
                stack.addQuantity(quantity);
                int newQuantity = stack.getQuantity();
                
                if (newQuantity < oldQuantity + quantity) {
                    System.out.println("⚠️ Não foi possível adicionar todos os itens. Limite máximo de " + type.getName() + " atingido (" + type.getMaxQuantity() + ").");
                }
                return true;
            }
        }

        if (items.size() < maxSlots) {
            items.add(new ItemStack(type, quantity));
            if (quantity > type.getMaxQuantity()) {
                System.out.println("⚠️ Não foi possível adicionar todos os itens. Limite máximo de " + type.getName() + " atingido (" + type.getMaxQuantity() + ").");
            }
            return true;
        }

        System.out.println("❌ Inventário cheio! Não há mais espaço para adicionar " + type.getName() + ". Slots disponíveis: 0/" + maxSlots);
        return false;
    }

    public void removeItem(ItemType type, int quantity) {
        items.removeIf(stack -> {
            if (stack.getType() == type) {
                stack.removeQuantity(quantity);
                return stack.isEmpty();
            }
            return false;
        });
    }

    public void showInventory() {
        System.out.println("📦 Inventário:");
        for (ItemStack stack : items) {
            System.out.println("- " + stack.getType().getName() + " x" + stack.getQuantity());
        }
    }
}

