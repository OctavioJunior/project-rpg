package org.rpg.project.itens;

import org.rpg.project.enums.ItemType;

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
                stack.addQuantity(quantity);
                return true;
            }
        }

        if (items.size() < maxSlots) {
            items.add(new ItemStack(type, quantity));
            return true;
        }

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

