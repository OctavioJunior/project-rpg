package org.rpg.project.itens;

import org.rpg.project.enums.ItemType;

public class ItemStack {
    private final ItemType type;
    private int quantity;

    public ItemStack(ItemType type, int quantity) {
        this.type = type;
        this.quantity = Math.min(quantity, type.getMaxQuantity());
    }

    public ItemType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity = Math.min(this.quantity + amount, type.getMaxQuantity());
    }

    public void removeQuantity(int amount) {
        this.quantity = Math.max(this.quantity - amount, 0);
    }

    public boolean isEmpty() {
        return quantity == 0;
    }
}

