package com.github.advdrop.handler;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface DropHandler {

    public void breakBlock(Block block, Player player, ItemStack is);

}
