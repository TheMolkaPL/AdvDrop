package com.github.advdrop.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
@RequiredArgsConstructor
public class DropContext {

    private final Player player;
    private final Block block;
    private final ItemStack tool;

    @Setter
    private ItemStack drop;
    private double chance;

    public void addChance(double chance) {
        this.chance = this.chance + chance;
    }

}
